package com.farmrecordkeeper2.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by garrettcoggon on 7/2/15.
 */
public class ToolBar extends JPanel {
    private JButton saveButton;
    private JButton refreshButton;

    public ToolBar(){
        setBorder(BorderFactory.createEtchedBorder());

        saveButton = new JButton("Save");
        refreshButton = new JButton("Refresh");

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(saveButton);
        add(refreshButton);

    }

}
