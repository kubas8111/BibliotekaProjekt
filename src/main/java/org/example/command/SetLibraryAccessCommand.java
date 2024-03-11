package org.example.command;

import org.example.library.ILibrary;
import org.example.library.Library;
import org.example.library.LibraryHistory;
import org.example.library.LibraryMemento;
import org.example.user.Permission;
import org.example.user.UserAccount;

import java.io.Serializable;
import java.util.Scanner;

public class SetLibraryAccessCommand implements UserCommand, Serializable {
    private ILibrary library;

    public SetLibraryAccessCommand(ILibrary library) {
        this.library = library;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz nowy status dostępu do biblioteki (1 - Otwarta, 2 - Zamknięta):");
        int choice = readIntInput(scanner, "Nieprawidłowy wybór. Wybierz 1 lub 2.");

        if(choice == 1) {
            library.setLibraryOpen();
            System.out.println("Dostęp do biblioteki ustawiony na Otwarty.");
        } else if(choice == 2) {
            library.setLibraryClosed();
            System.out.println("Dostęp do biblioteki ustawiony na Zamknięty.");
        }

        LibraryHistory.getInstance().saveState(new LibraryMemento(this.library));
    }

    private int readIntInput(Scanner scanner, String errorMessage) {
        int input = -1;
        while(input != 1 && input != 2) {
            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {

            }

            if(input != 1 && input != 2) {
                System.out.println(errorMessage);
            }
        }
        return input;
    }
}