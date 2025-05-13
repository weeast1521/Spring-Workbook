package umc.study.domain.member.service.command;

import umc.study.domain.member.dto.request.MemberRequestDTO;
import umc.study.domain.member.entity.Member;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
