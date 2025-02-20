package com.collenkim.ecommerce.product.domain;

import com.collenkim.ecommerce.brand.domain.Brand;
import com.collenkim.ecommerce.category.domain.Category;
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
@Table(name = "product",
    indexes = {
        @Index(name = "idx_seller_id", columnList = "seller_id"),
        @Index(name = "idx_product_code", columnList = "product_code"),
        @Index(name = "idx_category_id", columnList = "category_id")
    })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "seller_id", nullable = false)
    private String sellerId;

    @Column(name = "product_code", nullable = false)
    private String productCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_status_cd", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ProductStatusCd productStatusCd;

    @Column(name = "thumbnail_url", nullable = false)
    private String thumbnailUrl;

    @Column(name = "content_image_url", nullable = false)
    private String contentImageUrl;

    @Column(name = "description")
    private String description;

    private Product(String sellerId, String productCode, Category category, Brand brand,
        String productName, ProductStatusCd productStatusCd, String thumbnailUrl,
        String contentImageUrl, String description) {
        this.sellerId = sellerId;
        this.productCode = productCode;
        this.category = category;
        this.brand = brand;
        this.productName = productName;
        this.productStatusCd = productStatusCd;
        this.thumbnailUrl = thumbnailUrl;
        this.contentImageUrl = contentImageUrl;
        this.description = description;
    }

    /**
     * 상품 생성
     *
     * @param sellerId
     * @param productCode
     * @param brand
     * @param productName
     * @param productStatusCd
     * @param thumbnailUrl
     * @param contentImageUrl
     * @param category
     * @param description
     * @return
     */
    public static Product createProduct(String sellerId, String productCode, Category category,
        Brand brand,
        String productName, ProductStatusCd productStatusCd, String thumbnailUrl,
        String contentImageUrl, String description) {
        return new Product(sellerId, productCode, category, brand, productName, productStatusCd,
            thumbnailUrl, contentImageUrl, description);
    }

}
