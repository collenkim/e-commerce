package com.collenkim.ecommerce.customer.domain;

import com.collenkim.ecommerce.common.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "customer")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_seq")
    private Long cSeq;

    @Column(name = "c_id", nullable = false)
    private String cId;

    @Column(name = "c_password", nullable = false)
    private String cPassword;

    @Column(name = "c_name", nullable = false)
    private String cName;

    @Column(name = "c_phone", nullable = false)
    private String cPhone;

    @Builder
    public Customer(String cId, String cPassword, String cName, String cPhone) {
        this.cId = cId;
        this.cPassword = cPassword;
        this.cName = cName;
        this.cPhone = cPhone;
    }

}
