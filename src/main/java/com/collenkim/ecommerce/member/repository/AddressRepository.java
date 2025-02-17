package com.collenkim.ecommerce.member.repository;

import com.collenkim.ecommerce.member.domain.Address;
import com.collenkim.ecommerce.member.domain.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByMember(Member member);

}
