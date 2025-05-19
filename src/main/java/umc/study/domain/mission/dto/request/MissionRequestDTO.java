package umc.study.domain.mission.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class toCreateMissionRequestDTO {
        private Integer reward;
        private LocalDate deadline;
        private String missionSpec;
        private Long storeId;
    }
}
