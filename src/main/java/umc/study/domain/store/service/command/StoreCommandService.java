package umc.study.domain.store.service.command;

import umc.study.domain.store.dto.request.StoreRequestDTO;
import umc.study.domain.store.dto.response.StoreResponseDTO;
import umc.study.domain.store.entity.Store;

public interface StoreCommandService {
    StoreResponseDTO.toStoreResponseDTO createStore(StoreRequestDTO.toStoreRequestDTO request);
}
