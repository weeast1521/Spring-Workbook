package umc.study.domain.mapping.dto.request;

import lombok.Builder;

public class MemberMissionRequestDTO {

    @Builder
    public record toMemberMissionRequestDTO(
            Long memberId,
            Long missionId
    ) {}
}
