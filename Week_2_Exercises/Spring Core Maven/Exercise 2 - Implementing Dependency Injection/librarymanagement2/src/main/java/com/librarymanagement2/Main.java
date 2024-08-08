package com.librarymanagement2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.librarymanagement2.service.BookService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = context.getBean(BookService.class);

        bookService.addBook("Spring in Action");
        bookService.addBook("Effective Java");

        System.out.println("Application ran successfully!");
    }
}