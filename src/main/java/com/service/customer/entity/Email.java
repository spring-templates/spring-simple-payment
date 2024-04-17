package com.service.customer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public final class Email implements Serializable {

  /**
   * The email id.
   */
  @Column(name = "email_id")
  private String id;
  /**
   * The email provider.
   */
  @Column(name = "email_provider")
  private String provider;

  public static Email of(final String email) {
    String[] emailParts = email.split("@");
    return new Email(emailParts[0], emailParts[1]);
  }

  @Override
  public boolean equals(final Object obj) {
    return this == obj || (obj instanceof Email email && Objects.equals(
        id, email.id) && Objects.equals(provider, email.provider));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, provider);
  }
}
