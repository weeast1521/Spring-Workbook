package umc.study.domain.member.service.query;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.apiPayload.exception.InvalidPageException;
import umc.study.domain.member.entity.Member;
import umc.study.domain.member.repository.MemberRepository;
import umc.study.domain.review.entity.Review;
import umc.study.domain.review.repository.ReviewRepository;
import umc.study.domain.store.entity.Store;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getMyReviewList(Long memberId, Integer page) {

        if (page < 1) {
            throw new InvalidPageException("page 값은 1 이상이어야 합니다.");
        }

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(ErrorStatus._NOT_FOUND));

        Pageable pageable = PageRequest.of(page - 1, 10);  // page = 1 → 내부는 0
        return reviewRepository.findAllByMember(member, pageable);
    }
}
