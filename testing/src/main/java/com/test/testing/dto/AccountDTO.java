package com.test.testing.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {

    private Long accountNumber ;

    private String accountType;

    private Long availableBalance;
}
