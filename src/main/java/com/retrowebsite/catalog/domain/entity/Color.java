package com.retrowebsite.catalog.domain.entity;

import com.retrowebsite.catalog.domain.valueobject.ColorHex;
import com.retrowebsite.catalog.exception.CatalogException;
import com.retrowebsite.catalog.exception.CatalogExceptionEnum;

public class Color extends BaseEntity {
    private String colorName;
    private ColorHex colorHex;

    public Color(String colorName, ColorHex colorHex) {
        this.colorName = colorName;
        this.colorHex = colorHex;
    }

    public static Color create(String colorName, ColorHex colorHex) {
        validColorName(colorName);
        return new Color(colorName, colorHex);
    }

    public String getColorName() {
        return colorName;
    }

    public ColorHex getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = ColorHex.create(colorHex);
    }

    public void setColorName(String colorName) {
        validColorName(colorName);
        this.colorName = colorName;
    }

    private static void validColorName(String colorName) {
        if (colorName == null || colorName.isBlank()) {
            throw new CatalogException(CatalogExceptionEnum.COLOR_NAME_INVALID);
        }
    }
}
