package com.retrowebsite.infra.jparepository;

import com.retrowebsite.domain.catalog.dto.product.response.ProductDetailDTO;
import com.retrowebsite.domain.catalog.entity.Product;
import com.retrowebsite.domain.catalog.repository.ProductRepository;
import com.retrowebsite.domain.catalog.valueobject.ProductState;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepositoryCustom {

    @Query("""
            select new com.retrowebsite.domain.catalog.dto.product.response.ProductDetailDTO(
                p.productName,
                p.thumbnail,
                p.summary,
                p.images,
                p.descriptions,
                c.categoryName,
                b.brandName,
                p.salePrice,
                p.discount
            )
            from Product p
            join p.brand b
            join p.category c
            where 
                p.id = :id and
                p.productState = :productState
           """)
    Optional<ProductDetailDTO> findByIdAndProductState(UUID id, ProductState productState);
}
