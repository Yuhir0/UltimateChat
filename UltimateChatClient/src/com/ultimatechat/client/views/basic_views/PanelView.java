package com.ultimatechat.views.basic_views;

import javax.swing.*;
import java.awt.*;

public class PanelView extends JPanel {
    public PanelView(Dimension d) {
        createView(d);
    }

    public PanelView(Dimension container, Double widthPercent, Double heightPercent) {
            Dimension newSize = new Dimension();
            newSize.setSize(
                    ((container.width * widthPercent) / 100),
                    ((container.height * heightPercent) / 100)
            );

            setPreferredSize(newSize);
            createView(newSize);
    }

    protected void createView(Dimension dimension) {
        setSize(dimension);
    }
}
