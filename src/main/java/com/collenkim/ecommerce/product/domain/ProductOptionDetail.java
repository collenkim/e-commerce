package com.collenkim.ecommerce.product.domain;

import com.collenkim.ecommerce.cd.ProductStatusCd;
import com.collenkim.ecommerce.common.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "product_option_detail",
    indexes = {
        @Index(name = "idx_product_option_id", columnList = "product_option_id"),
        @Index(name = "idx_product_stock_id", columnList = "product_stock_id"),
    })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductOptionDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_option_detail_id")
    private Long productOptionDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_option_id", nullable = false)
    private ProductOption productOption;

    @Column(name = "option_code", nullable = false)
    private String optionCode;

    @Column(name = "option_name", nullable = false)
    private String optionName;

    @Column(name = "option_value", nullable = false)
    private String optionValue;

    @Column(name = "product_status_cd", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ProductStatusCd productStatusCd;

    @Column(name = "daily_purchase_limit")
    private Integer dailyPurchaseLimit;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_stock_id", nullable = false)
    private ProductStock productStock; // 재고

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_price_id", nullable = false)
    private ProductPrice productPrice; // 가격 정보

    private ProductOptionDetail(ProductOption productOption, String optionCode, String optionName,
        String optionValue, ProductStatusCd productStatusCd, Integer dailyPurchaseLimit,
        ProductStock productStock, ProductPrice productPrice) {
        this.productOption = productOption;
        this.optionCode = optionCode;
        this.optionName = optionName;
        this.optionValue = optionValue;
        this.productStatusCd = productStatusCd;
        this.dailyPurchaseLimit = dailyPurchaseLimit;
        this.productStock = productStock;
        this.productPrice = productPrice;
    }

    public static ProductOptionDetail createProductOptionDetail(ProductOption productOption,
        String optionCode, String optionName, String optionValue, ProductStatusCd productStatusCd,
        Integer dailyPurchaseLimit, ProductStock productStock, ProductPrice productPrice) {
        return new ProductOptionDetail(productOption, optionCode, optionName, optionValue,
            productStatusCd,
            dailyPurchaseLimit, productStock, productPrice);
    }

}
