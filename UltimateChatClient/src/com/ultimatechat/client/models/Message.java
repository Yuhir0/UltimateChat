package com.ultimatechat.models;

public class Message {
    private User emissor;
    private User receptor;
    private String message;

    public Message(User emissor, User receptor, String message) {
        this.emissor = emissor;
        this.receptor = receptor;
        this.message = message;
    }

    public User getEmissor() {
        return emissor;
    }

    public void setEmissor(User emissor) {
        this.emissor = emissor;
    }

    public User getReceptor() {
        return receptor;
    }

    public void setReceptor(User receptor) {
        this.receptor = receptor;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return emissor + ": " + message;
    }
}
