package com.collenkim.ecommerce.member.dto;

import com.collenkim.ecommerce.member.domain.Member;
import lombok.Getter;
import lombok.Setter;

public class MemberDto {

    @Setter
    @Getter
    public static class ReqAdd {

        private String userId; //기본배송지 여부

        private String password;  //우편번호

        private String name; //기본주소

        private String phone; //상세주소

        /**
         * 회원 엔티티로 변환
         *
         * @return
         */
        public Member toEntity() {
            return Member.createMember(userId, password, name, phone);
        }
    }

}
