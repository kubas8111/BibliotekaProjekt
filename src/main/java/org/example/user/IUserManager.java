package org.example.user;

import java.util.List;

public interface IUserManager {
    void addUser(IUserAccount user);
    boolean deleteUser(String login);
    IUserAccount getUserByLogin(String login);
    void listUsers();
    List<IUserAccount> getUsers();
}
