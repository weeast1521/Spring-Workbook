package umc.study.domain.store.service.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.region.entity.Region;
import umc.study.domain.region.repository.RegionRepository;
import umc.study.domain.store.converter.StoreConverter;
import umc.study.domain.store.dto.request.StoreRequestDTO;
import umc.study.domain.store.dto.response.StoreResponseDTO;
import umc.study.domain.store.entity.Store;
import umc.study.domain.store.repository.StoreRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public StoreResponseDTO.toStoreResponseDTO createStore(StoreRequestDTO.toStoreRequestDTO request) {
        Region region = regionRepository.findById(request.getRegion().getId())
                .orElseThrow(() -> new IllegalArgumentException("지역을 찾을 수 없습니다."));

        Store store =  Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .Score(request.getScore())
                .region(region)
                .build();

        storeRepository.save(store);

        return StoreConverter.toStoreResponseDTO(store);
    }
}
