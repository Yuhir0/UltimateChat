package com.ultimatechat.client.views;

import com.ultimatechat.client.views.basic_views.PanelView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserInputPanelView extends PanelView {

    private JTextField texInput;
    private JButton sendBtn;

    public UserInputPanelView(Dimension d) {
        super(d);
    }

    public UserInputPanelView(Dimension container, Double widthPercent, Double heightPercent) {
        super(container, widthPercent, heightPercent);
    }

    public JTextField getTexInput() {
        return texInput;
    }

    public JButton getSendBtn() {
        return sendBtn;
    }

    @Override
    protected void createView(Dimension d) {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(100, 50));
        setMinimumSize(new Dimension(1080, 100));
        setSize(d);

        texInput = new JTextField(getSize().width / 15);
        add(texInput, BorderLayout.CENTER);

        sendBtn = new JButton("Send");
        add(sendBtn, BorderLayout.EAST);
    }
}
