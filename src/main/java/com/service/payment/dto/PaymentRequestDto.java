package com.service.payment.dto;

import com.service.customer.CustomerRequestDto;
import com.service.payment.entity.PaymentMethod;

public record PaymentRequestDto(
    CustomerRequestDto customer,
    String productId,
    PaymentMethod paymentMethod,
    Long amount,
    PaymentStatus status
) {

}
