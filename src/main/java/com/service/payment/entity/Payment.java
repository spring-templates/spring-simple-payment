package com.service.payment.entity;

import com.service.customer.entity.Customer;
import com.service.payment.dto.PaymentInitialRequestDto;
import com.service.payment.dto.PaymentStatusDto;
import com.service.payment.dto.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(fetch = jakarta.persistence.FetchType.LAZY, cascade = jakarta.persistence.CascadeType.ALL, optional = false)
  @JoinColumn(nullable = false, unique = true)
  private Customer seller;

  @OneToOne(fetch = jakarta.persistence.FetchType.LAZY, cascade = jakarta.persistence.CascadeType.ALL, optional = false)
  @JoinColumn(nullable = false, unique = true)
  private Customer buyer;

  private AbstractPayment method;

  private PaymentStatus status;

  public static Payment of(final PaymentInitialRequestDto requestDto) {
    Payment payment = new Payment();
    payment.setSeller(Customer.of(requestDto.seller()));
    payment.setBuyer(Customer.of(requestDto.buyer()));
    payment.setMethod(requestDto.payment());
    payment.setStatus(PaymentStatus.PENDING);
    return payment;
  }

  public PaymentStatusDto toDto() {
    return new PaymentStatusDto(id, status);
  }
}
