package com.service.payment.dto;

public record PaymentResponseDto(
    String paymentId,
    String productId,
    Long amount,
    PaymentStatus status
) {

}
