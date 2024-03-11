package org.example.command;

import org.example.library.ILibrary;
import org.example.library.Library;

import java.io.Serializable;

public class ExitCommand implements UserCommand, Serializable {
    private ILibrary library;

    public ExitCommand(ILibrary library) {
        this.library = library;
    }

    @Override
    public void execute() {
        System.out.println("Do zobaczenia");
    }
}
