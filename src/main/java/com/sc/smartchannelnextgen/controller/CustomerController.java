package com.sc.smartchannelnextgen.controller;

import com.sc.smartchannelnextgen.common.ResponseData;
import com.sc.smartchannelnextgen.dto.CustomerDto;
import com.sc.smartchannelnextgen.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/healthCheck")
    public Object healthCheck() {
        return customerService.healCheck();
    }

    @GetMapping("/getCustomers")
    public ResponseEntity<Object> getCustomers() {
        return ResponseEntity.ok().body(customerService.getCustomers());
    }

    @PostMapping("/createCus")
    public ResponseEntity<Object> createCus(@RequestBody CustomerDto cus) {
        return ResponseEntity.ok().body(customerService.createCustomer(cus));
    }

    @GetMapping("/getById")
    public ResponseData<List<CustomerDto>> getById(@RequestParam long id) {
        return new ResponseData<List<CustomerDto>>().success(customerService.getById(id));
    }
}
