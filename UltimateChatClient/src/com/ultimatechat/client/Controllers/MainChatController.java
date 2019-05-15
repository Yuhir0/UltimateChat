package com.ultimatechat.client.Controllers;

import com.ultimatechat.client.models.Chat;
import com.ultimatechat.client.models.Message;
import com.ultimatechat.client.models.User;
import com.ultimatechat.client.views.ChatPanelView;
import com.ultimatechat.client.views.UserInputPanelView;
import com.ultimatechat.client.views.UsersPanelView;
import com.ultimatechat.client.Controllers.basic_controllers.FrameController;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainChatController extends FrameController {

    private static final Dimension DIMESION_SIZE = new Dimension(720, 480);

    // View components
    private ChatPanelView chatView;
    private UsersPanelView usersView;

    // Controllers
    private InputController inputController;

    public MainChatController() {
        super(DIMESION_SIZE);
    }

    public MainChatController(Dimension d) {
        super(d);
    }

    @Override
    protected void createView(Dimension d) {
        // Set controllers

        setSize(d);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Demo data
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

        // Chat
        chatView = new ChatPanelView(getSize(), 80.0, 95.0);
        chatView.setChat(chat);
        container.add(chatView, BorderLayout.CENTER);

        // Users
        usersView = new UsersPanelView(getSize(), 20.0, 95.0);
        usersView.setUsers(new User[] {user1, user2});
        container.add(usersView, BorderLayout.EAST);

        // Input
        UserInputPanelView userInputView = new UserInputPanelView(getSize(), 100.0, 5.0);
        container.add(userInputView, BorderLayout.SOUTH);

        new InputController(user1, user2, userInputView);

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
