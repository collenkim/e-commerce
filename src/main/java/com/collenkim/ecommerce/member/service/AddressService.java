package com.collenkim.ecommerce.member.service;

import com.collenkim.ecommerce.member.domain.Address;
import com.collenkim.ecommerce.member.dto.AddressDto;
import java.util.List;

public interface AddressService {

    /**
     * 주소 목록 조회
     *
     * @param memberId
     * @return
     */
    List<Address> getAddressList(Long memberId);

    /**
     * 주소 등록
     *
     * @param reqAdd
     * @return
     */
    void insertAddress(AddressDto.ReqAdd reqAdd);

    /**
     * 주소 단건 삭제
     *
     * @param addressId
     * @return
     */
    void deleteAddressByAddressId(Long addressId);

    /**
     * 회원 주소 전체 삭제
     *
     * @param memberId
     * @return
     */
    void deleteAllAddressByMemberId(Long memberId);
}
