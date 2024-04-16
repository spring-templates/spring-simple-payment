package com.service.info;

import com.service.customer.CustomerDto;
import com.service.info.entity.Info;

/**
 * DTO for {@link Info}
 */
public record InfoDto(
    CustomerDto customer,
    int paymentAmount
) {

}
