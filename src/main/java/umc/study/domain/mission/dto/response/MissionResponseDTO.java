package umc.study.domain.mission.dto.response;

import lombok.Builder;
import java.time.LocalDate;

public class MissionResponseDTO {

    @Builder
    public record toCreateMissionResponseDTO(
            Long missionId,
            Integer reward,
            String storeName,
            LocalDate deadline,
            String missionSpec
    ) {}
}
