package com.service.payment.dto;

public record PaymentResponseDto(
    Long paymentId,
    PaymentStatus status
) {

}
