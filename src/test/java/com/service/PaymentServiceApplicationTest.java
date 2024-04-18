package com.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = PaymentServiceApplication.class)
@ActiveProfiles("test")
class PaymentServiceApplicationTest {

  @Test
  @SuppressWarnings("EmptyMethod")
  void contextLoads() {
  }
}
