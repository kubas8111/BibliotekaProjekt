package org.example.strategy;

import org.example.book.IBook;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

public class AuthorSortingStrategy implements SortingStrategy, Serializable {
    @Override
    public void sort(List<IBook> books) {
        books.sort(Comparator.comparing(IBook::getAuthor));
    }
}