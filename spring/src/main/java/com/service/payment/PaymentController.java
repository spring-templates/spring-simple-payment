package com.service.payment;

import com.service.payment.dto.PaymentInitialRequestDto;
import com.service.payment.dto.PaymentStatus;
import com.service.payment.dto.PaymentStatusDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

  /**
   * Payment service.
   */
  private final PaymentService service;

  /**
   * Constructor.
   *
   * @param paymentService payment service
   */
  public PaymentController(final PaymentService paymentService) {
    this.service = paymentService;
  }

  /**
   * Initialize payment.
   *
   * @param dto payment request
   * @return payment status
   */
  @PostMapping
  public ResponseEntity<PaymentStatusDto> pay(
      @RequestBody final PaymentInitialRequestDto dto
  ) {
    var result = service.initialize(dto);
    service.validate(dto, result);
    return ResponseEntity.ok(result);
  }

  /**
   * Confirm payment redirected from initial request.
   *
   * @param dto payment status
   * @return payment status
   */
  @PutMapping("/confirm")
  public ResponseEntity<PaymentStatusDto> confirm(
      @RequestBody final PaymentStatusDto dto
  ) {
    var result = service.confirm(dto.paymentId());
    if (PaymentStatus.isSuccess(result)) {
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.badRequest().build();
  }

  /**
   * Cancel payment.
   *
   * @param dto payment status
   * @return payment status
   */
  @PutMapping("/cancel")
  public ResponseEntity<PaymentStatusDto> cancel(
      @RequestBody final PaymentStatusDto dto
  ) {
    PaymentStatusDto result = service.cancel(dto.paymentId());
    if (PaymentStatus.isCancelled(result)) {
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.badRequest().build();
  }
}
