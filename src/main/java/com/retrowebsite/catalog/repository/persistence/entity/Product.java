package com.retrowebsite.catalog.repository.persistence.entity;

import com.retrowebsite.catalog.domain.valueobject.ProductState;
import com.retrowebsite.shared.persistence.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_state", nullable = false)
    private ProductState productState;

    @Column(name = "sale_price", nullable = false)
    private BigDecimal salePrice;

    @Column(name = "discount", nullable = false)
    private Integer discount;

    @Column(name = "review_count")
    private Integer reviewCount;

    @Column(name = "total_rating")
    private Integer totalRating;

    @OneToMany(mappedBy = "product")
    private Set<ProductVariant> productVariants;
}
