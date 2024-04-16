package com.service.customer.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Customer {

  @EmbeddedId
  private Email email;

  @Embedded
  private Name name;
}
