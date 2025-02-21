package com.collenkim.ecommerce.product.domain;

import com.collenkim.ecommerce.category.domain.Category;
import com.collenkim.ecommerce.common.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
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
        @Index(name = "idx_category_id", columnList = "category_id"),
        @Index(name = "idx_product_option_id", columnList = "product_option_id")
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "thumbnail_url", nullable = false)
    private String thumbnailUrl;

    @Column(name = "content_image_url", nullable = false)
    private String contentImageUrl;

    @Column(name = "description")
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_option_id", nullable = false)
    private ProductOption productOption;

    private Product(String sellerId, String productCode, Category category,
        String productName, String thumbnailUrl, String contentImageUrl, String description) {
        this.sellerId = sellerId;
        this.productCode = productCode;
        this.category = category;
        this.productName = productName;
        this.thumbnailUrl = thumbnailUrl;
        this.contentImageUrl = contentImageUrl;
        this.description = description;
    }

    /**
     * 상품 생성
     *
     * @param sellerId
     * @param productCode
     * @param category
     * @param productName
     * @param thumbnailUrl
     * @param contentImageUrl
     * @param description
     * @return
     */
    public static Product createProduct(String sellerId, String productCode,
        Category category, String productName, String thumbnailUrl, String contentImageUrl,
        String description) {
        return new Product(sellerId, productCode, category, productName, thumbnailUrl,
            contentImageUrl, description);
    }

}
