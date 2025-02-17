package com.collenkim.ecommerce.member.domain;

import com.collenkim.ecommerce.common.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(name = "is_default")
    private Boolean isDefault; //기본배송지 여부

    @Column(name = "zip_code")
    private String zipCode;  //우편번호

    @Column(name = "basic_address")
    private String basicAddress; //기본주소

    @Column(name = "detail_address")
    private String detailAddress; //상세주소

    private Address(Member member, Boolean isDefault, String zipCode, String basicAddress,
        String detailAddress) {
        this.member = member;
        this.isDefault = isDefault;
        this.zipCode = zipCode;
        this.basicAddress = basicAddress;
        this.detailAddress = detailAddress;
    }

    /**
     * 주소 생성
     *
     * @param member
     * @param isDefault
     * @param zipCode
     * @param basicAddress
     * @param detailAddress
     * @return
     */
    public static Address createAddress(Member member, Boolean isDefault, String zipCode,
        String basicAddress,
        String detailAddress) {
        return new Address(member, isDefault, zipCode, basicAddress, detailAddress);
    }

}
