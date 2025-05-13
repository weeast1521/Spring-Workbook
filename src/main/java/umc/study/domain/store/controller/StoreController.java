package umc.study.domain.store.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.domain.store.dto.request.StoreRequestDTO;
import umc.study.domain.store.dto.response.StoreResponseDTO;
import umc.study.domain.store.service.command.StoreCommandService;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/stores")
    public ApiResponse<StoreResponseDTO.toStoreResponseDTO> updateStore(
            @RequestBody StoreRequestDTO.toStoreRequestDTO request
    ) {
        StoreResponseDTO.toStoreResponseDTO store = storeCommandService.createStore(request);
        return ApiResponse.onSuccess(store);
    }

}
