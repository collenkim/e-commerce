package com.collenkim.ecommerce;

import com.collenkim.ecommerce.cd.Yn;
import com.collenkim.ecommerce.member.domain.Member;
import com.collenkim.ecommerce.member.dto.MemberDto;
import com.collenkim.ecommerce.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberTest {

    @Autowired
    private MemberService memberService;

    @DisplayName("회원가입 테스트")
    @Test
    public void insertMember() {

        MemberDto.ReqAdd reeAdd = new MemberDto.ReqAdd();
        reeAdd.setUserId("collenkim");
        reeAdd.setName("김콜린");
        reeAdd.setPassword("1234");
        reeAdd.setPhone("01012345678");

        memberService.insertMember(reeAdd);

        Member findMember = memberService.getMemberByUserId("collenkim");

        System.out.println(
            "memberId : " + findMember.getMemberId() + " password : " + findMember.getPassword()
                + " name : " + findMember.getName()
                + " phone : " + findMember.getPhone()
                + " useYn : " + findMember.getUseYn());

    }

    @DisplayName("회원탈퇴 테스트")
    @Test
    public void deleteMember() {

        MemberDto.ReqAdd reeAdd = new MemberDto.ReqAdd();
        reeAdd.setUserId("collenkim");
        reeAdd.setName("김콜린");
        reeAdd.setPassword("1234");
        reeAdd.setPhone("01012345678");

        memberService.insertMember(reeAdd);

        memberService.updateMemberUseYn("collenkim", Yn.N.getCode());

        Member findMember = memberService.getMemberByUserId("collenkim");

        System.out.println(
            "memberId : " + findMember.getMemberId() + " password : " + findMember.getPassword()
                + " name : " + findMember.getName()
                + " phone : " + findMember.getPhone()
                + " useYn : " + findMember.getUseYn());

    }

}
