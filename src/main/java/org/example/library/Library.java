package org.example.library;

import org.example.book.*;
import org.example.command.UserCommandManager;
import org.example.state.*;
import org.example.strategy.*;
import org.example.user.IUserManager;
import org.example.user.UserAccount;
import org.example.user.UserManager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library implements ILibrary, Serializable {
    private IBookManager books;
    private IUserManager users;
    private SortingStrategy sortingStrategy;
    private AccessState accessState;
    private UserCommandManager commandManager;

    public Library() {
        this.books = new BookManager();
        this.users = new UserManager();
        this.sortingStrategy = new DefaultSortingStrategy();
        this.accessState = new OpenState();
        this.commandManager = new UserCommandManager(this);
    }

    @Override
    public void libraryLoop() {
        String userInput;
        do {
            userInput = commandManager.readCommandFromUser();
            commandManager.executeCommand(userInput);
        } while(!userInput.equalsIgnoreCase("exit"));
    }

    @Override
    public void setLibraryOpen() {
        this.accessState = new OpenState();
    }

    @Override
    public void setLibraryClosed() {
        this.accessState = new ClosedState();
    }

    @Override
    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    @Override
    public void saveState() {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("library_state.kotek"))) {
            outputStream.writeObject(this);
            System.out.println("Stan biblioteki został zapisany pomyślnie.");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadState(ILibrary loadedLibrary) {
        this.books = loadedLibrary.getBookManager();
        this.users = loadedLibrary.getUserManager();
        this.sortingStrategy = loadedLibrary.getSortingStrategy();
        this.accessState = loadedLibrary.getAccessState();
        this.commandManager = loadedLibrary.getCommandManager();
    }

    @Override
    public IUserManager getUserManager() {
        return this.users;
    }

    @Override
    public IBookManager getBookManager() {
        return this.books;
    }

    @Override
    public SortingStrategy getSortingStrategy() {
        return sortingStrategy;
    }

    @Override
    public AccessState getAccessState() {
        return accessState;
    }

    @Override
    public UserCommandManager getCommandManager() {
        return commandManager;
    }

    public LibraryMemento createMemento() {
        return new LibraryMemento(this);
    }

    public void restoreFromMemento(LibraryMemento memento) {
        this.books = new BookManager(memento.getBookManager());
        this.users = new UserManager(memento.getUserManager());
        this.sortingStrategy = memento.getSortingStrategy();
        this.accessState = memento.getAccessState();
        this.commandManager = memento.getCommandManager();
    }
}
