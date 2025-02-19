package com.collenkim.ecommerce.category.domain;

import com.collenkim.ecommerce.common.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "category",
    indexes = {
        @Index(name = "idx_parent_id", columnList = "parent_id")
    })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "parent_id", nullable = false)
    private Long parentId;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Column(name = "category_icon", nullable = false)
    private String categoryIcon;

    @Column(name = "level", nullable = false)
    private Integer level;

    @OneToMany(mappedBy = "category")
    private List<CategoryBrand> categoryBrands = new ArrayList<>();

    private Category(Long parentId, String categoryName, String categoryIcon,
        Integer level) {
        this.parentId = parentId;
        this.categoryName = categoryName;
        this.categoryIcon = categoryIcon;
        this.level = level;
    }

    /**
     * 카테고리 생성
     *
     * @param parentId
     * @param categoryName
     * @param categoryIcon
     * @param level
     * @return
     */
    public static Category createCategory(Long parentId, String categoryName,
        String categoryIcon,
        Integer level) {
        return new Category(parentId, categoryName, categoryIcon,
            level);
    }

}
