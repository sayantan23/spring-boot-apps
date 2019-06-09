package com.sayantan.tutorials.spring.demospringdatajpa;

import com.sayantan.tutorials.spring.demospringdatajpa.model.Customer;
import com.sayantan.tutorials.spring.demospringdatajpa.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoSpringDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoSpringDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository customerRepository){

        return (args) -> {

            customerRepository.save(new Customer("Jack", "Bauer"));
            customerRepository.save(new Customer("Chloe", "O'Brian"));
            customerRepository.save(new Customer("Kim", "Bauer"));
            customerRepository.save(new Customer("David", "Palmer"));
            customerRepository.save(new Customer("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : customerRepository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");
            // fetch an individual customer by ID
            customerRepository.findById(1L).ifPresent(
                    customer -> {
                        log.info("Customer found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(customer.toString());
                        log.info("");
                    }
            );

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            customerRepository.findByLastName("Bauer").forEach(customer -> {
                log.info(customer.toString());
            });
            log.info("");
        };

    }
}
