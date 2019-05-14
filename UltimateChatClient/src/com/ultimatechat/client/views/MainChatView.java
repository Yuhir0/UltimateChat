package com.ultimatechat.views;

import com.ultimatechat.models.Chat;
import com.ultimatechat.models.Message;
import com.ultimatechat.models.User;
import com.ultimatechat.views.basic_views.FrameView;

import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainChatView extends FrameView {

    private static final Dimension DIMESION_SIZE = new Dimension(720, 480);

    // View components
    private ChatPanelView chatView;
    private UsersPanelView usersView;

    public MainChatView() {
        super(DIMESION_SIZE);
    }

    public MainChatView(Dimension d) {
        super(d);
    }

    @Override
    protected void createView(Dimension d) {
        setSize(d);
        setMinimumSize(d);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        //container.setLayout(null);

        // Chat
        User user1 = new User("oscar", "pass");
        User user2 = new User("jordi", "pass");
        Chat chat = new Chat(user1, user2);
        chat.addMesage(new Message(user1, user2, "hola"));
        chat.addMesage(new Message(user2, user1, "hola"));
        chat.addMesage(new Message(user2, user1, "hola"));
        chat.addMesage(new Message(user1, user2, "Que tal?"));
        chat.addMesage(new Message(user1, user2, "Que tal?"));
        chat.addMesage(new Message(user1, user2, "Que tal?"));
        chat.addMesage(new Message(user2, user1, "bien"));
        chat.addMesage(new Message(user2, user1, "bien"));
        chatView = new ChatPanelView(getSize(), 80.0, 95.0);
        chatView.setBounds(0, 0, chatView.getWidth(), chatView.getHeight());
        chatView.setChat(chat);
        container.add(chatView, BorderLayout.CENTER);

        // Users
        usersView = new UsersPanelView(getSize(), 20.0, 95.0);
        //usersView.setBounds(chatView.getWidth(), 0, usersView.getWidth(), usersView.getHeight());
        usersView.setUsers(new User[] {user1, user2});
        container.add(usersView, BorderLayout.EAST);

        // Input
        UserInputPanelView userInputView = new UserInputPanelView(getSize(), 100.0, 5.0);
        //userInputView.setBounds(0, chatView.getHeight(), userInputView.getWidth(), userInputView.getHeight());
        container.add(userInputView, BorderLayout.SOUTH);

        addWindowListener(windowListener());
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
