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
    private JButton showApplButton;
    private JButton showBlocksButton;
    private JButton showAppProfileButton;
    private JButton showProductsButton;
    private ToolBarListener toolBarListener;

    public ToolBar(){
        Dimension dimension = getPreferredSize();
        dimension.height = 70;
        setPreferredSize(dimension);

        setBorder(BorderFactory.createEtchedBorder());

        applicationButton = new JButton("New Application");
        farmFormButton = new JButton("Edit Farm");
        blockFormButton = new JButton("New Block");
        applicatorButton = new JButton("New Applicator");
        productButton = new JButton("New Product");
        showApplButton = new JButton("Show Applications");
        showBlocksButton = new JButton("Show Blocks");
        showAppProfileButton = new JButton("Show Applicators");
        showProductsButton = new JButton("Show Products");

        applicationButton.addActionListener(this);
        farmFormButton.addActionListener(this);
        blockFormButton.addActionListener(this);
        applicatorButton.addActionListener(this);
        productButton.addActionListener(this);
        showApplButton.addActionListener(this);
        showBlocksButton.addActionListener(this);
        showAppProfileButton.addActionListener(this);
        showProductsButton.addActionListener(this);


        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(applicationButton);
        add(blockFormButton);
        add(productButton);
        add(applicatorButton);
        add(farmFormButton);
        add(showApplButton);
        add(showBlocksButton);
        add(showAppProfileButton);
        add(showProductsButton);
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

        if (clicked == showApplButton){
            if(toolBarListener != null){
                toolBarListener.showAppsEventOccurred();
            }
        }
        if (clicked  == showBlocksButton){
            if(toolBarListener != null){
                toolBarListener.showBlocksEventOccurred();
            }
        }
        if (clicked == showAppProfileButton){
            if(toolBarListener != null){
                toolBarListener.showAppProfileEventOccurred();
            }
        }
        if(clicked == showProductsButton){
            if(toolBarListener != null){
                toolBarListener.showProductsEventOccurred();
            }
        }
        else  if(clicked == blockFormButton){
            if(toolBarListener != null){
                toolBarListener.newBlockEventOccurred();
            }
        }
    }
}
