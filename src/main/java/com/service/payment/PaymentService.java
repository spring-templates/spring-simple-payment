package com.service.payment;

import com.service.payment.dto.PaymentRequestDto;
import com.service.payment.dto.PaymentResponseDto;
import com.service.payment.dto.PaymentStatus;
import com.service.payment.entity.Payment;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  final PaymentRepository repository;
  //  final WebClient webClient; // dependency not installed

  public PaymentService(
      final PaymentRepository repository
  ) {
    this.repository = repository;
  }

  public PaymentResponseDto getPaymentById(final Long id) {
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

  public PaymentResponseDto pay(
      final PaymentRequestDto requestDto
  ) {
    // Convert the PaymentRequestDto to a payment entity
    Payment entity = Payment.of(requestDto);

    // create HttpClient
    // redirect request to given url by HttpClient
    try (HttpClient client = HttpClient.newHttpClient()) {
      // create HttpRequest
      HttpRequest request = HttpRequest.newBuilder()
          .uri(requestDto.redirect())
          .POST(HttpRequest.BodyPublishers.ofByteArray(
              requestDto.toString().getBytes()))
          .build();
      // send request
      client.send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
    }

    // Save the payment entity to the database
    // Convert the saved payment entity to PaymentResponseDto
    // Return the PaymentResponseDto
    return repository.save(entity).toDto();
  }

  public PaymentResponseDto cancelPayment(final Long id) {
    // Fetch the payment from the database using the id
    // Check if the payment can be cancelled
    // Change the status of the payment to CANCELLED
    // Perform the reverse transaction if necessary
    // Save the updated payment entity to the database
    // Convert the saved payment entity to PaymentResponseDto
    // Return the PaymentResponseDto
    return null;
  }

  public PaymentResponseDto confirmPayment(final Long id)
      throws RuntimeException {
    // Fetch the payment from the database using the id
    Optional<Payment> entity = repository.findById(id);
    entity.orElseThrow(() -> new RuntimeException("Payment not found"));
    entity.ifPresent(payment -> {
      // Check if the payment can be confirmed
      // Change the status of the payment to CONFIRMED
      payment.setStatus(PaymentStatus.CONFIRMED);
      // Perform the transaction if necessary
      // Save the updated payment entity to the database
    });
    // Convert the saved payment entity to PaymentResponseDto
    // Return the PaymentResponseDto
    return null;
  }
}
