package umc.study.domain.review.service.command;

import umc.study.domain.review.dto.request.ReviewRequestDTO;
import umc.study.domain.review.dto.response.ReviewResponseDTO;

public interface ReviewCommandService {
    ReviewResponseDTO.toReviewRequestDTO createReview(ReviewRequestDTO.toReviewRequestDTO request);
}
