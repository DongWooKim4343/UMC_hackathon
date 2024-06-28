package UMC.spring.study.service.MemberService;

import UMC.spring.study.apiPayload.code.status.ErrorStatus;
import UMC.spring.study.apiPayload.exception.handler.FoodCategoryHandler;
import UMC.spring.study.converter.MemberConverter;
import UMC.spring.study.converter.MemberPreferConverter;
import UMC.spring.study.domain.FoodCategory;
import UMC.spring.study.domain.Member;
import UMC.spring.study.domain.mapping.MemberPrefer;
import UMC.spring.study.repository.FoodCategoryRepository;
import UMC.spring.study.repository.MemberRepository;
import UMC.spring.study.web.dto.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}