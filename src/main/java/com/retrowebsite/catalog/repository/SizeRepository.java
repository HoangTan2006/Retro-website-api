package com.retrowebsite.catalog.repository;

import com.retrowebsite.catalog.domain.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SizeRepository extends JpaRepository<Size, UUID> {
}
