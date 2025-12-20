package com.retrowebsite.domain.catalog.repository;

import com.retrowebsite.domain.catalog.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ColorRepository extends JpaRepository<Color, UUID> {
}
