package umc.study.domain.mission.converter;

import umc.study.domain.mission.dto.response.MissionResponseDTO;
import umc.study.domain.mission.entity.Mission;

public class MissionConverter {

    public static MissionResponseDTO.toCreateMissionResponseDTO toCreateMissionResponseDTO(Mission mission) {
        return MissionResponseDTO.toCreateMissionResponseDTO.builder()
                .missionId(mission.getId())
                .reward(mission.getReward())
                .storeName(mission.getStore().getName())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .build();
    }
}
