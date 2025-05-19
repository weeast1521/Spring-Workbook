package umc.study.domain.mission.service.command;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mission.converter.MissionConverter;
import umc.study.domain.mission.dto.request.MissionRequestDTO;
import umc.study.domain.mission.dto.response.MissionResponseDTO;
import umc.study.domain.mission.entity.Mission;
import umc.study.domain.mission.repository.MissionRepository;
import umc.study.domain.store.entity.Store;
import umc.study.domain.store.repository.StoreRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public MissionResponseDTO.toCreateMissionResponseDTO createMission(MissionRequestDTO.toCreateMissionRequestDTO request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));

        Mission mission = Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .store(store)
                .build();

        missionRepository.save(mission);

        return MissionConverter.toCreateMissionResponseDTO(mission);
    }
}
