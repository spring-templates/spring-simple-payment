package com.service.payment.info;

import com.payment.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends
    JpaRepository<Customer, Long> {

}
