package UMC.spring.study.web.controller;

import UMC.spring.study.apiPayload.ApiResponse;
import UMC.spring.study.converter.MemberConverter;
import UMC.spring.study.domain.Member;
import UMC.spring.study.service.MemberService.MemberCommandService;
import UMC.spring.study.service.MemberService.MemberCommandServiceImpl;
import UMC.spring.study.web.dto.MemberRequestDTO;
import UMC.spring.study.web.dto.MemberResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandServiceImpl memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
