package umc.study.domain.member.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.store.dto.response.StoreResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO{
        Long memberId;
        LocalDateTime createdAt;
    }

    @Builder
    public record ReviewPreViewListDTO (
            List<MemberResponseDTO.ReviewPreViewDTO> reviewList,
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