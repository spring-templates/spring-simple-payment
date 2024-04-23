package com.service.payment;

import com.service.payment.dto.PaymentInitialRequestDto;
import com.service.payment.dto.PaymentStatusDto;

public interface PaymentService {

  /**
   * Initialize payment.
   *
   * @param requestDto payment request
   * @return payment response
   */

  PaymentStatusDto initialize(PaymentInitialRequestDto requestDto);

  /**
   * Validate payment request.
   *
   * @param request  payment request
   * @param response payment response
   */

  void validate(PaymentInitialRequestDto request, PaymentStatusDto response);

  /**
   * Confirm payment.
   *
   * @param id payment ID
   * @return payment status
   */

  PaymentStatusDto confirm(Long id);

  /**
   * Cancel payment.
   *
   * @param id payment ID
   * @return payment status
   */
  PaymentStatusDto cancel(Long id);
}
