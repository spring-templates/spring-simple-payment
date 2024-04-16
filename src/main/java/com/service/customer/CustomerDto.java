package com.service.customer;

import com.payment.customer.entity.Customer;
import java.io.Serializable;

/**
 * DTO for {@link Customer}
 */
public record CustomerDto(
    String email,
    String name
) implements Serializable {

}
