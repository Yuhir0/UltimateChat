package com.ultimatechat.views;

import com.ultimatechat.models.User;
import com.ultimatechat.views.basic_views.PanelView;

import javax.swing.*;
import javax.swing.border.Border;
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
        setBackground(Color.RED);

        usersListView = new JList<>();

        usersScrollView = new JScrollPane(usersListView);

        setLayout(new BorderLayout());
        add(usersScrollView, BorderLayout.CENTER);
    }

    public void setUsers (User[] users) {
        this.usersList = users;
        usersListView.setListData(usersList);
    }
}
