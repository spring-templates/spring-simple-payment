package com.service.customer;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  /**
   * Constructor.
   *
   * @param customerRepository the customer repository
   */
  public CustomerService(final CustomerRepository customerRepository) {
  }

  public CustomerDto getCustomerByEmail(String email) {
    return null;
  }

  public List<CustomerDto> getAllCustomers() {
    return null;
  }

  public CustomerDto createCustomer(CustomerDto customerDto) {
    return null;
  }

  public CustomerDto updateCustomer(String email, CustomerDto customerDto) {
    return null;
  }

  public void deleteCustomer(String email) {
  }
}
