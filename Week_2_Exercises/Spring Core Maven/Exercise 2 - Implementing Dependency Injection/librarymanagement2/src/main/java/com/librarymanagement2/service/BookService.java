package com.librarymanagement2.service;

import com.librarymanagement2.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public BookService() {
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String book) {
        if (bookRepository != null) {
            bookRepository.saveBook(book);
            System.out.println("Book added successfully through setter injection!");
        } else {
            System.out.println("BookRepository is not set. Cannot add book.");
        }
    }
}