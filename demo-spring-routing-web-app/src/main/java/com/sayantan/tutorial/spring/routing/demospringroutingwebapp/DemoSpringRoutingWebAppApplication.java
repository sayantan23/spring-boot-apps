package com.sayantan.tutorial.spring.routing.demospringroutingwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoSpringRoutingWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringRoutingWebAppApplication.class, args);
    }

    @RequestMapping("/available")
    public String available(){
        return "Spring In Action";
    }

    @RequestMapping("/checked-out")
    public String checkdOut(){
        return "Spring Boot In Action";
    }

}
