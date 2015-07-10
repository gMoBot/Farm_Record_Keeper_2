package main.java.com.farmrecordkeeper2.gui;

import main.java.com.farmrecordkeeper2.model.StateCodes;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

/**
 * Created by garrettcoggon on 7/9/15.
 */

public class BlockFormPanel extends JPanel {

    private JLabel blockNameLabel;
    private JTextField blockNameField;
    private JLabel streetAddressLabel;
    private JTextField streetAddressField;
    private JLabel stateCodeLabel;
    private JComboBox stateCodeComboBox;
    private JLabel cityLabel;
    private JTextField cityField;
    private JLabel zipCodeLabel;
    private JTextField zipcodeField;
    private JLabel blockSizeLabel;
    private JFormattedTextField blocksizeField;
    private JLabel blockCropLabel;
    private JTextField blockCropField;

    private JButton okButton;

    private BlockFormListener blockFormListener;

    public BlockFormPanel() {
        Dimension dimension = getPreferredSize();
        dimension.width = 300;
        setPreferredSize(dimension);

        blockNameLabel = new JLabel("Block Name: ");
        streetAddressLabel = new JLabel("Street Address: ");
        stateCodeLabel = new JLabel("State: ");
        cityLabel = new JLabel("City: ");
        zipCodeLabel = new JLabel("ZipCode: ");
        blockSizeLabel = new JLabel("Block Size (Acres): ");
        blockCropLabel = new JLabel("Block Crop: ");
        okButton = new JButton("OK");

        blockNameField = new JTextField(10);
        streetAddressField = new JTextField(10);
        stateCodeComboBox = new JComboBox(StateCodes.values());
        cityField = new JTextField(10);
        zipcodeField = new JTextField(10);
        blocksizeField = new JFormattedTextField(new DecimalFormat("#.00"));
        blockCropField = new JTextField(10);

        blocksizeField.setValue(new Float(10.00F));

        // Set Mnemonics
        okButton.setMnemonic(KeyEvent.VK_ENTER);


        // Set OK Button
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String blockName = blockNameField.getText();
                String streetAddress = streetAddressField.getText();
                String stateCode = String.valueOf(stateCodeComboBox.getSelectedItem());
                String city = cityField.getText();
                String zipCode = zipcodeField.getText();
                Float blockSize = (Float) blocksizeField.getValue();
                String blockCrop = blockCropField.getText();



                //TODO: implement data handling for farmid
                int farmid = 1;


                System.out.println(blockName + blockCrop);



                BlockFormEvent ev = new BlockFormEvent(e, farmid, blockName, streetAddress,
                        stateCode, city, zipCode, blockSize, blockCrop);

                if (blockFormListener != null) {
                    blockFormListener.blockFormEventOccurred(ev);
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

        add(blockNameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(blockNameField, gc);


        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(streetAddressLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(streetAddressField, gc);

        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(stateCodeLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(stateCodeComboBox, gc);

        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(cityLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(cityField, gc);

        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(zipCodeLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(zipcodeField, gc);

        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(blockSizeLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(blocksizeField, gc);

        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(blockCropLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(blockCropField, gc);

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

    public void setBlockFormListener(BlockFormListener blockFormListener) {
        this.blockFormListener = blockFormListener;
    }

}

