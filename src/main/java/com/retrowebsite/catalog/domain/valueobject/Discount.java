package com.retrowebsite.catalog.domain.valueobject;

import com.retrowebsite.catalog.exception.CatalogException;
import com.retrowebsite.catalog.exception.CatalogExceptionEnum;

import java.util.Objects;

public class Discount {
    private int discount;

    public Discount(int discount) {
        this.discount = discount;
    }

    public static Discount create(int discount) {
        validDiscount(discount);
        return new Discount(discount);
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        validDiscount(discount);
        this.discount = discount;
    }

    private static void validDiscount(int discount) {
        if (discount < 0 || discount > 100) {
            throw new CatalogException(CatalogExceptionEnum.DISCOUNT_INVALID);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount1 = (Discount) o;
        return discount == discount1.discount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(discount);
    }
}
