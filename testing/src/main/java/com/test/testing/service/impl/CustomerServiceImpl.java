package com.test.testing.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.test.testing.dto.CustomerDTO;
import com.test.testing.dto.CustomerDetailDTO;
import com.test.testing.model.Customer;
import com.test.testing.repository.CustomerRepository;
import com.test.testing.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository accountRepository;

    @Override
    public Customer save(CustomerDTO  customerDTO) {

        Customer customer  =Customer.builder()
                .customerName(customerDTO.getCustomerName())
                .customerMobile(customerDTO.getCustomerMobile())
                .customerEmail(customerDTO.getCustomerEmail())
                .address1(customerDTO.getAddress1())
                .address2(customerDTO.getAddress2())
                .accountType(customerDTO.getAccountType())
                .build();

        Customer accountObj = accountRepository.save(customer);
        return accountObj;
    }

    @Override
    public CustomerDetailDTO findById(Long customerNumber){

        Optional<Customer> customer =accountRepository.findById(customerNumber);

        CustomerDetailDTO dto = null;
        
        if(customer.isPresent()){
            dto = new CustomerDetailDTO();
            dto.setCustomerName(customer.get().getCustomerName());
            dto.setCustomerNumber(customer.get().getCustomerNumber());
            dto.setCustomerMobile(customer.get().getCustomerMobile());
            dto.setCustomerEmail(customer.get().getCustomerEmail());
            dto.setAddress1(customer.get().getAddress1());
            dto.setAddress2(customer.get().getAddress2());
            //dto.setSavings(null);
            dto.setAccountType(customer.get().getAccountType().name());
            dto.setTransactionStatusCode(HttpStatus.FOUND.value());
            dto.setTransactionStatusDescription("Customer Account found");
            
        }
        return dto;
    }
    
}
