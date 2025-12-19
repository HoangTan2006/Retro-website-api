package com.retrowebsite.domain.catalog.entity;

import com.retrowebsite.domain.catalog.valueobject.ProductState;
import com.retrowebsite.domain.shared.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "product_variants")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariant extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "sku")
    private String sku;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @Embedded
    private ProductState productState;

    @Column(name = "sale_price")
    private BigDecimal salePrice;
}
