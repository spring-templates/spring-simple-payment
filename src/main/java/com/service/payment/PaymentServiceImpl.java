package com.service.payment;

import com.service.payment.dto.PaymentInitialRequestDto;
import com.service.payment.dto.PaymentStatus;
import com.service.payment.dto.PaymentStatusDto;
import com.service.payment.entity.Payment;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

  private final PaymentRepository repository;

  public PaymentServiceImpl(final PaymentRepository paymentRepository) {
    this.repository = paymentRepository;
  }

  /**
   * Initialize payment.
   *
   * @param requestDto payment request
   * @return payment response
   */
  @Override
  public PaymentStatusDto initialize(
      final PaymentInitialRequestDto requestDto
  ) {
    Payment entity = Payment.of(requestDto);
    // payment validation
    return repository.save(entity).toDto();
  }

  /**
   * Validate payment request.
   *
   * @param request  payment request
   * @param response payment response
   */
  @Override
  public void validate(
      final PaymentInitialRequestDto request, final PaymentStatusDto response
  ) {
    WebClient client = WebClient.builder()
        .defaultHeader("Content-Type", "application/json")
        .defaultHeader("Accept", "*/*")
        .build();

    client.put()
        .uri(request.redirect())
        .bodyValue(response)
        .retrieve()
        .bodyToMono(PaymentStatusDto.class)
        .subscribe(result -> {
          log.info("Response: {}", result);
        }, Throwable::printStackTrace, () -> log.info("Request completed"));
  }

  /**
   * Confirm payment by id.
   *
   * @param id payment id
   * @return payment response
   */
  @Override
  public PaymentStatusDto confirm(final Long id) {
    Payment entity = getPaymentById(id);
    // do payment transaction
    var result = setStatus(entity, PaymentStatus.SUCCESS);
    return repository.save(result).toDto();
  }

  /**
   * Cancel payment by id.
   *
   * @param id payment id
   * @return payment response
   */
  @Override
  public PaymentStatusDto cancel(final Long id) {
    Payment entity = getPaymentById(id);
    return setStatus(entity, PaymentStatus.CANCELLED).toDto();
  }

  private Payment getPaymentById(final Long id) throws EntityNotFoundException {
    return repository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  private Payment setStatus(
      final Payment entity, final PaymentStatus status
  ) throws IllegalArgumentException {
    // TODO(oomia): Check if status change is valid
    entity.setStatus(status);
    return entity;
  }
}
