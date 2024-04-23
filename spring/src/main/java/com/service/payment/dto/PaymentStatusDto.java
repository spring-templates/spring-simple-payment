package com.service.payment.dto;

public record PaymentStatusDto(
    Long paymentId,
    PaymentStatus status
) {

}
