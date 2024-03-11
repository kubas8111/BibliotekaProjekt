package org.example;

import org.example.library.ILibrary;
import org.example.library.Library;
import org.example.library.LibraryHistory;
import org.example.library.LibraryMemento;

public class Main {
    public static void main(String[] args) {
        ILibrary library = new Library();
        LibraryHistory.getInstance().saveState(new LibraryMemento(library));
        library.libraryLoop();
    }
}