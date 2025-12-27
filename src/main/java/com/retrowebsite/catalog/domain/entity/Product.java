package com.retrowebsite.catalog.domain.entity;

import com.retrowebsite.catalog.domain.valueobject.Discount;
import com.retrowebsite.catalog.domain.valueobject.Price;
import com.retrowebsite.catalog.domain.valueobject.ProductState;
import com.retrowebsite.catalog.exception.CatalogException;
import com.retrowebsite.catalog.exception.CatalogExceptionEnum;

import java.util.Set;

public class Product extends BaseEntity {
    private String productName;
    private String thumbnail;
    private String summary;
    private String images;
    private String descriptions;
    private Category category;
    private Brand brand;
    private ProductState productState;
    private Price salePrice;
    private Discount discount;
    private Integer reviewCount;
    private Integer totalRating;
    private Set<ProductVariant> productVariants;

    public Product(
            String productName,
            String thumbnail,
            String summary,
            String images,
            String descriptions,
            Category category,
            Brand brand,
            ProductState productState,
            Price salePrice,
            Discount discount,
            Integer reviewCount,
            Integer totalRating,
            Set<ProductVariant> productVariants) {

        this.productName = productName;
        this.thumbnail = thumbnail;
        this.summary = summary;
        this.images = images;
        this.descriptions = descriptions;
        this.category = category;
        this.brand = brand;
        this.productState = productState;
        this.salePrice = salePrice;
        this.discount = discount;
        this.reviewCount = reviewCount;
        this.totalRating = totalRating;
        this.productVariants = productVariants;
    }

    public static Product create(
            String productName,
            String thumbnail,
            String summary,
            String images,
            String descriptions,
            Category category,
            Brand brand,
            ProductState productState,
            Price salePrice,
            Discount discount,
            Set<ProductVariant> productVariants) {

        if (productName == null || productName.isBlank()) {
            throw new CatalogException(CatalogExceptionEnum.PRODUCT_NAME_INVALID);
        }

        if (thumbnail == null || thumbnail.isBlank()) {
            throw new CatalogException(CatalogExceptionEnum.PRODUCT_THUMBNAIL_INVALID);
        }

        if (summary == null || summary.isBlank()) {
            throw new CatalogException(CatalogExceptionEnum.PRODUCT_SUMMARY_INVALID);
        }

        if (images == null || images.isBlank()) {
            throw new CatalogException(CatalogExceptionEnum.PRODUCT_IMAGES_INVALID);
        }

        if (descriptions == null || descriptions.isBlank()) {
            throw new CatalogException(CatalogExceptionEnum.PRODUCT_DESCRIPTIONS_INVALID);
        }

        return new Product(
                productName,
                thumbnail,
                summary,
                images,
                descriptions,
                category,
                brand,
                productState,
                salePrice,
                discount,
                0,
                0,
                productVariants
        );
    }

    public String getProductName() {
        return productName;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getSummary() {
        return summary;
    }

    public String getImages() {
        return images;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public Category getCategory() {
        return category;
    }

    public Brand getBrand() {
        return brand;
    }

    public ProductState getProductState() {
        return productState;
    }

    public Price getSalePrice() {
        return salePrice;
    }

    public Discount getDiscount() {
        return discount;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public Integer getTotalRating() {
        return totalRating;
    }

    public Set<ProductVariant> getProductVariants() {
        return productVariants;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setProductState(ProductState productState) {
        this.productState = productState;
    }

    public void setSalePrice(Price salePrice) {
        this.salePrice = salePrice;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public void setTotalRating(Integer totalRating) {
        this.totalRating = totalRating;
    }

    public void setProductVariants(Set<ProductVariant> productVariants) {
        this.productVariants = productVariants;
    }
}
