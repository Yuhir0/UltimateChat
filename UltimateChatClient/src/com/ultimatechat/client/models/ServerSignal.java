package com.ultimatechat.client.models;

public class ServerSignal<T> {

    private T signal;

    public ServerSignal(T signal) {
        this.signal = signal;
    }

    public Class getType() {
        return signal.getClass();
    }

    public T getSignal() {
        return signal;
    }
}
