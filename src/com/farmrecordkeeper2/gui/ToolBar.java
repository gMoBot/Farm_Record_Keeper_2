package com.farmrecordkeeper2.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by garrettcoggon on 7/2/15.
 */
public class ToolBar extends JPanel implements ActionListener {
    private JButton saveButton;
    private JButton refreshButton;
    private ToolBarListener toolBarListener;

    public ToolBar(){
        setBorder(BorderFactory.createEtchedBorder());

        saveButton = new JButton("Save");
        refreshButton = new JButton("Refresh");

        saveButton.addActionListener(this);
        refreshButton.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(saveButton);
        add(refreshButton);

    }

    public void setToolBarListener(ToolBarListener toolBarListener){
        this.toolBarListener = toolBarListener;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        JButton clicked = (JButton) e.getSource();

        if (clicked == saveButton){
            if (toolBarListener != null){
                toolBarListener.saveEventOccurred();
            }
        }

        else if (clicked == refreshButton){
            if(toolBarListener != null){
                toolBarListener.refreshEventOccurred();
            }
        }

    }

}
