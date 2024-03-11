package org.example.strategy;

import org.example.book.IBook;

import java.io.Serializable;
import java.util.List;

public class DefaultSortingStrategy implements SortingStrategy, Serializable {
    @Override
    public void sort(List<IBook> books) {
        
    }
}
