package org.example.library;

import org.example.book.BookManager;
import org.example.book.IBookManager;
import org.example.command.UserCommandManager;
import org.example.state.AccessState;
import org.example.strategy.SortingStrategy;
import org.example.user.IUserManager;
import org.example.user.UserManager;

public class LibraryMemento {
    private IBookManager books;
    private IUserManager users;
    private SortingStrategy sortingStrategy;
    private AccessState accessState;
    private UserCommandManager commandManager;

    public LibraryMemento(ILibrary library) {
        this.books = new BookManager(library.getBookManager());
        this.users = new UserManager(library.getUserManager());
        this.sortingStrategy = library.getSortingStrategy();
        this.accessState = library.getAccessState();
        this.commandManager = library.getCommandManager();
    }

    public IBookManager getBookManager() {
        return books;
    }

    public IUserManager getUserManager() {
        return users;
    }

    public SortingStrategy getSortingStrategy() {
        return sortingStrategy;
    }

    public AccessState getAccessState() {
        return accessState;
    }

    public UserCommandManager getCommandManager() {
        return commandManager;
    }
}
