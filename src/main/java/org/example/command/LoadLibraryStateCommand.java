package org.example.command;

import org.example.library.ILibrary;
import org.example.library.Library;
import org.example.library.LibraryHistory;
import org.example.library.LibraryMemento;
import org.example.user.Permission;
import org.example.user.UserAccount;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class LoadLibraryStateCommand implements UserCommand, Serializable {
    private ILibrary library;

    public LoadLibraryStateCommand(ILibrary library) {
        this.library = library;
    }

    @Override
    public void execute() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("library_state.kotek"))) {
            ILibrary loadedLibrary = (ILibrary) ois.readObject();
            library.loadState(loadedLibrary);
            System.out.println("Stan biblioteki został pomyślnie wczytany.");

            LibraryHistory.getInstance().saveState(new LibraryMemento(this.library));
        } catch(IOException | ClassNotFoundException e) {
            System.out.println("Wystąpił błąd podczas wczytywania stanu biblioteki: " + e.getMessage());
        }
    }
}