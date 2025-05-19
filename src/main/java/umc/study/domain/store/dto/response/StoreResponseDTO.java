package umc.study.domain.store.dto.response;

import lombok.Builder;
import lombok.Getter;
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

    @Builder
    public record ReviewPreViewListDTO (
            List<ReviewPreViewDTO> reviewList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {}

    @Builder
    public record ReviewPreViewDTO (
            String ownerNickname,
            Float score,
            String body,
            LocalDate createdAt
    ) {}
}
