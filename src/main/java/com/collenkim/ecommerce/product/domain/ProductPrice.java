package com.collenkim.ecommerce.product.domain;

import com.collenkim.ecommerce.cd.PriceTypeCd;
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
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "product_price",
    indexes = {
        @Index(name = "idx_product_option_id", columnList = "product_option_id")
    })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductPrice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_price_id")
    private Long productPriceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_option_id", nullable = false)
    private ProductOption productOption;  // 각 옵션에 해당하는 가격

    @Column(name = "price_type", nullable = false, length = 10)
    @Enumerated(value = EnumType.STRING)
    private PriceTypeCd priceTypeCd; // 가격 타입 (기본, 할인, 특가 등)

    @Column(name = "base_price", nullable = false, precision = 10, scale = 0)
    private BigDecimal basePrice; // 기본 가격

    @Column(name = "discount_rate", nullable = false, precision = 5, scale = 2)
    private BigDecimal discountRate; // 할인률

    @Column(name = "final_price", nullable = false, precision = 10, scale = 0)
    private BigDecimal finalPrice; // 할인율 등 적용된 최종 가격

    @Column(name = "sale_quantity", nullable = false)
    private Integer saleQuantity;  // 판매 갯수 (1개, 10개 묶음 등)

    private ProductPrice(ProductOption productOption, PriceTypeCd priceTypeCd, BigDecimal basePrice,
        BigDecimal discountRate, BigDecimal finalPrice, Integer saleQuantity) {
        this.productOption = productOption;
        this.priceTypeCd = priceTypeCd;
        this.basePrice = basePrice;
        this.discountRate = discountRate;
        this.finalPrice = finalPrice;
        this.saleQuantity = saleQuantity;
    }

    /**
     * 상품 가격 생성
     *
     * @param productOption
     * @param priceTypeCd
     * @param basePrice
     * @param discountRate
     * @param finalPrice
     * @param saleQuantity
     * @return
     */
    public static ProductPrice createProductPrice(ProductOption productOption,
        PriceTypeCd priceTypeCd, BigDecimal basePrice,
        BigDecimal discountRate, BigDecimal finalPrice, Integer saleQuantity) {
        return new ProductPrice(productOption, priceTypeCd, basePrice, discountRate, finalPrice,
            saleQuantity);
    }

}
