package org.example.library;

import org.example.book.IBook;
import org.example.book.IBookManager;
import org.example.command.UserCommandManager;
import org.example.state.AccessState;
import org.example.strategy.SortingStrategy;
import org.example.user.IUserManager;
import org.example.user.UserAccount;

import java.util.List;

public interface ILibrary {
    void libraryLoop();
    void setLibraryOpen();
    void setLibraryClosed();
    void setSortingStrategy(SortingStrategy sortingStrategy);
    void saveState();
    void loadState(ILibrary loadedLibrary);
    IUserManager getUserManager();
    IBookManager getBookManager();
    SortingStrategy getSortingStrategy();
    AccessState getAccessState();
    UserCommandManager getCommandManager();
    LibraryMemento createMemento();
    void restoreFromMemento(LibraryMemento memento);
}
