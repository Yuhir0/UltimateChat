package com.ultimatechat.views;

import com.ultimatechat.views.basic_views.PanelView;

import javax.swing.*;
import java.awt.*;

public class UsersPanelView extends PanelView {

    public UsersPanelView(Dimension d) {
        super(d);
    }

    public UsersPanelView(Dimension container, int widthPercent, int heightPercent) {
        super(container, widthPercent, heightPercent);
    }

    @Override
    protected void createView(Dimension d) {
        setSize(d);
        setBackground(Color.RED);

        JScrollPane usersScroll = new JScrollPane();
        usersScroll.setEnabled(true);

        JLabel userOne = new JLabel("User One");
        usersScroll.add(userOne);

        add(usersScroll);
    }
}
