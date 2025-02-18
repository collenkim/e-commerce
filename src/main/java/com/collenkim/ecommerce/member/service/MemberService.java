package com.collenkim.ecommerce.member.service;

import com.collenkim.ecommerce.member.domain.Member;
import com.collenkim.ecommerce.member.dto.MemberDto;

public interface MemberService {

    /**
     * 회원 정보 조회
     *
     * @param memberId
     * @return
     */
    Member getMemberByMemberId(Long memberId);

    /**
     * 회원 정보 조회
     *
     * @param userId
     * @return
     */
    Member getMemberByUserId(String userId);

    /**
     * 회원 정보 등록
     *
     * @param reqAdd
     * @return
     */
    void insertMember(MemberDto.ReqAdd reqAdd);

    /**
     * 회원 사용여부 변경
     *
     * @param userId
     * @param useYn
     */
    void updateMemberUseYn(String userId, String useYn);
}
