package main.java.com.farmrecordkeeper2.gui;

import main.java.com.farmrecordkeeper2.model.StateCodes;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by garrettcoggon on 7/10/15.
 */
public class ApplProfileFormPanel extends JPanel {

    private JLabel applNameLabel;
    private JTextField applNameField;
    private JLabel licenseNumberLabel;
    private JTextField licenseNumberField;
    private JLabel streetAddressLabel;
    private JTextField streetAddressField;
    private JLabel stateCodeLabel;
    private JComboBox stateCodeComboBox;
    private JLabel cityLabel;
    private JTextField cityField;
    private JLabel zipCodeLabel;
    private JTextField zipcodeField;


    private JButton okButton;

    private ApplProfileFormListener applProfileFormListener;

    public ApplProfileFormPanel() {
        Dimension dimension = getPreferredSize();
        dimension.width = 350;
        setPreferredSize(dimension);

        applNameLabel = new JLabel("Applicator Name: ");
        licenseNumberLabel = new JLabel("License Number: ");
        streetAddressLabel = new JLabel("Street Address: ");
        stateCodeLabel = new JLabel("State: ");
        cityLabel = new JLabel("City: ");
        zipCodeLabel = new JLabel("ZipCode: ");
        okButton = new JButton("OK");

        applNameField = new JTextField(10);
        licenseNumberField = new JTextField(10);
        streetAddressField = new JTextField(10);
        stateCodeComboBox = new JComboBox(StateCodes.values());
        cityField = new JTextField(10);
        zipcodeField = new JTextField(10);


        // Set Mnemonics
        okButton.setMnemonic(KeyEvent.VK_ENTER);


        // Set OK Button
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String applName = applNameField.getText();
                String licenseNumber = licenseNumberField.getText();
                String streetAddress = streetAddressField.getText();
                String stateCode = String.valueOf(stateCodeComboBox.getSelectedItem());
                String city = cityField.getText();
                String zipCode = zipcodeField.getText();

                int farmid = 0;

                ApplProfileFormEvent ev = new ApplProfileFormEvent(e, farmid, applName,
                        licenseNumber,
                        streetAddress,
                        stateCode, city, zipCode);

                if (applProfileFormListener != null) {
                    applProfileFormListener.applProfileFormEventOccurred(ev);
                }

            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Add Applicator Profile");
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

        add(applNameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(applNameField, gc);


        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(licenseNumberLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(licenseNumberField, gc);

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
        gc.weighty = 2;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = leftInsets;

        add(okButton, gc);
    }

    public void setApplProfileFormListener(ApplProfileFormListener applProfileFormListener) {
        this.applProfileFormListener = applProfileFormListener;
    }
}

