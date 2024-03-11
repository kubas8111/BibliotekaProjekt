package org.example.command;

import org.example.library.ILibrary;
import org.example.library.Library;
import org.example.user.Permission;
import org.example.user.UserAccount;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SaveLibraryStateCommand implements UserCommand, Serializable {
    private ILibrary library;

    public SaveLibraryStateCommand(ILibrary library) {
        this.library = library;
    }

    @Override
    public void execute() {
        this.library.saveState();
    }
}