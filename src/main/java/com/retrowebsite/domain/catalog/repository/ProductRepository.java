package com.retrowebsite.domain.catalog.repository;

import com.retrowebsite.domain.catalog.dto.product.response.ProductSummaryDTO;
import com.retrowebsite.domain.catalog.entity.Product;
import com.retrowebsite.domain.catalog.valueobject.ProductState;
import com.retrowebsite.infra.jparepository.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends ProductRepositoryCustom, JpaRepository<Product, UUID> {
    List<ProductSummaryDTO> findAllByProductState(ProductState state);
}
