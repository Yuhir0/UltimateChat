package com.ultimatechat.client.views;

import com.ultimatechat.client.models.User;
import com.ultimatechat.client.views.basic_views.PanelView;

import javax.swing.*;
import java.awt.*;

public class UsersPanelView extends PanelView {

    User[] usersList;
    private JScrollPane usersScrollView;
    private JList<User> usersListView;

    public UsersPanelView(Dimension d) {
        super(d);
    }

    public UsersPanelView(Dimension container, Double widthPercent, Double heightPercent) {
        super(container, widthPercent, heightPercent);
    }

    @Override
    protected void createView(Dimension d) {
        setSize(d);
        usersListView = new JList<>();
        usersListView.setFocusable(false);
        usersScrollView = new JScrollPane(usersListView);
        setLayout(new BorderLayout());
        add(usersScrollView, BorderLayout.CENTER);
    }

    public void setUsers (User[] users) {
        this.usersList = users;
        usersListView.setListData(usersList);
    }
}
