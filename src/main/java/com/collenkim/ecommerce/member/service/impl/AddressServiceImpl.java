package com.collenkim.ecommerce.member.service.impl;

import com.collenkim.ecommerce.member.domain.Address;
import com.collenkim.ecommerce.member.domain.Member;
import com.collenkim.ecommerce.member.dto.AddressDto;
import com.collenkim.ecommerce.member.repository.AddressRepository;
import com.collenkim.ecommerce.member.service.AddressService;
import com.collenkim.ecommerce.member.service.MemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final MemberService memberService;
    private final AddressRepository addressRepository;

    /**
     * 주소 목록 조회
     *
     * @param memberId
     * @return
     */
    @Override
    public List<Address> getAddressList(Long memberId) {

        Member member = memberService.getMemberByMemberId(memberId);

        return addressRepository.findByMember(member);
    }

    /**
     * 주소 등록
     *
     * @param reqAdd
     * @return
     */
    @Transactional
    @Override
    public void insertAddress(AddressDto.ReqAdd reqAdd) {

        Member member = memberService.getMemberByMemberId(reqAdd.getMemberId());

        Address address = reqAdd.toEntity(member);

        addressRepository.save(address);
    }

    /**
     * 주소 단건 삭제
     *
     * @param addressId
     * @return
     */
    @Transactional
    @Override
    public void deleteAddressByAddressId(Long addressId) {

        addressRepository.deleteByAddressId(addressId);
    }

    /**
     * 회원 주소 전체 삭제
     *
     * @param memberId
     * @return
     */
    @Transactional
    @Override
    public void deleteAllAddressByMemberId(Long memberId) {

        Member member = memberService.getMemberByMemberId(memberId);

        addressRepository.deleteByMember(member);
    }
}
