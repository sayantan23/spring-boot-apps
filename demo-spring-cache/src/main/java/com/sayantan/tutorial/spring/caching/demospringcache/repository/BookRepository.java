package com.sayantan.tutorial.spring.caching.demospringcache.repository;

import com.sayantan.tutorial.spring.caching.demospringcache.model.Book;

public interface BookRepository {
    Book getByIsbn(String isbn);
}
