package org.example.command;

import org.example.library.ILibrary;
import org.example.library.LibraryHistory;
import org.example.library.LibraryMemento;
import org.example.user.IUserManager;

import java.io.Serializable;
import java.util.Scanner;

public class DeleteUserCommand implements UserCommand, Serializable {
    private ILibrary library;

    public DeleteUserCommand(ILibrary library) {
        this.library = library;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj login użytkownika do usunięcia:");
        String userToDelete = scanner.nextLine();
        if(library.getUserManager().deleteUser(userToDelete)) {
            System.out.println("Użytkownik usunięty pomyślnie.");

            LibraryHistory.getInstance().saveState(new LibraryMemento(this.library));
        } else {
            System.out.println("Nie udało się znaleźć użytkownika: " + userToDelete);
        }
    }
}
