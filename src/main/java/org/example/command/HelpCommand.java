package org.example.command;

import org.example.library.ILibrary;

import java.io.Serializable;

public class HelpCommand implements UserCommand, Serializable {
    private ILibrary library;

    public HelpCommand(ILibrary library) {
        this.library = library;
    }

    @Override
    public void execute() {
        library.getCommandManager().displayCommands();
    }
}
