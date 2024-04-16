package com.service.customer;

import com.service.customer.entity.Customer;

/**
 * DTO for {@link Customer}
 */
public record CustomerDto(
    String email,
    String name
) {

}
