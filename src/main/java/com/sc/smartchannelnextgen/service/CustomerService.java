package com.sc.smartchannelnextgen.service;

import com.sc.smartchannelnextgen.dto.CustomerDto;
import com.sc.smartchannelnextgen.entity.Customer;
import com.sc.smartchannelnextgen.repository.CustomerRepository;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    Environment env;
    CustomerRepository customerRepository;
    private final String str;

    @Autowired
    public CustomerService(Environment env, CustomerRepository customerRepository) {
        this.env = env;
        this.str = env.getProperty("value.str.test");
        this.customerRepository = customerRepository;
    }

    public Object healCheck() {
        return str;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Object createCustomer(CustomerDto cus) {
        return customerRepository.createCus(cus);
    }

    public List<CustomerDto> getById(long id) {
        UUID uuid = UUID.randomUUID();
        return customerRepository.getCusById(id);
    }
}
