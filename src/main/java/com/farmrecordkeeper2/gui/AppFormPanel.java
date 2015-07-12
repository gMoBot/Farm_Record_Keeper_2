package main.java.com.farmrecordkeeper2.gui;

import main.java.com.farmrecordkeeper2.model.Block;
import main.java.com.farmrecordkeeper2.model.Product;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

/**
 * Created by garrettcoggon on 7/2/15.
 */
public class AppFormPanel extends JPanel {
    private JLabel blockLabel;
//    private JTextField blockField;
    private JComboBox<String> blockList;
    private JLabel dateLabel;
    private JTextField dateField;
    private JLabel timeLabel;
    private JTextField timeField;
    private JLabel appLabel;
    private JTextField appField;
    private JLabel targetLabel;
    private JTextField targetField;
    private JLabel productLabel;
//    private JTextField productField;
    private JComboBox<String> productList;
    private JLabel rateLabel;
    private JTextField rateField;
    private JLabel notesLabel;
    private JTextArea notesField;
    private JButton okButton;
    private ApplFormListener applFormListener;

    public AppFormPanel(List<Block> enteredBlocks, List<Product> enteredProducts){
        Dimension dimension = getPreferredSize();
        dimension.width = 300;
        setPreferredSize(dimension);

        blockLabel = new JLabel("Block: ");
        dateLabel = new JLabel("Application Date: ");
        timeLabel = new JLabel("Application Time: ");
        appLabel = new JLabel("Applicator: ");
        targetLabel = new JLabel("Target Pest(s): ");
        productLabel = new JLabel("Product Name: ");
        rateLabel = new JLabel("Rate Applied: ");
        notesLabel = new JLabel("Application Notes: ");
        okButton = new JButton("OK");

        Vector productVector = new Vector();
        for(Product product : enteredProducts){
            productVector.add(product.getProductName());
        }

        Vector blockVector = new Vector();
        for (Block block : enteredBlocks){
            blockVector.add(block.getBlockName());
        }

        blockList = new JComboBox<String>(blockVector);
        dateField = new JTextField(10);
        timeField = new JTextField(10);
        appField = new JTextField(10);
        targetField = new JTextField(10);
//        productField = new JTextField(10);

        productList = new JComboBox<String>(productVector);
        productList.setSelectedIndex(-1);
        rateField = new JTextField(10);
        notesField = new JTextArea(3, 10);

        // Set Mnemonics
        okButton.setMnemonic(KeyEvent.VK_ENTER);


        // Set OK Button
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String block = blockField.getText();
                String block = blockList.getSelectedItem().toString();
                String date = dateField.getText();
                String time = timeField.getText();
                String appl = appField.getText();
                String target = targetField.getText();
//                String product = productField.getText();
                String product = productList.getSelectedItem().toString();
                String rate = rateField.getText();
                String notes = notesField.getText();

                //TODO: implement data handling

                System.out.println(block + target);

                AppFormEvent ev = new AppFormEvent(e, block, date, time, appl, target, product, rate,
                        notes);

                if(applFormListener != null){
                    applFormListener.appFormEventOccurred(ev);
                }
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Add Application");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setComponents();

    }

    public void setComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        Insets leftInsets = new Insets(0, 0, 0, 5);
        Insets rightInsets = new Insets(0, 0, 0, 0);


        // First Row//
        gc.gridx = 0;
        gc.gridy = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(blockLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

//        add(blockField, gc);
        add(blockList, gc);


        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(dateLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(dateField, gc);

        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(timeLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(timeField, gc);

        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(appLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(appField, gc);

        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(targetLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(targetField, gc);

        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(productLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

//        add(productField, gc);
        add(productList, gc);


        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(rateLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(rateField, gc);

        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = leftInsets;

        add(notesLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(notesField, gc);

        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 2;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(okButton, gc);


    }

    public void setApplFormListener(ApplFormListener applFormListener){
        this.applFormListener = applFormListener;
    }

}
