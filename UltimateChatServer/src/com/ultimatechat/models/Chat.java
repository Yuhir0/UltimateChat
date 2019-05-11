package com.ultimatechat.models;

import java.util.ArrayList;

public class Chat {
    private String id;
    private ArrayList<Message> messages;

    public Chat(User userOne, User userTwo) {
        this.id = userOne.getUsername() + "+" + userTwo.getUsername();
    }

    private String getId() {
        return this.id;
    }

    private ArrayList<Message> getMessages() {
        return this.messages;
    }

    private void addMesage(Message message) {
        this.messages.add(message);
    }
}
