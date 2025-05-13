package umc.study.domain.review.dto.response;

import lombok.Builder;
import umc.study.domain.member.entity.Member;
import umc.study.domain.store.entity.Store;

public class ReviewResponseDTO {

    @Builder
    public record toReviewRequestDTO (
            String title,
            Float score,
            Member member,
            Store store
    ) {}
}
