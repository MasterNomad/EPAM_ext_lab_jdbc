package com.example.demo.repository;

import com.example.demo.dto.Book;
import com.example.demo.repository.interfaces.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BookRepository implements IBookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Book> ROW_MAPPER = (resultSet, rowNum) -> new Book(resultSet.getLong("id"),
            resultSet.getString("title"),
            resultSet.getString("author"),
            resultSet.getInt("publish_year"));

    @Override
    public void addBook(Book book) {
        String sql = "INSERT INTO books (`id`, `title`, `author`, `publish_year`) " +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, book.getId(), book.getTitle(), book.getAuthor(), book.getPublishYear());
    }

    @Override
    public List<Book> getAllBids() {
        String sql = "SELECT * FROM books ";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }

    @Override

    public List<Book> getBidsByUserId(int userId) {
        String sql = "SELECT * FROM book WHERE id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, ROW_MAPPER);
    }

    @Override
    public void deleteBidsByUserId(int userId) {
        String sql = "DELETE FROM books WHERE id = ?";
        jdbcTemplate.update(sql, userId);
    }

}
