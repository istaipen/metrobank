package com.test.testing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
// @Table(name="customer")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Data
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerNumber;

    @Column(length = 50)
    private String customerName;

    @Column(length = 20)
    private String customerMobile;

    @Column(length = 50)
    private String customerEmail;

    @Column(length = 100)
    private String address1;

    @Column(length = 100)
    private String address2;
    
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}
