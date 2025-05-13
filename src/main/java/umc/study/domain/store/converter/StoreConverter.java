package umc.study.domain.store.converter;

import umc.study.domain.store.dto.response.StoreResponseDTO;
import umc.study.domain.store.entity.Store;

public class StoreConverter {

    public static StoreResponseDTO.toStoreResponseDTO toStoreResponseDTO(Store store) {
        return StoreResponseDTO.toStoreResponseDTO.builder()
                .name(store.getName())
                .Score(store.getScore())
                .address(store.getAddress())
                .region(store.getRegion())
                .build();
    }
}
