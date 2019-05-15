package com.ultimatechat.client.views;

import com.ultimatechat.client.views.basic_views.PanelView;

import javax.swing.*;
import java.awt.*;

public class UserInputPanelView extends PanelView {

    public UserInputPanelView(Dimension d) {
        super(d);
    }

    public UserInputPanelView(Dimension container, Double widthPercent, Double heightPercent) {
        super(container, widthPercent, heightPercent);
    }

    @Override
    protected void createView(Dimension d) {
        setLayout(new BorderLayout());
        setBackground(Color.GREEN);
        setMinimumSize(new Dimension(100, 50));
        setMinimumSize(new Dimension(1080, 100));
        setSize(d);
        JTextField texInput = new JTextField(getSize().width / 15);
        add(texInput, BorderLayout.CENTER);

        JButton sendBtn = new JButton("Send");
        add(sendBtn, BorderLayout.EAST);
    }
}
