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

    public void setChat(Chat chat) {
        this.chat = chat;
        ArrayList<Message> chatMessages = chat.getMessages();
        Message[] messages = new Message[chatMessages.size()];
        chatMessages.toArray(messages);
        messageListView.setListData(messages);
    }
}
