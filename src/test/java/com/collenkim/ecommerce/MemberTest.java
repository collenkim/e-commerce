package com.collenkim.ecommerce;

import com.collenkim.ecommerce.cd.Yn;
import com.collenkim.ecommerce.member.domain.Member;
import com.collenkim.ecommerce.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("회원가입 테스트")
    @Test
    public void insertMember() {

        Member member = Member.createMember("collenkim", "1234", "김콜린", "01012345678");

        memberRepository.save(member);

        Member findMember = memberRepository.findByUserId("collenkim");

        System.out.println(
            "memberId : " + findMember.getMemberId() + " password : " + findMember.getPassword()
                + " name : " + findMember.getName()
                + " phone : " + findMember.getPhone()
                + " useYn : " + findMember.getUseYn());

    }

    @DisplayName("회원탈퇴 테스트")
    @Test
    public void deleteMember() {

        Member member = Member.createMember("collenkim", "1234", "김콜린", "01012345678");

        memberRepository.save(member);

        member.updateUseYn(Yn.N.getCode());

        memberRepository.save(member);

        Member findMember = memberRepository.findByUserId("collenkim");

        System.out.println(
            "memberId : " + findMember.getMemberId() + " password : " + findMember.getPassword()
                + " name : " + findMember.getName()
                + " phone : " + findMember.getPhone()
                + " useYn : " + findMember.getUseYn());

    }

}
