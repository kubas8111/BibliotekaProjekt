package org.example.command;

import org.example.book.Book;
import org.example.library.ILibrary;
import org.example.library.Library;
import org.example.library.LibraryHistory;
import org.example.library.LibraryMemento;
import org.example.user.Permission;
import org.example.user.UserAccount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

public class LoadBooksCommand implements UserCommand, Serializable {
    private ILibrary library;

    public LoadBooksCommand(ILibrary library) {
        this.library = library;
    }

    @Override
    public void execute() {
        try(BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while((line = reader.readLine()) != null) {
                //Format: Tytuł;Autor;ISBN;Gatunek;Ocena
                String[] bookData = line.split(";");
                if(bookData.length >= 5) {
                    Book book = new Book(bookData[0], bookData[1], bookData[2], bookData[3], Double.parseDouble(bookData[4]));
                    library.getBookManager().addBook(book);
                }
            }
            System.out.println("Książki zostały wczytane pomyślnie.");

            LibraryHistory.getInstance().saveState(new LibraryMemento(this.library));
        } catch(IOException | NumberFormatException e) {
            System.out.println("Wystąpił błąd podczas wczytywania książek: " + e.getMessage());
        }
    }
}