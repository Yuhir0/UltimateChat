package com.ultimatechat.views.basic_views;

import javax.swing.*;
import java.awt.*;

public class FrameView extends JFrame {
    public FrameView(){
        createView(new Dimension(500, 500));
    }

    public FrameView(Dimension d) {
        createView(d);
    }

    protected void createView(Dimension d) {
        setSize(d);
    }
}
