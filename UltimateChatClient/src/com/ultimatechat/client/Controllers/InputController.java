package com.ultimatechat.client.Controllers;

import com.ultimatechat.client.models.Message;
import com.ultimatechat.client.models.User;
import com.ultimatechat.client.views.UserInputPanelView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputController {

    private User user;
    private User destinationUser;
    private UserInputPanelView inputPanelView;

    public InputController(User user, User destinationUser, UserInputPanelView inputPanelView) {
        this.user = user;
        this.destinationUser = destinationUser;
        this.inputPanelView = inputPanelView;

        setViewActions();
    }

    private void setViewActions() {
        inputPanelView.getTexInput().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) { }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyChar() == '\n') {
                    evaluateText();
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) { }
        });

        inputPanelView.getSendBtn().addActionListener(actionEvent -> {
            if (actionEvent.getActionCommand().equals("Send")) {
                evaluateText();
            }
        });
    }

    private void evaluateText() {
        String text = inputPanelView.getTexInput().getText();
        if (!text.isBlank()) {
            sendMessage(new Message(user, destinationUser, text.strip()));
            inputPanelView.getTexInput().setText("");
        }
    }

    private void sendMessage(Message message) {
        System.out.println(message);
    }
}
