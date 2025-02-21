package com.collenkim.ecommerce.category.domain;

import com.collenkim.ecommerce.brand.domain.Brand;
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
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "category_brand",
    indexes = {
        @Index(name = "idx_category_id", columnList = "category_id"),
        @Index(name = "idx_brand_id", columnList = "brand_id")
    },
    uniqueConstraints = {
        @UniqueConstraint(name = "uq_category_brand", columnNames = {"category_id", "brand_id"})
    })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryBrand extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_brand_id")
    private Long categoryBrandId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    private CategoryBrand(Category category, Brand brand) {
        this.category = category;
        this.brand = brand;
    }

    /**
     * 카테고리 브랜드 생성
     *
     * @param category
     * @param brand
     * @return
     */
    public static CategoryBrand createCategoryBrand(Category category, Brand brand) {
        return new CategoryBrand(category, brand);
    }

}
