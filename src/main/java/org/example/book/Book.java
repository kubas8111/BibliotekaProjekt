package org.example.book;

import java.io.Serializable;

public class Book implements IBook, Serializable {
    private String title;
    private String author;
    private String isbn;
    private String genre;
    private double rating;

    public Book(String title, String author, String isbn, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.rating = rating;
    }
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getIsbn() {
        return isbn;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Tytuł: " + title +
                ", Autor: " + author +
                ", ISBN: " + isbn +
                ", Gatunek: " + genre +
                ", Ocena: " + rating;
    }
}
