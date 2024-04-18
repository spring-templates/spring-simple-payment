package com.service.payment;

import com.service.payment.dto.PaymentInitialRequestDto;
import com.service.payment.dto.PaymentStatusDto;
import com.service.payment.dto.PaymentStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

  private final PaymentService service;

  public PaymentController(final PaymentService paymentService) {
    this.service = paymentService;
  }

  // 1. Payment request
  @PostMapping
  public ResponseEntity<PaymentStatusDto> pay(
      @RequestBody PaymentInitialRequestDto dto
  ) {
    var result = service.initialize(dto);
    service.validate(dto, result);
    return ResponseEntity.ok(result);
  }

  // 2. Request redirected by payment gateway
  @PutMapping("/confirm")
  public ResponseEntity<PaymentStatusDto> confirm(
      @RequestBody PaymentStatusDto dto
  ) {
    var result = service.confirm(dto.paymentId());
    if (PaymentStatus.isSuccess(result)) {
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.badRequest().build();
  }

  // 3. Payment cancellation
  @PutMapping("/cancel")
  public ResponseEntity<PaymentStatusDto> cancel(
      @RequestBody PaymentStatusDto dto
  ) {
    PaymentStatusDto result = service.cancel(dto.paymentId());
    if (PaymentStatus.isCancelled(result)) {
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.badRequest().build();
  }
}
