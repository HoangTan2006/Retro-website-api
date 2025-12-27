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
@Table(name = "categories")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Category extends BaseEntity {
    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;
}
