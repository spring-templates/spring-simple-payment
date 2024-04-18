package com.service.payment.entity;

public enum AbstractPayment {
  /**
   * Payment by credit card.
   */
  @SuppressWarnings("unused") CREDIT_CARD,
  /**
   * Payment by PayPal.
   */
  @SuppressWarnings("unused") PAYPAL,
  /**
   * Payment by iDEAL.
   */
  @SuppressWarnings("unused") IDEAL
}
