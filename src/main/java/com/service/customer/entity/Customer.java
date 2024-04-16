package com.service.customer.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Customer {

  @EmbeddedId
  private Email email;

  @Embedded
  private Name name;

}
