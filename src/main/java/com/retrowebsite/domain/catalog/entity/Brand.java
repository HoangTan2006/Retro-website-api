package com.retrowebsite.domain.catalog.entity;

import com.retrowebsite.domain.shared.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "brands")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Brand extends BaseEntity {
    @Column(name = "brand_name")
    private String brandName;

    @OneToMany(mappedBy = "brand")
    private Set<Product> products;
}
