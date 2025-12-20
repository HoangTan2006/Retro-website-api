package com.retrowebsite.domain.catalog.service;

import com.retrowebsite.domain.catalog.dto.attribute.ColorDto;
import com.retrowebsite.domain.catalog.dto.attribute.UpdateColorDto;
import com.retrowebsite.domain.catalog.entity.Color;

public interface ColorService {
    Color createColor(ColorDto dto);
    Color updateColor(UpdateColorDto dto);
}
