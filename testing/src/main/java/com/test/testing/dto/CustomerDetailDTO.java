package com.test.testing.dto;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDetailDTO {

    private Long customerNumber;

    private String customerName;

    private String customerMobile;

    private String customerEmail;

    private String address1;

    private String address2;
    
    private String accountType;
    // private AccountDTO[] savings;

    private int transactionStatusCode;

    private String transactionStatusDescription;
}
