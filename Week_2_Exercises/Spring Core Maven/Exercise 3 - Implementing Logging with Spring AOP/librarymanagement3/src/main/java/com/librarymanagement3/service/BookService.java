package com.librarymanagement3.service;

import com.librarymanagement3.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String book) {
        if (bookRepository != null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bookRepository.saveBook(book);
            System.out.println("Book added successfully: " + book);
        } else {
            System.out.println("BookRepository is not set. Cannot add book.");
        }
    }
}