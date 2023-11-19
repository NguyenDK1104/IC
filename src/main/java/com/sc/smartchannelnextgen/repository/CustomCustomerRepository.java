package com.sc.smartchannelnextgen.repository;

import com.sc.smartchannelnextgen.dto.CustomerDto;

import java.util.List;

public interface CustomCustomerRepository {
    Object createCus(CustomerDto cus);

    List<CustomerDto> getCusById(long id);
}
