package umc.study.domain.review.converter;

import umc.study.domain.review.dto.response.ReviewResponseDTO;
import umc.study.domain.review.entity.Review;


public class ReviewConverter {

    public static ReviewResponseDTO.toReviewRequestDTO toReviewRequestDTO(Review review) {
        return ReviewResponseDTO.toReviewRequestDTO.builder()
                .title(review.getTitle())
                .score(review.getScore())
                .member(review.getMember())
                .store(review.getStore())
                .build();
    }
}
