package com.collenkim.ecommerce.member.dto;

import com.collenkim.ecommerce.member.domain.Address;
import com.collenkim.ecommerce.member.domain.Member;
import lombok.Getter;
import lombok.Setter;

public class AddressDto {

    @Setter
    @Getter
    public static class ReqAdd {

        private Long memberId;

        private Boolean isDefault; //기본배송지 여부

        private String zipCode;  //우편번호

        private String basicAddress; //기본주소

        private String detailAddress; //상세주소

        /**
         * 주소 엔티티로 변환
         *
         * @param member
         * @return
         */
        public Address toEntity(Member member) {
            return Address.createAddress(member, isDefault, zipCode, basicAddress, detailAddress);
        }
    }


}
