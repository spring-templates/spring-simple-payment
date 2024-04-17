package com.service.payment.dto;

import com.service.customer.CustomerRequestDto;
import com.service.payment.entity.AbstractPayment;
import java.net.URI;

public record PaymentRequestDto(
    CustomerRequestDto seller,
    CustomerRequestDto buyer,
    AbstractPayment payment,
    Long price,
    // The URL to return to after the payment is completed.
    URI redirect
) {

}
