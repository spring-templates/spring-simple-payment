package com.service.payment.entity;

import com.service.customer.entity.Customer;
import com.service.payment.dto.PaymentInitialRequestDto;
import com.service.payment.dto.PaymentStatus;
import com.service.payment.dto.PaymentStatusDto;
import jakarta.persistence.CascadeType;
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

  /**
   * The payment ID.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * The customer information of seller.
   *
   * @see com.service.customer.entity.Customer
   */

  @OneToOne(
      fetch = jakarta.persistence.FetchType.LAZY,
      cascade = CascadeType.PERSIST,
      optional = false
  )
  @JoinColumn(nullable = false, unique = true)
  private Customer seller;

  /**
   * The customer information of buyer.
   *
   * @see com.service.customer.entity.Customer
   */
  @OneToOne(
      fetch = jakarta.persistence.FetchType.LAZY,
      cascade = CascadeType.PERSIST,
      optional = false
  )
  @JoinColumn(nullable = false, unique = true)
  private Customer buyer;

  /**
   * The payment method.
   *
   * @see com.service.payment.entity.AbstractPayment
   */
  private AbstractPayment method;

  /**
   * The payment status.
   *
   * @see com.service.payment.dto.PaymentStatus
   */
  private PaymentStatus status;

  /**
   * Create payment from request DTO.
   *
   * @param requestDto initial payment request DTO
   *                   {@link com.service.payment.dto.PaymentInitialRequestDto}
   * @return payment entity
   */
  public static Payment of(final PaymentInitialRequestDto requestDto) {
    Payment payment = new Payment();
    payment.setSeller(Customer.of(requestDto.seller()));
    payment.setBuyer(Customer.of(requestDto.buyer()));
    payment.setMethod(requestDto.payment());
    payment.setStatus(PaymentStatus.PENDING);
    return payment;
  }

  /**
   * Convert payment entity to DTO.
   *
   * @return payment status DTO {@link com.service.payment.dto.PaymentStatusDto}
   */
  public PaymentStatusDto toDto() {
    return new PaymentStatusDto(id, status);
  }
}
