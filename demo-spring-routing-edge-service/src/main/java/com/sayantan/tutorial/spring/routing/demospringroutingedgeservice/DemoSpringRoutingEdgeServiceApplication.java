package com.sayantan.tutorial.spring.routing.demospringroutingedgeservice;

import com.sayantan.tutorial.spring.routing.demospringroutingedgeservice.filter.SimpleFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class DemoSpringRoutingEdgeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringRoutingEdgeServiceApplication.class, args);
    }

    @Bean
    public SimpleFilter simpleFilter(){
        return new SimpleFilter();
    }


}
