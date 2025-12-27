package com.retrowebsite.catalog.domain.valueobject;

import com.retrowebsite.catalog.exception.CatalogException;
import com.retrowebsite.catalog.exception.CatalogExceptionEnum;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorHex {

    private static final String EMAIL_REGEX = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
    private String colorHex;

    public ColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

    public static ColorHex create(String colorHex) {
        validColorHex(colorHex);
        return new ColorHex(colorHex);
    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        validColorHex(colorHex);
        this.colorHex = colorHex;
    }

    private static void validColorHex(String colorHex) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);

        Matcher matcher = pattern.matcher(colorHex);
        if (!matcher.matches()) {
            throw new CatalogException(CatalogExceptionEnum.COLOR_HEX_INVALID);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ColorHex colorHex1 = (ColorHex) o;
        return Objects.equals(colorHex, colorHex1.colorHex);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(colorHex);
    }
}
