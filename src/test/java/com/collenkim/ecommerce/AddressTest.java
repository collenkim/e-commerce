package com.collenkim.ecommerce;

import com.collenkim.ecommerce.member.domain.Address;
import com.collenkim.ecommerce.member.domain.Member;
import com.collenkim.ecommerce.member.repository.AddressRepository;
import com.collenkim.ecommerce.member.repository.MemberRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class AddressTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AddressRepository addressRepository;

    @BeforeEach
    public void init() {

        //회원 등록
        Member member = Member.createMember("collenkim", "1234", "김콜린", "01012345678");

        memberRepository.save(member);

    }

    @DisplayName("주소 등록 테스트")
    @Test
    @Transactional
    public void insertAddress() {

        Member findMember = memberRepository.findByUserId("collenkim");

        Address address = Address.createAddress(findMember, true, "405-21", "경기도 성남시 분당구 정자동 178-1",
            "301동 101호");

        addressRepository.save(address);

        List<Address> addressList = addressRepository.findByMember(findMember);

        Address findAddress = addressList.stream().filter(e -> e.getIsDefault() == true).findFirst()
            .get();

        Member subMember = findAddress.getMember();

        System.out.println(
            "addressId : " + findAddress.getAddressId() + " userId : " + subMember.getUserId()
                + " isDefault : " + findAddress.getIsDefault()
                + " zipCode : " + findAddress.getZipCode());

    }

}
