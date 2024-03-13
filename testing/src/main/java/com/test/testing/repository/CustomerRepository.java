package com.test.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.testing.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
}
