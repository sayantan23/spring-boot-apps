package com.sayantan.tutorials.spring.demospringdatajpa.repository;

import com.sayantan.tutorials.spring.demospringdatajpa.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
