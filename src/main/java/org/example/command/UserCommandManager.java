package org.example.command;

import org.example.library.ILibrary;
import org.example.library.Library;
import org.example.user.UserAccount;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserCommandManager implements Serializable {
    private ILibrary library;
    private Map<String, UserCommand> commands;

    public UserCommandManager(Library library) {
        this.library = library;
        this.commands = initializeCommands();
    }

    public void executeCommand(String commandName) {
        UserCommand command = commands.get(commandName);
        if(command != null) {
            command.execute();
        } else {
            System.out.println("Nieznana komenda. Spróbuj ponownie.");
        }
    }

    private Map<String, UserCommand> initializeCommands() {
        Map<String, UserCommand> commandMap = new HashMap<>();

        commandMap.put("addbook", new AddBookCommand(library));
        commandMap.put("listbooks", new ListBooksCommand(library));
        commandMap.put("loadbooks", new LoadBooksCommand(library));
        commandMap.put("removebook", new RemoveBookCommand(library));

        commandMap.put("createuser", new CreateUserCommand(library));
        commandMap.put("listusers", new ListUsersCommand(library));
        commandMap.put("deleteuser", new DeleteUserCommand(library));

        commandMap.put("setlibraryaccess", new SetLibraryAccessCommand(library));

        commandMap.put("setsortingstrategy", new SetSortingStrategyCommand(library));

        commandMap.put("savelibrarystate", new SaveLibraryStateCommand(library));
        commandMap.put("loadlibrarystate", new LoadLibraryStateCommand(library));

        commandMap.put("undo", new UndoCommand(library));
        commandMap.put("help", new HelpCommand(library));
        commandMap.put("exit", new ExitCommand(library));

        return commandMap;
    }

    public void displayCommands() {
        System.out.println("Dostępne komendy:");
        for(String command : commands.keySet()) {
            System.out.println(command);
        }
    }

    public String readCommandFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(">>");
        return scanner.nextLine().trim().toLowerCase();
    }
}
