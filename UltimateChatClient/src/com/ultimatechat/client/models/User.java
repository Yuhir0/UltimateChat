package com.ultimatechat.client.models;

public class User {
    private String username;
    private String password;
    private String color;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String color) {
        this.username = username;
        this.password = password;
        this.color = color;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean check(String password) {
        return this.password.equals(password);
    }

    @Override
    public String toString() {
        return username;
    }
}
