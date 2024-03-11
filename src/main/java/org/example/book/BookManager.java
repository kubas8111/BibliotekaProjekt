package org.example.book;

import org.example.strategy.SortingStrategy;
import org.example.user.IUserAccount;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookManager implements IBookManager, Serializable {
    private List<IBook> books;

    public BookManager() {
        this.books = new ArrayList<>();
    }

    public BookManager(IBookManager copy) {
        this.books = new ArrayList<>();

        for(IBook book : copy.getBooks()) {
            this.books.add(new Book(book.getTitle(), book.getAuthor(), book.getIsbn(), book.getGenre(), book.getRating()));
        }
    }

    @Override
    public void addBook(IBook newBook) {
        this.books.add(newBook);
    }

    @Override
    public void listBooks(SortingStrategy sortingStrategy) {
        sortingStrategy.sort(this.books);
        for(IBook book : books) {
            System.out.println(book);
        }
    }

    @Override
    public IBook getBookByTitle(String title) {
        for(IBook book : books) {
            if(book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public boolean removeBook(String title) {
        IBook bookToRemove = getBookByTitle(title);
        if(bookToRemove != null) {
            books.remove(bookToRemove);
            return true;
        }
        return false;
    }

    @Override
    public List<IBook> getBooks() {
        return this.books;
    }
}
