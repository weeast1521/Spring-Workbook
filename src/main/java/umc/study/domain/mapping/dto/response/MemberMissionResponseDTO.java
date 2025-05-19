package umc.study.domain.mapping.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberMissionResponseDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class toMemberMissionResponseDTO {
        private Long memberId;
        private Long missionId;
    }

}
