package com.collenkim.ecommerce.product.domain;

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
@Table(name = "product_stock",
    indexes = {
        @Index(name = "idx_seller_id", columnList = "seller_id"),
        @Index(name = "idx_product_code", columnList = "product_code"),
        @Index(name = "idx_category_id", columnList = "category_id")
    })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductStock extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_stock_id")
    private Long productStockId;


    @Column(name = "product_stock", nullable = false)
    private Integer productStock;


}
