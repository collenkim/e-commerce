package com.collenkim.ecommerce.member.service.impl;

import com.collenkim.ecommerce.member.domain.Member;
import com.collenkim.ecommerce.member.dto.MemberDto;
import com.collenkim.ecommerce.member.repository.MemberRepository;
import com.collenkim.ecommerce.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 정보 조회
     *
     * @param memberId
     * @return
     */
    @Override
    public Member getMemberByMemberId(Long memberId) {
        return memberRepository.findByMemberId(memberId);
    }

    /**
     * 회원 정보 조회
     *
     * @param userId
     * @return
     */
    @Override
    public Member getMemberByUserId(String userId) {
        return memberRepository.findByUserId(userId);
    }

    /**
     * 회원 정보 등록
     *
     * @param reqAdd
     * @return
     */
    @Override
    public void insertMember(MemberDto.ReqAdd reqAdd) {
        memberRepository.save(reqAdd.toEntity());
    }

    /**
     * 회원 사용여부 변경
     *
     * @param userId
     * @param useYn
     */
    @Override
    public void updateMemberUseYn(String userId, String useYn) {

        Member member = memberRepository.findByUserId(userId);
        member.updateUseYn(useYn);

        memberRepository.save(member);
    }

}
