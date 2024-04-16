package com.service.payment;

import com.service.payment.dto.PaymentRequestDto;
import com.service.payment.dto.PaymentResponseDto;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  public PaymentService() {
  }

  public PaymentResponseDto getPaymentById(final UUID id) {
    // Fetch the payment from the database using the id
    // Convert the fetched payment entity to PaymentResponseDto
    // Return the PaymentResponseDto
    return null;
  }

  public List<PaymentResponseDto> getAllPayments() {
    // Fetch all the payments from the database
    // Convert the fetched payment entities to PaymentResponseDto
    // Return the list of PaymentResponseDto
    return null;
  }

  public PaymentResponseDto createPayment(
      final PaymentRequestDto paymentRequestDto
  ) {
    // Convert the PaymentRequestDto to a payment entity
    // Save the payment entity to the database
    // Convert the saved payment entity to PaymentResponseDto
    // Return the PaymentResponseDto
    return null;
  }

  public PaymentResponseDto updatePayment(
      final UUID id, final PaymentRequestDto paymentRequestDto
  ) {
    // Fetch the payment from the database using the id
    // Update the fetched payment entity using the data in PaymentRequestDto
    // Save the updated payment entity to the database
    // Convert the saved payment entity to PaymentResponseDto
    // Return the PaymentResponseDto
    return null;
  }

  public void deletePayment(final UUID id) {
    // Fetch the payment from the database using the id
    // Delete the fetched payment entity from the database
  }
}
