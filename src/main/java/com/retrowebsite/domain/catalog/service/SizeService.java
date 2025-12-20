package com.retrowebsite.domain.catalog.service;

import com.retrowebsite.domain.catalog.dto.attribute.SizeDto;
import com.retrowebsite.domain.catalog.dto.attribute.UpdateSizeDto;
import com.retrowebsite.domain.catalog.entity.Size;

public interface SizeService {
    Size createSize(SizeDto dto);
    Size updateSize(UpdateSizeDto dto);
}
