package com.sayantan.tutorial.spring.caching.demospringcache.model;

import lombok.Data;
import org.springframework.cache.annotation.Cacheable;

@Data
public class Book {

    private String isbn;
    private String title;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public Book() {
    }
}
