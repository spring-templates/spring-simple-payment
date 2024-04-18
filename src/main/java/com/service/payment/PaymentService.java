package com.service.payment;

import com.service.payment.dto.PaymentInitialRequestDto;
import com.service.payment.dto.PaymentStatusDto;

public interface PaymentService {

  PaymentStatusDto initialize(PaymentInitialRequestDto requestDto);

  void validate(PaymentInitialRequestDto request, PaymentStatusDto response);

  PaymentStatusDto confirm(Long id);

  PaymentStatusDto cancel(Long id);
}
