package umc.study.domain.mapping.service.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.dto.request.MemberMissionRequestDTO;
import umc.study.domain.mapping.dto.response.MemberMissionResponseDTO;
import umc.study.domain.mapping.enums.MissionStatus;
import umc.study.domain.mapping.repository.MemberMissionRepository;
import umc.study.domain.member.entity.Member;
import umc.study.domain.member.repository.MemberRepository;
import umc.study.domain.mission.entity.Mission;
import umc.study.domain.mission.repository.MissionRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    public MemberMissionResponseDTO.toMemberMissionResponseDTO addProgressionMission(MemberMissionRequestDTO.toMemberMissionRequestDTO request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow();

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow();

        MemberMission mm = MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .mission(mission)
                .member(member)
                .build();

        memberMissionRepository.save(mm);

        return MemberMissionResponseDTO.toMemberMissionResponseDTO.builder()
                .memberId(member.getId())
                .missionId(mission.getId())
                .build();
    }
}
