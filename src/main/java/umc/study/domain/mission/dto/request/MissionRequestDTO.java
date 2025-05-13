package umc.study.domain.mission.dto.request;

import lombok.Builder;
import java.time.LocalDate;
import java.util.List;

public class MissionRequestDTO {

    @Builder
    public record toCreateMissionRequestDTO(
            Integer reward,
            LocalDate deadline,
            String missionSpec,
            Long storeId
    ) {}
}
