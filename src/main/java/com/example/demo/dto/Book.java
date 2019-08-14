package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "books")
public class Book {

    @Id
    private long id;
    private String title;
    private String author;
    private int publishYear;

    public Book() {
    }

    public Book(long id, String title, String author, int publishYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishYear=" + publishYear +
                '}';
    }
}


