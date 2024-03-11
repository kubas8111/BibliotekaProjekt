package org.example.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserManager implements IUserManager, Serializable {
    private List<IUserAccount> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public UserManager(IUserManager copy) {
        this.users = new ArrayList<>();

        for(IUserAccount user : copy.getUsers()) {
            this.users.add(new UserAccount(user.getLogin(), user.getPassword()));
        }
    }

    @Override
    public void addUser(IUserAccount user) {
        users.add(user);
    }

    @Override
    public boolean deleteUser(String login) {
        IUserAccount userToDelete = getUserByLogin(login);
        if(userToDelete != null) {
            users.remove(userToDelete);
            return true;
        }
        return false;
    }

    @Override
    public IUserAccount getUserByLogin(String login) {
        for(IUserAccount user : users) {
            if(user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void listUsers() {
        for(IUserAccount user : users) {
            System.out.println(user.getLogin());
        }
    }

    @Override
    public List<IUserAccount> getUsers() {
        return this.users;
    }
}