package com.ultimatechat.client.dummy;

import com.ultimatechat.client.models.User;

import java.util.ArrayList;

public class UsersList {
    public ArrayList<User> users;

    public UsersList() {
        users = new ArrayList<>();
        users.add(new User("Oscar", null));
        users.add(new User("Julian", null));
        users.add(new User("Alvaro", null));
        users.add(new User("Laura", null));
        users.add(new User("Daniel", null));
        users.add(new User("Elena", null));
        users.add(new User("Claudia", null));
        users.add(new User("Ruben", null));
        users.add(new User("Alba", null));
        users.add(new User("Alex", null));
    }
}
