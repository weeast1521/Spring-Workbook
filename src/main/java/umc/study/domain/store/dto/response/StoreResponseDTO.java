package umc.study.domain.store.dto.response;

import lombok.Builder;
import lombok.Getter;
import umc.study.domain.region.entity.Region;

public class StoreResponseDTO {

    @Builder
    @Getter
    public static class toStoreResponseDTO {
        private String name;
        private String address;
        private Float Score;
        private Region region;
    }
}
