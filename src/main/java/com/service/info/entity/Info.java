package com.service.info.entity;

import com.service.customer.entity.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Info {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private Long id;

  @OneToOne
  @JoinColumns(
      {
          @JoinColumn(name = "customer_email_id", referencedColumnName = "email_id"),
          @JoinColumn(name = "customer_email_provider", referencedColumnName = "email_provider")
      }
  )
  private Customer customer;
  // 결제 금액
  private int paymentAmount;

}
