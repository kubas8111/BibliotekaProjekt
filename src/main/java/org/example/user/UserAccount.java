package org.example.user;

import org.example.book.Book;
import org.example.strategy.DefaultSortingStrategy;
import org.example.strategy.SortingStrategy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserAccount implements IUserAccount, Serializable {
    private String login;
    private String password;
    private Permission permission;

    public UserAccount() {
        this.login = "";
        this.password = "";
        this.permission = Permission.ADMIN;
    }

    public UserAccount(String login, String password) {
        this.login = login;
        this.password = password;
        this.permission = Permission.USER;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Permission getPermission() {
        return permission;
    }
}
