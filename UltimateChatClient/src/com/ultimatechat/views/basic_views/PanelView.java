package com.ultimatechat.views.basic_views;

import javax.swing.*;
import java.awt.*;

public class PanelView extends JPanel {
    public PanelView(Dimension d) {
        createView(d);
    }

    public PanelView(Dimension container, int widthPercent, int heightPercent) {
        int width = container.width * widthPercent / 100;
        int height = container.height * heightPercent / 100;
        createView(new Dimension(width, height));
    }

    protected void createView(Dimension dimension) {
        setSize(dimension);
    }
}
