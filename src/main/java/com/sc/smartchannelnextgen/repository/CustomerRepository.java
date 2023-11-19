package com.sc.smartchannelnextgen.repository;

import com.sc.smartchannelnextgen.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomCustomerRepository {
}
