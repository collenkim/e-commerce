package com.collenkim.ecommerce.product.domain;

import com.collenkim.ecommerce.brand.domain.Brand;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "thumbnail_url", nullable = false)
    private String thumbnailUrl;

    @Column(name = "content_image_url", nullable = false)
    private String contentImageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "product_price", nullable = false, precision = 10, scale = 0)
    private BigDecimal productPrice;

    @Column(name = "product_stock", nullable = false)
    private Integer productStock;

    @Column(name = "description")
    private String description;

    private Product(String sellerId, String productCode, Brand brand, String productName,
        String thumbnailUrl, String contentImageUrl, Category category, BigDecimal productPrice,
        Integer productStock,
        String description) {
        this.sellerId = sellerId;
        this.productCode = productCode;
        this.brand = brand;
        this.productName = productName;
        this.thumbnailUrl = thumbnailUrl;
        this.contentImageUrl = contentImageUrl;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.description = description;
        this.category = category;
    }

    /**
     * 상품 생성
     *
     * @param sellerId
     * @param productCode
     * @param brand
     * @param productName
     * @param thumbnailUrl
     * @param contentImageUrl
     * @param category
     * @param productPrice
     * @param productStock
     * @param description
     * @return
     */
    public static Product createProduct(String sellerId, String productCode, Brand brand,
        String productName,
        String thumbnailUrl, String contentImageUrl, Category category, BigDecimal productPrice,
        Integer productStock,
        String description) {
        return new Product(sellerId, productCode, brand, productName, thumbnailUrl, contentImageUrl,
            category, productPrice, productStock, description);
    }

}
