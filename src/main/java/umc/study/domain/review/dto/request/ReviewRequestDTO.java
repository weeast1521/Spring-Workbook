package umc.study.domain.review.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.member.entity.Member;
import umc.study.domain.store.entity.Store;

public class ReviewRequestDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class toReviewRequestDTO {
        private String title;
        private Float score;
        private Member member;
        private Store store;
    }

}
