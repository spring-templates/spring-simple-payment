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

  /**
   * Create a new name.
   *
   * @param name the name
   * @return the name
   */
  public static Name of(final String name) {
    String[] nameParts = name.split(" ");
    return new Name(nameParts[0], nameParts[1]);
  }
}
