package umc.study.domain.mission.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class MissionResponseDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class toCreateMissionResponseDTO {
        private Long missionId;
        private Integer reward;
        private String storeName;
        private LocalDate deadline;
        private String missionSpec;
    }

}
