package com.retrowebsite.catalog.repository.persistence.entity;

import com.retrowebsite.shared.persistence.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(name = "brands")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Brand extends BaseEntity {
    @Column(name = "brand_name")
    private String brandName;

    @OneToMany(mappedBy = "brand")
    private Set<Product> products;
}
