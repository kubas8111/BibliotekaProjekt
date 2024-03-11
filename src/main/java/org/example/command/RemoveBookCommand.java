package org.example.command;

import org.example.library.ILibrary;
import org.example.library.Library;
import org.example.library.LibraryHistory;
import org.example.library.LibraryMemento;
import org.example.user.Permission;
import org.example.user.UserAccount;

import java.io.Serializable;
import java.util.Scanner;

public class RemoveBookCommand implements UserCommand, Serializable {
    private ILibrary library;

    public RemoveBookCommand(ILibrary library) {
        this.library = library;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj tytuł książki do usunięcia:");
        String titleToRemove = scanner.nextLine();

        if(library.getBookManager().removeBook(titleToRemove)) {
            System.out.println("Książka usunięta pomyślnie.");

            LibraryHistory.getInstance().saveState(new LibraryMemento(this.library));
        } else {
            System.out.println("Nie udało się znaleźć książki o tytule: " + titleToRemove);
        }
    }
}