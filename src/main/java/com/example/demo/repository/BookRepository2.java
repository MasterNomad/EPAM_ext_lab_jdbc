package com.example.demo.repository;

import com.example.demo.dto.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository2 {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "password");
    }

    public List<Book> getAllBooks() {
        List<Book> result = new ArrayList<>();
        String sql = "Select * from books";
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                long id = resultSet.getInt(1);
                String title = resultSet.getString("title");
                String author = resultSet.getString(3);
                int publishYear = resultSet.getInt(4);
                result.add(new Book(id, title, author, publishYear));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
