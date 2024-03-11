package org.example.command;

import org.example.library.ILibrary;
import org.example.library.Library;
import org.example.library.LibraryHistory;
import org.example.library.LibraryMemento;

import java.io.Serializable;

public class UndoCommand implements UserCommand, Serializable {
    private ILibrary library;

    public UndoCommand(ILibrary library) {
        this.library = library;
    }

    @Override
    public void execute() {
        LibraryMemento memento = LibraryHistory.getInstance().undo();
        if(memento != null) {
            library.restoreFromMemento(memento);
        }
        System.out.println("Cofnięto");
    }
}
