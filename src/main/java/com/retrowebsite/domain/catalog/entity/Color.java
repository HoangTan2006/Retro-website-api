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
@Table(name = "colors")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Color extends BaseEntity {
    @Column(name = "color_name")
    private String colorName;

    @Column(name = "color_hex")
    private String colorHex;

    @OneToMany(mappedBy = "color")
    private Set<ProductVariant> productVariants;
}
