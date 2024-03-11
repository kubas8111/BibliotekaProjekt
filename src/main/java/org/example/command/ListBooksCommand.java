package org.example.command;

import org.example.library.ILibrary;
import org.example.library.Library;
import org.example.user.UserAccount;

import java.io.Serializable;

public class ListBooksCommand implements UserCommand, Serializable {
    private ILibrary library;

    public ListBooksCommand(ILibrary library) {
        this.library = library;
    }

    @Override
    public void execute() {
        System.out.println("Lista dostępnych książek:");
        library.getBookManager().listBooks(library.getSortingStrategy());
    }
}