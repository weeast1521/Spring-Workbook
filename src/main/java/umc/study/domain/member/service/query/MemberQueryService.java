package umc.study.domain.member.service.query;

import org.springframework.data.domain.Page;
import umc.study.domain.mission.entity.Mission;
import umc.study.domain.mission.enums.Status;
import umc.study.domain.review.entity.Review;

public interface MemberQueryService {
    Page<Review> getMyReviewList(Long memberId, Integer page);
    Page<Mission> getMyProgressMissionList(Long memberId, Integer page, Status status);
}
