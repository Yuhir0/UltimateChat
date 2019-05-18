package com.ultimatechat.client.views;

import com.ultimatechat.client.models.User;
import com.ultimatechat.client.views.basic_views.PanelView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

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

    public User[] getUsersList() {
        return usersList;
    }

    public JScrollPane getUsersScrollView() {
        return usersScrollView;
    }

    public JList<User> getUsersListView() {
        return usersListView;
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
