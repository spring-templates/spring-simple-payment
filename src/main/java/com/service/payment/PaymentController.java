package com.service.payment;

import com.service.payment.dto.PaymentRequestDto;
import com.service.payment.dto.PaymentResponseDto;
import com.service.payment.dto.PaymentStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

  private final PaymentService paymentService;

  public PaymentController(final PaymentService service) {
    this.paymentService = service;
  }

  // 1. Payment request
  @PostMapping
  public ResponseEntity<PaymentResponseDto> pay(
      @RequestBody PaymentRequestDto paymentRequestDto
  ) {
    var result = paymentService.pay(paymentRequestDto);
//    if (result == null) {
//      return ResponseEntity.badRequest().build();
//    }
    return ResponseEntity.ok(result);
  }

  // 2. Payment confirmation by redirect
  @PostMapping("/confirm/{id}")
  public ResponseEntity<PaymentResponseDto> confirm(
      @PathVariable Long id
  ) {
    var result = paymentService.confirmPayment(id);
    if (result == null) {
      return ResponseEntity.notFound().build();
    }
    if (PaymentStatus.SUCCESS.equals(result.status())) {
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.badRequest().build();
  }

  // 3. Payment cancellation
  @PostMapping("/cancel/{id}")
  public ResponseEntity<PaymentResponseDto> cancel(
      @PathVariable Long id
  ) {
    return ResponseEntity.ok(paymentService.cancelPayment(id));
  }
}
