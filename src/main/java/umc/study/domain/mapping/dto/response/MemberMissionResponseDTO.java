package umc.study.domain.mapping.dto.response;

import lombok.Builder;

public class MemberMissionResponseDTO {

    @Builder
    public record toMemberMissionResponseDTO(
            Long memberId,
            Long missionId
    ) {}
}
