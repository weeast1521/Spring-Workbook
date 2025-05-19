package umc.study.domain.store.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.region.entity.Region;

import java.time.LocalDate;
import java.util.List;

public class StoreResponseDTO {

    @Builder
    @Getter
    public static class toStoreResponseDTO {
        private String name;
        private String address;
        private Float Score;
        private Region region;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ReviewPreViewListDTO {
        private List<ReviewPreViewDTO> reviewList;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ReviewPreViewDTO {
        private String ownerNickname;
        private Float score;
        private String body;
        private LocalDate createdAt;
    }

}
