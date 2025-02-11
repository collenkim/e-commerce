package com.collenkim.ecommerce.member.domain;

import com.collenkim.ecommerce.common.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "address",
    indexes = {
        @Index(name = "idx_member_id", columnList = "member_id")
    })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "member_id")
    private Long memberId;

    private Boolean isDefault; //기본배송지 여부
    private String zipCode;  //우편번호
    private String basicAddress; //기본주소
    private String detailAddress; //상세주소

    @Builder
    public Address(Long memberId, Boolean isDefault, String zipCode, String basicAddress,
        String detailAddress) {
        this.memberId = memberId;
        this.isDefault = isDefault;
        this.zipCode = zipCode;
        this.basicAddress = basicAddress;
        this.detailAddress = detailAddress;
    }

}
