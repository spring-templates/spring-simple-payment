package com.service.payment;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  public PaymentService() {
  }

  public PaymentDto getCustomerByEmail(final String email) {
    return null;
  }

  public List<PaymentDto> getAllCustomers() {
    return null;
  }

  public PaymentDto createCustomer(final PaymentDto customerDto) {
    return null;
  }

  public PaymentDto updateCustomer(
      final String email, final PaymentDto customerDto
  ) {
    return null;
  }

  public void deleteCustomer(final String email) {
  }
}
