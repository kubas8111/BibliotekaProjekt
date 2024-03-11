package org.example.command;

import org.example.library.ILibrary;

import java.io.Serializable;

public class ListUsersCommand implements UserCommand, Serializable {
    private ILibrary library;

    public ListUsersCommand(ILibrary library) {
        this.library = library;
    }

    @Override
    public void execute() {
        System.out.println("Lista użytkowników:");
        library.getUserManager().listUsers();
    }
}
