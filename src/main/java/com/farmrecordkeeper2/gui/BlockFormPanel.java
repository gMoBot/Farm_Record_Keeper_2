package main.java.com.farmrecordkeeper2.gui;

import main.java.com.farmrecordkeeper2.model.Farm;
import main.java.com.farmrecordkeeper2.model.StateCodes;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by garrettcoggon on 7/9/15.
 */

public class BlockFormPanel extends JPanel {

    private JLabel blockNameLabel;
    private JTextField blockNameField;
    private JCheckBox useFarmAddressCheckBox;
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
    private Farm farm;

    private JButton okButton;

    private BlockFormListener blockFormListener;

    public BlockFormPanel(Farm farm) {
        Dimension dimension = getPreferredSize();
        dimension.width = 350;
        setPreferredSize(dimension);

        this.farm = farm;

        blockNameLabel = new JLabel("Block Name: ");
        streetAddressLabel = new JLabel("Street Address: ");
        stateCodeLabel = new JLabel("State: ");
        cityLabel = new JLabel("City: ");
        zipCodeLabel = new JLabel("ZipCode: ");
        blockSizeLabel = new JLabel("Block Size (Acres): ");
        blockCropLabel = new JLabel("Block Crop: ");
        okButton = new JButton("OK");

        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(3);

        blockNameField = new JTextField(10);
        useFarmAddressCheckBox = new JCheckBox();
        streetAddressField = new JTextField(10);
        stateCodeComboBox = new JComboBox(StateCodes.values());
        cityField = new JTextField(10);
        zipcodeField = new JTextField(10);
        blocksizeField = new JFormattedTextField(numberFormat);
        blockCropField = new JTextField(10);

//        new DecimalFormat("#.00")
//        float startingAcres = 10.00f;
        double startingAcres = 10.00;
        blocksizeField.setValue(startingAcres);

//        double d = 10.00;
//        Number number = d;
//        number.floatValue();

        // Set Mnemonics
        okButton.setMnemonic(KeyEvent.VK_ENTER);

        // Set Address Fields
        useFarmAddressCheckBox.setSelected(true);

        streetAddressField.setText(farm.getStreetAddress());
        stateCodeComboBox.getModel().setSelectedItem(farm.getStateCode());
        cityField.setText(farm.getCity());
        zipcodeField.setText(farm.getZipcode());
        stateCodeComboBox.updateUI();

        streetAddressField.setEditable(false);
//        stateCodeComboBox.setse(false);
        cityField.setEditable(false);
        zipcodeField.setEditable(false);



        useFarmAddressCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isChecked = useFarmAddressCheckBox.isSelected();

                streetAddressField.setEditable(!isChecked);
//                stateCodeComboBox.setEditable(!isChecked);
                cityField.setEditable(!isChecked);
                zipcodeField.setEditable(!isChecked);

//                if (isChecked == false){
//
//                }

                if(isChecked == true)
                //TODO: set Farm Address Data
                streetAddressField.setText(farm.getStreetAddress());
                stateCodeComboBox.getModel().setSelectedItem(farm.getStateCode());
                cityField.setText(farm.getCity());
                zipcodeField.setText(farm.getZipcode());
                stateCodeComboBox.updateUI();

            }
        });



        // Set OK Button
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String blockName = blockNameField.getText();
                String streetAddress = streetAddressField.getText();
                String stateCode = String.valueOf(stateCodeComboBox.getSelectedItem());
                String city = cityField.getText();
                String zipCode = zipcodeField.getText();
                Number blockSizeNumber = ((Number) blocksizeField.getValue());
                float blockSizeFloat = blockSizeNumber.floatValue();
                String blockCrop = blockCropField.getText();



                //TODO: implement data handling for farmid
                int farmid = 0;


                System.out.println(blockName + streetAddress + blockCrop);



                BlockFormEvent ev = new BlockFormEvent(e, farmid, blockName, streetAddress,
                        stateCode, city, zipCode, blockSizeFloat, blockCrop);

                if (blockFormListener != null) {
                    System.out.println("raising block form event");
                    blockFormListener.blockFormEventOccurred(ev);
                }

            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Add Block");
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

        add(new JLabel("Use Farm Address: "), gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(useFarmAddressCheckBox, gc);

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
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = leftInsets;

        add(okButton, gc);


    }

    public void setBlockFormListener(BlockFormListener blockFormListener) {
        this.blockFormListener = blockFormListener;
    }

}

