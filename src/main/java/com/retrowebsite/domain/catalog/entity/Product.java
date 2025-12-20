package com.retrowebsite.domain.catalog.entity;

import com.retrowebsite.domain.catalog.valueobject.ProductState;
import com.retrowebsite.domain.shared.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "products")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Product extends BaseEntity {
    @Column(name = "product_name")
    private String productName;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "summary")
    private String summary;

    @Column(name = "images")
    private String images;

    @Column(name = "descriptions")
    private String descriptions;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Embedded
    private ProductState productState;

    @Column(name = "sale_price")
    private BigDecimal salePrice;

    @Column(name = "discount")
    private Integer discount;

    @Column(name = "review_count")
    private Integer reviewCount;

    @Column(name = "total_rating")
    private Integer totalRating;

    @OneToMany(mappedBy = "product")
    private Set<ProductVariant> productVariants;

    public void addProductVariant(Set<ProductVariant> productVariant) {
        this.productVariants.addAll(productVariant);
    }

    public void addRating(Integer rating) {
        this.totalRating += rating;
        this.totalRating++;
    }
}
