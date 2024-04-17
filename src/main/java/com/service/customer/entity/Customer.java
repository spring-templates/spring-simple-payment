package com.service.customer.entity;

import com.service.customer.CustomerRequestDto;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Embedded
  private Email email;

  @Embedded
  private Name name;

  public static Customer of(final CustomerRequestDto seller) {
    Customer customer = new Customer();
    customer.setEmail(Email.of(seller.email()));
    customer.setName(Name.of(seller.name()));
    return customer;
  }

}
