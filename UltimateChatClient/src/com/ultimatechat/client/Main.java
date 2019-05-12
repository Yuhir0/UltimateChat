package com.ultimatechat.client;


import com.ultimatechat.views.MainChatView;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Dimension d = new Dimension();

        start();
    }

    private static void start() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainChatView chat = new MainChatView(new Dimension(720, 480));
                    chat.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
