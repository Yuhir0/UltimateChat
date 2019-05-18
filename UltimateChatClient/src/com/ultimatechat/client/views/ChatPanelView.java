package com.ultimatechat.client.views;

import com.ultimatechat.client.models.Chat;
import com.ultimatechat.client.models.Message;
import com.ultimatechat.client.views.basic_views.PanelView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChatPanelView extends PanelView {

    private JScrollPane messagesScrollView;
    private JList<Message> messageListView;
    private Chat chat;

    public ChatPanelView(Dimension d) {
        super(d);
    }


    public ChatPanelView(Dimension container, Double widthPercent, Double heightPercent) {
        super(container, widthPercent, heightPercent);
    }

    @Override
    protected void createView(Dimension d) {
        setSize(d);
        messageListView = new JList<>();
        messageListView.setFocusable(false);
        messagesScrollView = new JScrollPane(messageListView);
        setLayout(new BorderLayout());
        add(messagesScrollView, BorderLayout.CENTER);
    }

    public void updateChatView() {
        ArrayList<Message> chatMessages = chat.getMessages();
        messageListView.getDragEnabled();
        messageListView.setListData(chatMessages.toArray(new Message[chatMessages.size()]));
    }
    public void setChat(Chat chat) {
        this.chat = chat;
        updateChatView();
    }

    public void addMessage(Message message) {
        chat.addMessage(message);
        updateChatView();
    }

    public Chat getChat() {
        return chat;
    }

    public void deleteMessage(Message message) {
        chat.deleteMessage(message);
        // controller.updateChat(chat);
    }

    public void clearChat() {
        chat.clearChat();
        // controller.updateChat(chat);
    }
}
