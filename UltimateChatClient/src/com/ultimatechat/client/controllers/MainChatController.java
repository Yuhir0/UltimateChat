package com.ultimatechat.client.controllers;

import com.ultimatechat.client.dummy.ChatsList;
import com.ultimatechat.client.dummy.UsersList;
import com.ultimatechat.client.models.Chat;
import com.ultimatechat.client.models.Message;
import com.ultimatechat.client.models.User;
import com.ultimatechat.client.views.ChatPanelView;
import com.ultimatechat.client.views.UserInputPanelView;
import com.ultimatechat.client.views.UsersPanelView;
import com.ultimatechat.client.controllers.basic_controllers.FrameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainChatController extends FrameController {

    private static final Dimension DIMESION_SIZE = new Dimension(720, 480);

    // View components
    private ChatPanelView chatView;
    private UsersPanelView usersView;
    private UserInputPanelView userInputView;
    private User user;
    private User chatingUser;

    // Dummy data
    private UsersList dummyUsers;
    private ChatsList dummyChats;

    public MainChatController() {
        super(DIMESION_SIZE);
    }

    public MainChatController(Dimension d) {
        super(d);
    }

    @Override
    protected void createView(Dimension d) {
        dummyUsers = new UsersList();
        dummyChats = new ChatsList();

        setSize(d);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        user = dummyUsers.users.get(0);

        // Chat
        chatView = new ChatPanelView(getSize(), 80.0, 95.0);
        //chatView.setChat(dummyChats.chats.get(0));
        container.add(chatView, BorderLayout.CENTER);

        // Users
        usersView = new UsersPanelView(getSize(), 20.0, 95.0);
        usersView.setUsers(dummyUsers.users.subList(1,dummyUsers.users.size()).toArray(new User[9]));
        container.add(usersView, BorderLayout.EAST);

        usersView.getUsersListView().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                int index = list.locationToIndex(evt.getPoint());
                System.out.println(dummyUsers.users.get(index + 1));
                changeChatTo(dummyUsers.users.get(index + 1));
            }
        });

        // Input
        userInputView = new UserInputPanelView(getSize(), 100.0, 5.0);
        container.add(userInputView, BorderLayout.SOUTH);

        userInputView.getTexInput().addKeyListener(new KeyListener() {
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

        userInputView.getSendBtn().addActionListener(actionEvent -> {
            if (actionEvent.getActionCommand().equals("Send")) {
                evaluateText();
            }
        });

        addWindowListener(windowListener());
    }

    private void changeChatTo(User newUser) {
        // TODO: Get chat from server
        chatingUser = newUser;
        chatView.setChat(dummyChats.getChatByUsers(user, newUser));
    }

    private void evaluateText() {
        String text = userInputView.getTexInput().getText();
        if (!text.isBlank()) {
            Message message = new Message(user, chatingUser, text.strip());
            sendMessage(message);
            userInputView.getTexInput().setText("");
        }
    }

    private void sendMessage(Message message) {
        if (chatView.getChat() != null) {
            chatView.addMessage(message);
            // TODO: Send message to the server
            System.out.println(message);
        }
    }


    private WindowListener windowListener() {
        return new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("Opened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Closing");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Closed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("Iconified");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("Deiconified");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("Activated");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("Deactivated");
            }
        };
    }
}
