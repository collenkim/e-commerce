package com.collenkim.ecommerce;

import com.collenkim.ecommerce.member.domain.Address;
import com.collenkim.ecommerce.member.domain.Member;
import com.collenkim.ecommerce.member.dto.AddressDto;
import com.collenkim.ecommerce.member.dto.MemberDto;
import com.collenkim.ecommerce.member.service.AddressService;
import com.collenkim.ecommerce.member.service.MemberService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class AddressTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private AddressService addressService;

    @BeforeEach
    public void init() {

        //회원 등록
        MemberDto.ReqAdd reeAdd = new MemberDto.ReqAdd();
        reeAdd.setUserId("collenkim");
        reeAdd.setName("김콜린");
        reeAdd.setPassword("1234");
        reeAdd.setPhone("01012345678");

        memberService.insertMember(reeAdd);

    }

    @DisplayName("주소 조회 테스트")
    @Test
    @Transactional
    public void select_member_address() {

        //Given 주소 등록
        AddressDto.ReqAdd reqAdd = new AddressDto.ReqAdd();
        reqAdd.setMemberId(1L);
        reqAdd.setIsDefault(true);
        reqAdd.setZipCode("405-21");
        reqAdd.setBasicAddress("경기도 성남시 분당구 정자동 178-1");
        reqAdd.setDetailAddress("301동 101호");

        addressService.insertAddress(reqAdd);

        //When 주소 조회
        List<Address> addressList = addressService.getAddressList(1L);

        //Then 주소 조회 확인
        for (Address address : addressList) {

            Member member = address.getMember();

            System.out.println(
                "addressId : " + address.getAddressId() + " userId : " + member.getUserId()
                    + " isDefault : " + address.getIsDefault()
                    + " zipCode : " + address.getZipCode()
                    + " basicAddress : " + address.getBasicAddress()
                    + " detailAddress : " + address.getDetailAddress()
            );
        }

    }

    @DisplayName("주소 삭제 테스트")
    @Test
    public void delete_address() {

        //Given 주소 등록
        AddressDto.ReqAdd reqAdd = new AddressDto.ReqAdd();
        reqAdd.setMemberId(1L);
        reqAdd.setIsDefault(true);
        reqAdd.setZipCode("405-21");
        reqAdd.setBasicAddress("경기도 성남시 분당구 정자동 178-1");
        reqAdd.setDetailAddress("301동 101호");

        addressService.insertAddress(reqAdd);

        //Given 주소 삭제
        addressService.deleteAddressByAddressId(1L);

        //Then 주소 조회
        List<Address> addressList = addressService.getAddressList(1L);

        if (addressList == null || addressList.isEmpty()) {
            Assertions.assertTrue(true);
        } else {
            Assertions.fail("주소 삭제 실패");
        }

    }

    @DisplayName("주소 삭제 테스트")
    @Test
    public void delete_member_address() {

        //Given 주소 등록
        AddressDto.ReqAdd reqAdd = new AddressDto.ReqAdd();
        reqAdd.setMemberId(1L);
        reqAdd.setIsDefault(true);
        reqAdd.setZipCode("405-21");
        reqAdd.setBasicAddress("경기도 성남시 분당구 정자동 178-1");
        reqAdd.setDetailAddress("301동 101호");

        addressService.insertAddress(reqAdd);

        //Given 주소 삭제
        addressService.deleteAllAddressByMemberId(1L);

        //Then 주소 조회
        List<Address> addressList = addressService.getAddressList(1L);

        if (addressList == null || addressList.isEmpty()) {
            Assertions.assertTrue(true);
        } else {
            Assertions.fail("주소 삭제 실패");
        }

    }

}
