package main.java.com.farmrecordkeeper2.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by garrettcoggon on 7/2/15.
 */
public class ToolBar extends JPanel implements ActionListener {
    private JButton farmFormButton;
    private JButton refreshButton;
    private ToolBarListener toolBarListener;

    public ToolBar(){
        setBorder(BorderFactory.createEtchedBorder());

        farmFormButton = new JButton("New Farm");
        refreshButton = new JButton("Refresh");

        farmFormButton.addActionListener(this);
        refreshButton.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(farmFormButton);
        add(refreshButton);

    }

    public void setToolBarListener(ToolBarListener toolBarListener){
        this.toolBarListener = toolBarListener;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        JButton clicked = (JButton) e.getSource();

        if (clicked == farmFormButton){
            if (toolBarListener != null){
                toolBarListener.newFarmEventOccurred();
            }
        }

        else if (clicked == refreshButton){
            if(toolBarListener != null){
                toolBarListener.refreshEventOccurred();
            }
        }

    }

}
