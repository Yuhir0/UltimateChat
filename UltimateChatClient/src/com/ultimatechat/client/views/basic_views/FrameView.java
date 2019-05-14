package com.ultimatechat.views.basic_views;

import javax.swing.*;
import java.awt.*;

public class FrameView extends JFrame {

    private static final Dimension DIMESION_SIZE = new Dimension(500, 500);

    public FrameView(){
        createView(DIMESION_SIZE);
    }

    public FrameView(Dimension d) {
        createView(d);
    }

    protected void createView(Dimension d) {
        setSize(d);
    }
}
