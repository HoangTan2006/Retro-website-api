package com.retrowebsite.catalog.domain.entity;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public abstract class BaseEntity {
    protected UUID id;
    protected Instant createdAt;
    protected Instant updatedAt;

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return id != null && id.equals(that.id);
    }

    public int hashCode() {
        return Objects.hashCode(id);
    }
}
