package com.service.payment;

import com.service.payment.dto.PaymentRequestDto;
import com.service.payment.dto.PaymentResponseDto;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @PostMapping
  public ResponseEntity<PaymentResponseDto> createPayment(
      @RequestBody PaymentRequestDto dto
  ) {
    return ResponseEntity.ok(paymentService.createPayment(dto));
  }

  @GetMapping
  public ResponseEntity<List<PaymentResponseDto>> getAllPayments() {
    return ResponseEntity.ok(paymentService.getAllPayments());
  }

  @GetMapping("/{id}")
  public ResponseEntity<PaymentResponseDto> getPaymentById(
      @PathVariable UUID id
  ) {
    return ResponseEntity.ok(paymentService.getPaymentById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<PaymentResponseDto> updatePayment(
      @PathVariable UUID id, @RequestBody PaymentRequestDto dto
  ) {
    return ResponseEntity.ok(paymentService.updatePayment(id, dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePayment(@PathVariable UUID id) {
    paymentService.deletePayment(id);
    return ResponseEntity.noContent().build();
  }
}
