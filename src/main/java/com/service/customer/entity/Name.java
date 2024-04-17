package com.service.customer.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The name of the customer.
 */
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Name {

  /**
   * The first name.
   */
  private String firstName;
  /**
   * The last name.
   */
  private String lastName;

  public static Name of(String name) {
    String[] nameParts = name.split(" ");
    return new Name(nameParts[0], nameParts[1]);
  }
}
