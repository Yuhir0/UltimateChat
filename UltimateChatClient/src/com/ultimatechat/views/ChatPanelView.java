package com.ultimatechat.views;

import com.ultimatechat.models.Chat;
import com.ultimatechat.models.Message;
import com.ultimatechat.views.basic_views.PanelView;

import javax.swing.*;
import java.awt.*;

public class ChatPanelView extends PanelView {

    private JList<Message> messageListView;
    private Chat chat;

    public ChatPanelView(Dimension d) {
        super(d);
    }

    public ChatPanelView(Dimension container, int widthPercent, int heightPercent) {
        super(container, widthPercent, heightPercent);
    }

    @Override
    protected void createView(Dimension d) {
        setSize(d);
        setBackground(Color.BLUE);
        messageListView = new JList<>();
        messageListView.setBounds(0, 0, d.width, d.height);
    }
}
