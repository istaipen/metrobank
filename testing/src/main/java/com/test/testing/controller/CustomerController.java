package com.test.testing.controller;
 
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.testing.dto.CustomerDTO;
import com.test.testing.dto.CustomerDetailDTO;
import com.test.testing.dto.ResponseDTO;
import com.test.testing.exception.CustomerNotFoundException;
import com.test.testing.model.Customer;
import com.test.testing.service.CustomerService;

@RestController
public class CustomerController {

    // @Autowired
    // private AccountRepository accountRepository;

    @Autowired
    private CustomerService accountService;

    // @GetMapping("/getAllAccounts")
    // public ResponseEntity<List<Account>> getAllAccounts(){
    //     try {
    //         List<Account> accountList = new ArrayList<>();
    //         accountRepository.findAll().forEach(accountList::add);

    //         if(accountList.isEmpty()){
    //             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //         }

    //         return new ResponseEntity<>(accountList, HttpStatus.OK);
    //     } catch (Exception ex) {
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }

    // }

    //customer inquiry
    @GetMapping("/api/v1/account/{customerNumber}")
    public ResponseEntity<CustomerDetailDTO> getAccountById(@PathVariable Long customerNumber) throws CustomerNotFoundException{

        CustomerDetailDTO  customerData = accountService.findById(customerNumber);

        if (customerData == null){
            throw new CustomerNotFoundException("");
        }

        return new ResponseEntity<>(customerData, HttpStatus.FOUND);
    }

    //customer creation
    @PostMapping("/api/v1/account")
    public ResponseEntity<ResponseDTO> addAccount(@RequestBody @Valid CustomerDTO customerDTO){

        ResponseDTO responseDTO = new ResponseDTO();
        Customer accountObj = accountService.save(customerDTO);
        responseDTO.setCustomerNumber(accountObj.getCustomerNumber());
        responseDTO.setTransactionStatusCode(HttpStatus.CREATED.value());
        responseDTO.setTransactionStatusDescription("Customer account created");
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);

    }

}

