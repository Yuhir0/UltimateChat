package com.ultimatechat.client.Controllers.basic_controllers;

import javax.swing.*;
import java.awt.*;

public class FrameController extends JFrame {

    private static final Dimension DIMESION_SIZE = new Dimension(500, 500);

    public FrameController(){
        createView(DIMESION_SIZE);
    }

    public FrameController(Dimension d) {
        createView(d);
    }

    protected void createView(Dimension d) {
        setSize(d);
    }
}
