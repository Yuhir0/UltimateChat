package com.ultimatechat.client.models;

import java.util.ArrayList;

public class Chat {
    private String id;
    private ArrayList<Message> messages;

    public Chat(User userOne, User userTwo) {
        this.id = userOne.getUsername() + "+" + userTwo.getUsername();
        this.messages = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public ArrayList<Message> getMessages() {
        return this.messages;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public void deleteMessage(Message message) {
        messages.remove(message);
    }

    public void deleteMessage(int index) {
        messages.remove(index);
    }

    public void clearChat() {
        messages = new ArrayList<>();
    }
}
