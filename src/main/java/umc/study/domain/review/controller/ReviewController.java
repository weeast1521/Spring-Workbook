package umc.study.domain.review.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.domain.review.dto.request.ReviewRequestDTO;
import umc.study.domain.review.dto.response.ReviewResponseDTO;
import umc.study.domain.review.service.command.ReviewCommandService;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/reviews")
    public ApiResponse<ReviewResponseDTO.toReviewRequestDTO> createReview(
            @RequestBody ReviewRequestDTO.toReviewRequestDTO request
    ) {
        ReviewResponseDTO.toReviewRequestDTO review = reviewCommandService.createReview(request);

        return ApiResponse.onSuccess(review);
    }
}
