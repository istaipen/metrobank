package com.test.testing.dto;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.test.testing.model.AccountType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {

    private Long customerNumber;

    @NotBlank(message = "Customer Name is required field.")
    private String customerName;

    @NotBlank(message = "Customer Mobile is required field.")
    private String customerMobile;

    @NotBlank(message = "Customer Email is required field.")
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String customerEmail;

    @NotBlank(message = "Address1 is required field.")
    private String address1;

    private String address2;
    
    //todo
    private AccountType accountType;
}
