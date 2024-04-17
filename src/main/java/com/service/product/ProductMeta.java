package com.service.product;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProductMeta(
    String name,
    String description
) {

}
