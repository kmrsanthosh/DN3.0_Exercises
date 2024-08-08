package com.librarymanagement3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.librarymanagement3.service.BookService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = context.getBean(BookService.class);

        bookService.addBook("Spring in Action");
        bookService.addBook("Effective Java");
        bookService.addBook("Clean Code");

        System.out.println("Application ran successfully!");
    }
}