package com.librarymanagement5.service;

import com.librarymanagement5.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook() {
        System.out.println("Adding a new book");
        bookRepository.store();
    }
}
