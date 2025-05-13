package umc.study.domain.mission.service.command;

import umc.study.domain.mission.dto.request.MissionRequestDTO;
import umc.study.domain.mission.dto.response.MissionResponseDTO;

public interface MissionCommandService {
    MissionResponseDTO.toCreateMissionResponseDTO createMission(MissionRequestDTO.toCreateMissionRequestDTO request);
}
