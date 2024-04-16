package com.service.customer;

import com.service.customer.entity.Customer;
import com.service.customer.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Email> {

}
