package com.retrowebsite.catalog.domain.valueobject;

import com.retrowebsite.catalog.exception.CatalogException;
import com.retrowebsite.catalog.exception.CatalogExceptionEnum;

import java.math.BigDecimal;
import java.util.Objects;

public class Price {
    private BigDecimal price;

    public Price(BigDecimal price) {
        this.price = price;
    }

    public static Price create(BigDecimal price) {
        validPrice(price);
        return new Price(price);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        validPrice(price);
        this.price = price;
    }

    private static void validPrice(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new CatalogException(CatalogExceptionEnum.PRICE_INVALID);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Objects.equals(price, price1.price);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(price);
    }
}
