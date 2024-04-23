package com.service;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.metamodel.EntityType;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class PaymentServiceApplicationTest {

  private static final int MAX_LENGTH_NAME = "Column Name".length();
  private static final int MAX_LENGTH_TYPE = "AbstractPayment".length();
  @Container
  static final MySQLContainer<?> mySQLContainer = createMySQLContainer();
  private final EntityManagerFactory emf;

  @Autowired
  public PaymentServiceApplicationTest(EntityManagerFactory emf) {
    this.emf = emf;
  }

  @SuppressWarnings("resource")
  private static MySQLContainer<?> createMySQLContainer() {
    return new MySQLContainer<>("mysql:latest")
        .withDatabaseName("test")
        .withUsername("test")
        .withPassword("test");
  }

  @DynamicPropertySource
  static void setProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
    registry.add("spring.datasource.username", mySQLContainer::getUsername);
    registry.add("spring.datasource.password", mySQLContainer::getPassword);
  }

  @Test
  void showTables() {
    List<EntityType<?>> jpaTables =
        emf.getMetamodel().getEntities().stream().toList();
    String output = buildTableOutput(jpaTables);
    System.out.println(output);
    Assertions.assertTrue(output.contains("Table: Payment"));
    Assertions.assertTrue(output.contains("Table: Customer"));
  }

  private String buildTableOutput(List<EntityType<?>> jpaTables) {
    StringBuilder output = new StringBuilder();
    String format =
        "| %-" + MAX_LENGTH_NAME + "s | %-" + MAX_LENGTH_TYPE + "s |\n";
    for (var table : jpaTables) {
      output
          .append("\nTable: ")
          .append(table.getJavaType().getSimpleName())
          .append("\n");
      output.append(String.format(format, "Column Name", "Type"));
      output.append("| ").append("-".repeat(MAX_LENGTH_NAME)).append(" | ");
      output.append("-".repeat(MAX_LENGTH_TYPE)).append(" |\n");
      table
          .getDeclaredAttributes()
          .forEach(attr -> output.append(String.format(format, attr.getName(),
              attr.getJavaMember().getDeclaringClass().getSimpleName()
          )));
    }
    return output.toString();
  }

  @AfterEach
  void tearDown() {
    emf.close();
  }
}
