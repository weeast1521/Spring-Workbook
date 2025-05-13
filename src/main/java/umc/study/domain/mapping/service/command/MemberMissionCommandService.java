package umc.study.domain.mapping.service.command;

import umc.study.domain.mapping.dto.request.MemberMissionRequestDTO;
import umc.study.domain.mapping.dto.response.MemberMissionResponseDTO;

public interface MemberMissionCommandService {
    MemberMissionResponseDTO.toMemberMissionResponseDTO addProgressionMission(MemberMissionRequestDTO.toMemberMissionRequestDTO request);
}
