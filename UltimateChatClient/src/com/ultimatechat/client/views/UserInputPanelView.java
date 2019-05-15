package com.ultimatechat.client.views;

import com.ultimatechat.client.views.basic_views.PanelView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserInputPanelView extends PanelView {

    private JTextField texInput;
    private JButton sendBtn;

    /**
     * Constructor passes Dimension to Panel size
     * @param d Dimension
     */
    public UserInputPanelView(Dimension d) {
        super(d);
    }

    /**
     * Constructor to make Relative size to de container
     * @param container Dimensions from view contains this
     * @param widthPercent Double
     * @param heightPercent Double
     */
    public UserInputPanelView(Dimension container, Double widthPercent, Double heightPercent) {
        super(container, widthPercent, heightPercent);
    }

    /**
     * Returns textInput property
     * @return JTextField
     */
    public JTextField getTexInput() {
        return texInput;
    }

    /**
     * Returns sendBtn property
     * @return JButton
     */
    public JButton getSendBtn() {
        return sendBtn;
    }

    /**
     * Create view and all components based on dimension
     * @param d Dimension
     */
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
