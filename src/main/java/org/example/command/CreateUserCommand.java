package org.example.command;

import org.example.library.ILibrary;
import org.example.library.LibraryHistory;
import org.example.library.LibraryMemento;
import org.example.user.IUserAccount;
import org.example.user.UserAccount;

import java.io.Serializable;
import java.util.Scanner;

public class CreateUserCommand implements UserCommand, Serializable {
    private ILibrary library;

    public CreateUserCommand(ILibrary library) {
        this.library = library;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj login użytkownika:");
        String login = readNonEmptyInput(scanner, "Login nie może być pusty");

        if(library.getUserManager().getUserByLogin(login) != null) {
            System.out.println("Użytkownik o podanym loginie już istnieje.");
            return;
        }

        System.out.println("Podaj hasło użytkownika:");
        String password = readNonEmptyInput(scanner, "Hasło nie może być puste");

        IUserAccount newUser = new UserAccount(login, password);
        library.getUserManager().addUser(newUser);

        System.out.println("Użytkownik utworzony pomyślnie!");

        LibraryHistory.getInstance().saveState(new LibraryMemento(this.library));
    }

    private String readNonEmptyInput(Scanner scanner, String errorMessage) {
        String input = scanner.nextLine();
        while(input.trim().isEmpty()) {
            System.out.println(errorMessage);
            input = scanner.nextLine();
        }
        return input;
    }
}