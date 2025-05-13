package umc.study.domain.review.service.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.member.entity.Member;
import umc.study.domain.member.repository.MemberRepository;
import umc.study.domain.review.converter.ReviewConverter;
import umc.study.domain.review.dto.request.ReviewRequestDTO;
import umc.study.domain.review.dto.response.ReviewResponseDTO;
import umc.study.domain.review.entity.Review;
import umc.study.domain.review.repository.ReviewRepository;
import umc.study.domain.store.entity.Store;
import umc.study.domain.store.repository.StoreRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    public ReviewResponseDTO.toReviewRequestDTO createReview(ReviewRequestDTO.toReviewRequestDTO request) {

        Store store = storeRepository.findById(request.store().getId())
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));

        Member member = memberRepository.findById(request.member().getId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));

        Review review = Review.builder()
                .title(request.title())
                .score(request.score())
                .member(member)
                .store(store)
                .build();

        reviewRepository.save(review);

        return ReviewConverter.toReviewRequestDTO(review);
    }
}
