package org.example.strategy;

import org.example.book.IBook;

import java.util.List;

public interface SortingStrategy {
    void sort(List<IBook> books);
}