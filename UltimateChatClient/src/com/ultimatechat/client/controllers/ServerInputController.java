package com.ultimatechat.client.controllers;

import com.ultimatechat.client.models.Message;
import com.ultimatechat.client.models.ServerSignal;

public class ServerInputController extends Thread {

    private boolean done;


    @Override
    public void run() {
        while (!done) {
            // getSetverSignal(signal);
        }
    }

    public void kill() {
        done = true;
    }

    private void getServerSignal(ServerSignal<?> signal) {
        Class type = signal.getType();
        if (type == Message.class) {
            setNewMessage((Message) signal.getSignal());
        }
    }

    private void setNewMessage (Message message) {

    }

}
