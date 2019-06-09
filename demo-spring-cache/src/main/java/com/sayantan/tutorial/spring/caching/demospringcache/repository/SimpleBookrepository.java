package com.sayantan.tutorial.spring.caching.demospringcache.repository;

import com.sayantan.tutorial.spring.caching.demospringcache.model.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookrepository implements BookRepository {
    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book("isbn","Some Book");
    }

    private void simulateSlowService() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
