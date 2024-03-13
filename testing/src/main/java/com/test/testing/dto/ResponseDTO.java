package com.test.testing.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
    private Long customerNumber;
    private int transactionStatusCode;
    private String transactionStatusDescription;
    
}
