package org.example.library;

import java.util.Stack;

public class LibraryHistory {
    private static LibraryHistory instance;
    private Stack<LibraryMemento> mementoStack;

    private LibraryHistory() {
        mementoStack = new Stack<>();
    }

    public static LibraryHistory getInstance() {
        if(instance == null) {
            instance = new LibraryHistory();
        }
        return instance;
    }

    public void saveState(LibraryMemento memento) {
//        System.out.println("ZAPISUJĘ");
        mementoStack.push(memento);
    }

    public LibraryMemento undo() {
        if(mementoStack.size() > 1) {
            mementoStack.pop();
        }
        return mementoStack.peek();
    }
}
