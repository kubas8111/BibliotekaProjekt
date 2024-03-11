package org.example.book;

import org.example.strategy.SortingStrategy;

import java.util.List;

public interface IBookManager {
    void addBook(IBook newBook);
    void listBooks(SortingStrategy sortingStrategy);
    IBook getBookByTitle(String title);
    boolean removeBook(String titleToRemove);
    List<IBook> getBooks();
}
