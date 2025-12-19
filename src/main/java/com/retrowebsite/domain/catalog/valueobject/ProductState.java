package com.retrowebsite.domain.catalog.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public enum ProductState {
    IN_STOCK("In stock"),
    OUT_OF_STOCK("Out of stock"),
    DELETED("Does not exist");

    @Column(name = "product_state")
    private String descriptions;

    @Override
    public String toString() {
        return descriptions;
    }
}
