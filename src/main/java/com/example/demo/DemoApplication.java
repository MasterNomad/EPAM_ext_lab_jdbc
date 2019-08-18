package com.example.demo;

import com.example.demo.dto.Book;
import com.example.demo.service.LibraryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		LibraryService libraryService = context.getBean(LibraryService.class);

		System.out.println(libraryService.getAllBooks());
		libraryService.addBook(new Book(2, "Harry Potter", "Rouling", 1999));
		System.out.println(libraryService.getAllBooks());
	}

}
