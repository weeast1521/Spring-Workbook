package umc.study.domain.review.dto.request;

import lombok.Builder;
import umc.study.domain.member.entity.Member;
import umc.study.domain.store.entity.Store;

public class ReviewRequestDTO {

    @Builder
    public record toReviewRequestDTO (
            String title,
            Float score,
            Member member,
            Store store
    ) {}
}
