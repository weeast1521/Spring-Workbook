package umc.study.domain.store.service.query;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.apiPayload.exception.InvalidPageException;
import umc.study.domain.review.entity.Review;
import umc.study.domain.review.repository.ReviewRepository;
import umc.study.domain.store.entity.Store;
import umc.study.domain.store.repository.StoreRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {

        if (page < 1) {
            throw new InvalidPageException("page 값은 1 이상이어야 합니다.");
        }

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new GeneralException(ErrorStatus._NOT_FOUND));

        Pageable pageable = PageRequest.of(page - 1, 10);  // page = 1 → 내부는 0
        return reviewRepository.findAllByStore(store, pageable);
    }
}
