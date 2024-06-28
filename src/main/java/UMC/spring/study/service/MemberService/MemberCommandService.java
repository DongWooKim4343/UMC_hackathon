package UMC.spring.study.service.MemberService;

import UMC.spring.study.domain.Member;
import UMC.spring.study.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
