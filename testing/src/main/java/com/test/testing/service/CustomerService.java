package com.test.testing.service;

import com.test.testing.dto.CustomerDTO;
import com.test.testing.dto.CustomerDetailDTO;
import com.test.testing.model.Customer;

public interface CustomerService 
{
    //save account
    Customer save(CustomerDTO customerDTO);

    // get account by id
    CustomerDetailDTO findById(Long customerNumber);
}