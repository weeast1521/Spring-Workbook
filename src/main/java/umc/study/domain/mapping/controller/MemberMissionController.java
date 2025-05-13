package umc.study.domain.mapping.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.domain.mapping.dto.request.MemberMissionRequestDTO;
import umc.study.domain.mapping.dto.response.MemberMissionResponseDTO;
import umc.study.domain.mapping.service.command.MemberMissionCommandService;

@RestController
@RequiredArgsConstructor
public class MemberMissionController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/mission/update")
    public ApiResponse<MemberMissionResponseDTO.toMemberMissionResponseDTO> addProgressionMission(
            @RequestBody MemberMissionRequestDTO.toMemberMissionRequestDTO request
    ) {
        MemberMissionResponseDTO.toMemberMissionResponseDTO result = memberMissionCommandService.addProgressionMission(request);

        return ApiResponse.onSuccess(result);
    }
}
