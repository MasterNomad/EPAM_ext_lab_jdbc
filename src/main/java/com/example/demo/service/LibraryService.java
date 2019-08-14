package com.example.demo.service;

import com.example.demo.dto.Book;
import com.example.demo.repository.interfaces.BookJPA;
import com.example.demo.repository.interfaces.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private BookJPA bookJPA;

    @Autowired
    private IBookRepository bookRepository;

    @PostConstruct
    public void init() {
        bookJPA.save(new Book(1, "Lord of the Ring", "Tolkien", 1964));
    }

    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    public List<Book> getAllBids() {
        return bookRepository.getAllBids();
    }

}
