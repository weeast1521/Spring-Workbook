package umc.study.domain.mission.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.domain.mission.dto.request.MissionRequestDTO;
import umc.study.domain.mission.dto.response.MissionResponseDTO;
import umc.study.domain.mission.entity.Mission;
import umc.study.domain.mission.service.command.MissionCommandService;

@RestController
@RequiredArgsConstructor
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/missions")
    public ApiResponse<MissionResponseDTO.toCreateMissionResponseDTO> postMission(
            @RequestBody MissionRequestDTO.toCreateMissionRequestDTO request
    ) {
        MissionResponseDTO.toCreateMissionResponseDTO mission = missionCommandService.createMission(request);

        return ApiResponse.onSuccess(mission);
    }
}
