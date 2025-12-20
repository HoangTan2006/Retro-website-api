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
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(name = "sizes")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Size extends BaseEntity {
    @Column(name = "size_name")
    private String sizeName;

    @OneToMany(mappedBy = "size")
    private Set<ProductVariant> productVariants;
}
