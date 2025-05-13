package umc.study.domain.store.dto.request;

import lombok.Builder;
import lombok.Getter;
import umc.study.domain.region.entity.Region;


public class StoreRequestDTO {

    @Builder
    @Getter
    public static class toStoreRequestDTO {
        private String name;
        private String address;
        private Float Score;
        private Region region;
    }
}
