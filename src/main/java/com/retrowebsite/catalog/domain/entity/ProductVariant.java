package com.retrowebsite.catalog.domain.entity;

import com.retrowebsite.catalog.domain.valueobject.Price;
import com.retrowebsite.catalog.domain.valueobject.ProductState;
import com.retrowebsite.catalog.domain.valueobject.Sku;

public class ProductVariant extends BaseEntity {
    private Sku sku;
    private Size size;
    private Color color;
    private ProductState productState;
    private Price salePrice;

    public ProductVariant(Sku sku, Size size, Color color, ProductState productState, Price salePrice) {
        this.sku = sku;
        this.size = size;
        this.color = color;
        this.productState = productState;
        this.salePrice = salePrice;
    }

    public static ProductVariant create(Sku sku, Size size, Color color, ProductState productState, Price salePrice) {
        return new ProductVariant(sku, size, color, productState, salePrice);
    }

    public Sku getSku() {
        return sku;
    }

    public Size getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public ProductState getProductState() {
        return productState;
    }

    public Price getSalePrice() {
        return salePrice;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setProductState(ProductState productState) {
        this.productState = productState;
    }

    public void setSalePrice(Price salePrice) {
        this.salePrice = salePrice;
    }
}
