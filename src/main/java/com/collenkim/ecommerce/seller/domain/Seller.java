package com.collenkim.ecommerce.seller.domain;

import com.collenkim.ecommerce.common.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "seller",
    indexes = {
        @Index(name = "idx_seller_id", columnList = "seller_id"),
        @Index(name = "idx_product_code", columnList = "product_code"),
        @Index(name = "idx_category_id", columnList = "category_id")
    })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seller extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_id")
    private Long sellerId;

}
