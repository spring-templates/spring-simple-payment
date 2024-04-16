package com.service.payment;

import java.util.List;
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
@RequestMapping("/payment")
public class PaymentController {

  private final PaymentService paymentService;

  public PaymentController(final PaymentService service) {
    this.paymentService = service;
  }

  @PostMapping
  public ResponseEntity<PaymentDto> createPayment(
      @RequestBody PaymentDto paymentDto
  ) {
    return ResponseEntity.ok(paymentService.createCustomer(paymentDto));
  }

  @GetMapping
  public ResponseEntity<List<PaymentDto>> getAllPayments() {
    return ResponseEntity.ok(paymentService.getAllCustomers());
  }

  @GetMapping("/{email}")
  public ResponseEntity<PaymentDto> getPaymentByEmail(
      @PathVariable String email
  ) {
    return ResponseEntity.ok(paymentService.getCustomerByEmail(email));
  }

  @PutMapping("/{email}")
  public ResponseEntity<PaymentDto> updatePayment(
      @PathVariable String email, @RequestBody PaymentDto paymentDto
  ) {
    return ResponseEntity.ok(paymentService.updateCustomer(email, paymentDto));
  }

  @DeleteMapping("/{email}")
  public ResponseEntity<Void> deletePayment(@PathVariable String email) {
    paymentService.deleteCustomer(email);
    return ResponseEntity.noContent().build();
  }
}
