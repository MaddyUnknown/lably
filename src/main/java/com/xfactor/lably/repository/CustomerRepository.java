package com.xfactor.lably.repository;

import java.util.List;

import com.xfactor.lably.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
    Customer findByName(String name);

    List<Customer> findTop5By();
}
