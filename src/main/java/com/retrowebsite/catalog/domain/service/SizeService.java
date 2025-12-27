package com.retrowebsite.catalog.domain.service;

import com.retrowebsite.catalog.dto.attribute.SizeDto;
import com.retrowebsite.catalog.dto.attribute.UpdateSizeDto;
import com.retrowebsite.catalog.domain.entity.Size;

public interface SizeService {
    Size createSize(SizeDto dto);
    Size updateSize(UpdateSizeDto dto);
}
