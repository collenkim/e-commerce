package com.collenkim.ecommerce.member.repository;

import com.collenkim.ecommerce.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByMemberId(Long memberId);
    
    Member findByUserId(String userId);
    
}
