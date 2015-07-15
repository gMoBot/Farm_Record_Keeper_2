package main.java.com.farmrecordkeeper2.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by garrettcoggon on 7/2/15.
 */
public class ToolBar extends JPanel implements ActionListener {
    private JButton applicationButton;
    private JButton farmFormButton;
    private JButton blockFormButton;
    private JButton applicatorButton;
    private JButton productButton;
    private JButton refreshButton;
    private ToolBarListener toolBarListener;

    public ToolBar(){
        setBorder(BorderFactory.createEtchedBorder());

        applicationButton = new JButton("New Application");
        farmFormButton = new JButton("Edit Farm");
        blockFormButton = new JButton("New Block");
        applicatorButton = new JButton("New Applicator Profile");
        productButton = new JButton("New Product Profile");
        refreshButton = new JButton("Refresh");

        applicationButton.addActionListener(this);
        farmFormButton.addActionListener(this);
        blockFormButton.addActionListener(this);
        applicatorButton.addActionListener(this);
        productButton.addActionListener(this);
        refreshButton.addActionListener(this);


        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(applicationButton);
        add(blockFormButton);
        add(productButton);
        add(applicatorButton);
        add(farmFormButton);
        add(refreshButton);

    }

    public void setToolBarListener(ToolBarListener toolBarListener){
        this.toolBarListener = toolBarListener;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        JButton clicked = (JButton) e.getSource();

        if(clicked == applicationButton){
            if(toolBarListener != null){
                toolBarListener.newApplicationEventOccurred();
            }
        }

        if (clicked == farmFormButton){
            if (toolBarListener != null){
                toolBarListener.editFarmEventOccurred();
            }
        }

        if(clicked == applicatorButton){
            if(toolBarListener != null){
                toolBarListener.newApplicatorEventOccurred();
            }
        }

        if(clicked == productButton){
            if(toolBarListener != null){
                toolBarListener.newProductEventOccurred();
            }
        }

        if (clicked == refreshButton){
            if(toolBarListener != null){
                toolBarListener.refreshEventOccurred();
            }
        }
        else  if(clicked == blockFormButton){
            if(toolBarListener != null){
                toolBarListener.newBlockEventOccurred();
            }
        }

    }

}
