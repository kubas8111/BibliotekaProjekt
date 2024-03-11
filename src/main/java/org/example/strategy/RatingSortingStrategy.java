package org.example.strategy;

import org.example.book.IBook;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

public class RatingSortingStrategy implements SortingStrategy, Serializable {
    @Override
    public void sort(List<IBook> books) {
        books.sort(Comparator.comparing(IBook::getRating, Comparator.reverseOrder()));
    }
}