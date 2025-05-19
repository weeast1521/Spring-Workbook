package umc.study.domain.mission.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.study.domain.member.entity.Member;
import umc.study.domain.mission.entity.Mission;
import umc.study.domain.mission.enums.Status;
import umc.study.domain.review.entity.Review;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    @Query("""
        SELECT m FROM Mission m
        JOIN m.memberMissionList mm
        WHERE mm.member = :member AND m.status = :status
    """)
    Page<Mission> findByMemberAndStatus(@Param("member") Member member,
                                        @Param("status") Status status,
                                        Pageable pageable);
}
