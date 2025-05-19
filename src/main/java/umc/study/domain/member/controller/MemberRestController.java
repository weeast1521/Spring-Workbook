package umc.study.domain.member.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.domain.member.converter.MemberConverter;
import umc.study.domain.member.dto.request.MemberRequestDTO;
import umc.study.domain.member.dto.response.MemberResponseDTO;
import umc.study.domain.member.entity.Member;
import umc.study.domain.member.service.command.MemberCommandService;
import umc.study.domain.member.service.query.MemberQueryService;
import umc.study.domain.review.entity.Review;
import umc.study.domain.store.converter.StoreConverter;
import umc.study.domain.store.dto.response.StoreResponseDTO;
import umc.study.validation.annotation.ExistMember;
import umc.study.validation.annotation.ExistStore;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "특정 멤버의 리뷰 목록 조회 API", description = "특정 멤버 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.
                    ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.
                    ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.
                    ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.
                    ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 아이디, path variable 입니다!")
    })
    public ApiResponse<MemberResponseDTO.ReviewPreViewListDTO> getMyReviewList(
            @ExistMember @PathVariable(name = "memberId") Long memberId,
            @RequestParam(name = "page") Integer page){
        Page<Review> reviewList = memberQueryService.getMyReviewList(memberId, page);

        return ApiResponse.onSuccess(MemberConverter.myReviewPreViewListDTO(reviewList));
    }
}
