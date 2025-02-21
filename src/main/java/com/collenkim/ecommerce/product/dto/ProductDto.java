package com.collenkim.ecommerce.product.dto;

import com.collenkim.ecommerce.brand.domain.Brand;
import com.collenkim.ecommerce.category.domain.Category;
import com.collenkim.ecommerce.cd.ProductStatusCd;
import com.collenkim.ecommerce.product.domain.Product;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

public class ProductDto {

    @Setter
    @Getter
    public static class ReqAdd {

        @NotBlank(message = "판매자 아이디는 필수입니다.")
        private String sellerId;

        @NotBlank(message = "상품 코드는 필수입니다.")
        private String productCode;

        @NotBlank(message = "브랜드 아이디는 필수입니다.")
        private Long brandId;

        @NotBlank(message = "상품명은 필수입니다.")
        private String productName;

        @NotBlank(message = "상품 상태 코드는 필수입니다.")
        private String productStatusCd;

        @NotBlank(message = "썸네일 URL은 필수입니다.")
        private String thumbnailUrl;

        @NotBlank(message = "콘텐츠 이미지 URL은 필수입니다.")
        private String contentImageUrl;

        @NotBlank(message = "카테고리 아이디는 필수입니다.")
        private Long categoryId;

        @NotBlank(message = "상품 가격은 필수입니다.")
        private BigDecimal productPrice;

        @NotBlank(message = "상품 재고는 필수입니다.")
        private Integer productStock;

        private String description;

        public Product toEntity(ProductStatusCd productStatusCd, Brand brand, Category category) {
            return Product.createProduct(sellerId, productCode, category, brand, productName,
                productStatusCd, thumbnailUrl, contentImageUrl, description);
        }
    }

}
