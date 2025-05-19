package umc.study.domain.mapping.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberMissionRequestDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class toMemberMissionRequestDTO {
        private Long memberId;
        private Long missionId;
    }

}
