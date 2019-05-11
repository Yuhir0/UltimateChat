package com.ultimatechat.controllers;

import com.ultimatechat.exceptions.CreateUserException;
import com.ultimatechat.models.User;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class DatabaseController {
    private final String databaseName = "ChatServer.DB";

    private ODB database;

    public DatabaseController() {
        this.database = ODBFactory.open(databaseName);
    }

    public User login(String username, String password) throws CreateUserException {
        ICriterion where = Where.equal("username", username);
        IQuery query = new CriteriaQuery(User.class, where);
        Objects<User> users = database.getObjects(query);

        if (users.size() == 0) {
            throw new CreateUserException("Incorrect username");
        } else if (!users.getFirst().check(password)) {
            throw new CreateUserException("Incorrect password");
        }

        return users.getFirst();
    }

    public User createUser(String username, String password) throws CreateUserException {
        ICriterion where = Where.equal("username", username);
        IQuery query = new CriteriaQuery(User.class, where);
        Objects<User> users = database.getObjects(query);

        if (users.size() >= 1) {
            throw new CreateUserException("This user already exists");
        }

        User newUser = new User(username, password);
        database.store(newUser);
        return newUser;
    }
}
