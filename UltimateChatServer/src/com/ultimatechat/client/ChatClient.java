package com.ultimatechat.client;

import javax.swing.*;
import java.awt.event.*;

public class ChatClient extends JDialog {
    private JPanel contentPane;
    private JButton sendBtn;
    private JTextField textField1;
    private JScrollPane messages_scroll_view;
    private JScrollPane users_scroll_view;

    public ChatClient() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(sendBtn);

        sendBtn.addActionListener(e -> onOK());


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // call sendMessage() on ENTER
        contentPane.registerKeyboardAction(e -> sendMessage(), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void sendMessage() {

    }

    public static void main(String[] args) {
        ChatClient dialog = new ChatClient();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
