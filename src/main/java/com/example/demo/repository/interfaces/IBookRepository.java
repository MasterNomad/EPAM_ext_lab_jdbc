package com.example.demo.repository.interfaces;

import com.example.demo.dto.Book;

import java.util.List;
import java.util.Map;

public interface IBookRepository {

    void addBook(Book book);

    List<Book> getAllBids();

    List<Book> getBidsByUserId(int userId);

    void deleteBidsByUserId(int userId);

}
