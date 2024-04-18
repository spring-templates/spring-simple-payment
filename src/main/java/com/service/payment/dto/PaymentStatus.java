package com.service.payment.dto;

public enum PaymentStatus {
  PENDING,
  CANCELLED,
  SUCCESS,
  FAILED;

  public static boolean isSuccess(final PaymentStatusDto result) {
    return SUCCESS.equals(result.status());
  }

  public static boolean isCancelled(final PaymentStatusDto result) {
    return CANCELLED.equals(result.status());
  }
}
