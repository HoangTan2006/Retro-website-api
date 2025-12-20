package com.retrowebsite.domain.catalog.repository;

import com.retrowebsite.domain.catalog.entity.Product;
import com.retrowebsite.domain.catalog.valueobject.ProductState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Optional<Product> findByIdAndProductState(UUID id, ProductState productState);
}
