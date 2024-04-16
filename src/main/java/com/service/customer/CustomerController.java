package com.service.customer;

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
@RequestMapping("/customer")
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(final CustomerService service) {
    this.customerService = service;
  }

  @PostMapping
  public ResponseEntity<CustomerDto> createCustomer(
      @RequestBody com.service.customer.CustomerDto customerDto
  ) {
    return ResponseEntity.ok(customerService.createCustomer(customerDto));
  }

  @GetMapping
  public ResponseEntity<List<CustomerDto>> getAllCustomers() {
    return ResponseEntity.ok(customerService.getAllCustomers());
  }

  @GetMapping("/{email}")
  public ResponseEntity<CustomerDto> getCustomerByEmail(
      @PathVariable String email
  ) {
    return ResponseEntity.ok(customerService.getCustomerByEmail(email));
  }

  @PutMapping("/{email}")
  public ResponseEntity<CustomerDto> updateCustomer(
      @PathVariable String email, @RequestBody CustomerDto customerDto
  ) {
    return ResponseEntity.ok(
        customerService.updateCustomer(email, customerDto));
  }

  @DeleteMapping("/{email}")
  public ResponseEntity<Void> deleteCustomer(@PathVariable String email) {
    customerService.deleteCustomer(email);
    return ResponseEntity.noContent().build();
  }
}
