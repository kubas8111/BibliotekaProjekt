package org.example.command;

import org.example.book.Book;
import org.example.library.ILibrary;
import org.example.library.Library;
import org.example.library.LibraryHistory;
import org.example.library.LibraryMemento;
import org.example.user.Permission;
import org.example.user.UserAccount;

import java.io.Serializable;
import java.util.Scanner;

public class AddBookCommand implements UserCommand, Serializable {
    private ILibrary library;

    public AddBookCommand(ILibrary library) {
        this.library = library;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj tytuł książki:");
        String title = readNonEmptyInput(scanner, "Tytuł nie może być pusty");

        System.out.println("Podaj autora książki:");
        String author = readNonEmptyInput(scanner, "Autor nie może być pusty");

        System.out.println("Podaj ISBN książki:");
        String isbn = readNonEmptyInput(scanner, "ISBN nie może być pusty");

        System.out.println("Podaj gatunek książki:");
        String genre = readNonEmptyInput(scanner, "Gatunek nie może być pusty");

        System.out.println("Podaj ocenę książki (między 0 a 10):");
        double rating = readDoubleInput(scanner, "Podano złą wartość");

        Book newBook = new Book(title, author, isbn, genre, rating);
        library.getBookManager().addBook(newBook);

        System.out.println("Książka dodana pomyślnie!");

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

    private double readDoubleInput(Scanner scanner, String errorMessage) {
        double input = -1;
        while(input < 0 || input > 10) {
            try {
                input = Double.parseDouble(scanner.nextLine());
            } catch(NumberFormatException e) {

            }

            if(input < 0 || input > 10) {
                System.out.println(errorMessage);
            }
        }
        return input;
    }
}