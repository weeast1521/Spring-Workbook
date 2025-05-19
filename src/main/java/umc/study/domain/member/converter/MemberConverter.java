package umc.study.domain.member.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.member.dto.request.MemberRequestDTO;
import umc.study.domain.member.entity.Member;
import umc.study.domain.member.dto.response.MemberResponseDTO;
import umc.study.domain.member.enums.Gender;
import umc.study.domain.mission.entity.Mission;
import umc.study.domain.review.entity.Review;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.ReviewPreViewDTO toReviewPreViewDTO(Review review){
        return MemberResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static MemberResponseDTO.ReviewPreViewListDTO toReviewPreViewListDTO(Page<Review> reviewList){

        List<MemberResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(MemberConverter::toReviewPreViewDTO).collect(Collectors.toList());

        return MemberResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static MemberResponseDTO.MissionPreViewDTO toMissionPreViewDTO(Mission mission){
        return MemberResponseDTO.MissionPreViewDTO.builder()
                .reward(mission.getReward())
                .storeName(mission.getStore().getName())
                .missionSpec(mission.getMissionSpec())
                .build();
    }

    public static MemberResponseDTO.MissionPreViewListDTO toMissionPreViewListDTO(Page<Mission> missionList){

        List<MemberResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MemberConverter::toMissionPreViewDTO).collect(Collectors.toList());

        return MemberResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}
