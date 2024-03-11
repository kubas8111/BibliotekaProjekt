package org.example.command;

import org.example.library.ILibrary;
import org.example.library.Library;
import org.example.library.LibraryHistory;
import org.example.library.LibraryMemento;
import org.example.strategy.*;

import java.io.Serializable;
import java.util.Scanner;

public class SetSortingStrategyCommand implements UserCommand, Serializable {
    private ILibrary library;

    public SetSortingStrategyCommand(ILibrary library) {
        this.library = library;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz strategię sortowania (1 - Tytuł, 2 - Autor, 3 - Ocena):");
        int choice = readIntInput(scanner, "Nieprawidłowy wybór. Wybierz 1, 2 lub 3.");

        SortingStrategy sortingStrategy = null;
        switch (choice) {
            case 1:
                sortingStrategy = new TitleSortingStrategy();
                break;
            case 2:
                sortingStrategy = new AuthorSortingStrategy();
                break;
            case 3:
                sortingStrategy = new RatingSortingStrategy();
                break;
            default:
                System.out.println("Nieprawidłowy wybór. Nie zmieniono strategii sortowania.");
                return;
        }

        library.setSortingStrategy(sortingStrategy);
        System.out.println("Strategia sortowania ustawiona pomyślnie.");

        LibraryHistory.getInstance().saveState(new LibraryMemento(this.library));
    }

    private int readIntInput(Scanner scanner, String errorMessage) {
        int input = -1;
        while(input != 1 && input != 2 && input != 3) {
            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException e) {

            }

            if(input != 1 && input != 2 && input != 3) {
                System.out.println(errorMessage);
            }
        }
        return input;
    }
}