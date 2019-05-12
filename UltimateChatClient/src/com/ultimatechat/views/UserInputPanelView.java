package com.ultimatechat.views;

import com.ultimatechat.views.basic_views.PanelView;

import javax.swing.*;
import java.awt.*;

public class UserInputPanelView extends PanelView {

    public UserInputPanelView(Dimension d) {
        super(d);
    }

    public UserInputPanelView(Dimension container, int widthPercent, int heightPercent) {
        super(container, widthPercent, heightPercent);
    }

    @Override
    protected void createView(Dimension d) {
        setBackground(Color.GREEN);

        setSize(d);

        JTextField texInput = new JTextField(40);
        add(texInput);

        JButton sendBtn = new JButton("Send");
        add(sendBtn);
    }
}
