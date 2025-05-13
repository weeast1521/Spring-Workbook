package umc.study.domain.mission.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.domain.mission.dto.request.MissionRequestDTO;
import umc.study.domain.mission.dto.response.MissionResponseDTO;
import umc.study.domain.mission.entity.Mission;

@RestController
@RequiredArgsConstructor
public class MissionController {

    @PostMapping("/missions")
    public ApiResponse<MissionResponseDTO.toMissionResponseDTO> postMission(
            @RequestBody MissionRequestDTO.toCreateMissionRequestDTO request
    ) {


    }
}
