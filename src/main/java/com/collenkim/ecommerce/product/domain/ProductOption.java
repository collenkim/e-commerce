package com.collenkim.ecommerce.product.domain;

import com.collenkim.ecommerce.cd.OptionTypeCd;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "product_option",
    indexes = {
        @Index(name = "idx_product_id", columnList = "product_id")
    })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductOption extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_option_id")
    private Long productOptionId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "option_type", nullable = false, length = 10)
    @Enumerated(value = EnumType.STRING)
    private OptionTypeCd optionTypeCd; // 옵션 타입 (기본 색상, 용량, 사이즈)

    @Column(name = "option_values", length = 100)
    private String optionValues; // 옵션 값 (블랙, 화이트, 350ML)

    @OneToMany(mappedBy = "productOption")
    private List<ProductOptionDetail> productOptionDetails = new ArrayList<>();

    private ProductOption(Product product, OptionTypeCd optionTypeCd, String optionValues) {
        this.product = product;
        this.optionTypeCd = optionTypeCd;
        this.optionValues = optionValues;
    }

    public static ProductOption createProductOption(Product product, OptionTypeCd optionTypeCd,
        String optionValues) {
        return new ProductOption(product, optionTypeCd, optionValues);
    }

}
