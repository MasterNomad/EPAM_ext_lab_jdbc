package com.example.demo.repository.interfaces;

import com.example.demo.dto.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJPA extends CrudRepository<Book, Long> {
}
