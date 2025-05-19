package umc.study.domain.review.dto.response;

import lombok.Builder;
import lombok.Getter;
import umc.study.domain.member.entity.Member;
import umc.study.domain.store.entity.Store;

import java.time.LocalDate;
import java.util.List;

public class ReviewResponseDTO {

    @Builder
    public record toReviewRequestDTO (
            String title,
            Float score,
            Member member,
            Store store
    ) {}
}
