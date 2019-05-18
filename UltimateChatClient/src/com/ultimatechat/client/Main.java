package com.ultimatechat.client;


import com.ultimatechat.client.controllers.MainChatController;

import java.awt.*;

public class Main {

    private static MainChatController chat;

    public static void main(String[] args) {

        start();
    }

    private static void start() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    chat = new MainChatController(new Dimension(1092, 720));
                    chat.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
