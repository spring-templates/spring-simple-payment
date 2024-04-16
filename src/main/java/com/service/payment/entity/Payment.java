package com.service.payment.entity;

import com.service.customer.entity.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToOne;

@Entity
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private Long id;

  @OneToOne
  @JoinColumns(
      {
          @JoinColumn(name = "seller_email_id", referencedColumnName = "email_id"),
          @JoinColumn(name = "seller_email_provider", referencedColumnName = "email_provider")
      }
  )
  private Customer seller;
  @OneToOne
  @JoinColumns(
      {
          @JoinColumn(name = "buyer_email_id", referencedColumnName = "email_id"),
          @JoinColumn(name = "buyer_email_provider", referencedColumnName = "email_provider")
      }
  )
  private Customer buyer;
  private PaymentMethod method;

  public Customer getSeller() {
    return seller;
  }

  public void setSeller(Customer seller) {
    this.seller = seller;
  }

  public Customer getBuyer() {
    return buyer;
  }

  public void setBuyer(Customer buyer) {
    this.buyer = buyer;
  }

}
