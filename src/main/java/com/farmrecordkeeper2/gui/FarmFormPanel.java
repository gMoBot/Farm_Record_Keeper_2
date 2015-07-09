package main.java.com.farmrecordkeeper2.gui;

import main.java.com.farmrecordkeeper2.model.StateCodes;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by garrettcoggon on 7/9/15.
 */
public class FarmFormPanel extends JPanel {

    private JLabel farmNameLabel;
    private JTextField farmNameField;
    private JLabel ownerNameLabel;
    private JTextField ownerNameField;
    private JLabel streetAddressLabel;
    private JTextField streetAddressField;
    private JLabel stateCodeLabel;
    private JComboBox stateCodeComboBox;
    private JLabel cityLabel;
    private JTextField cityField;
    private JLabel zipCodeLabel;
    private JTextField zipcodeField;

    private JButton okButton;

    private FarmFormListener farmFormListener;

    public FarmFormPanel(){
        Dimension dimension = getPreferredSize();
        dimension.width = 300;
        setPreferredSize(dimension);

        farmNameLabel = new JLabel("Farm Name: ");
        ownerNameLabel = new JLabel("Owner Name: ");
        streetAddressLabel = new JLabel("Street Address: ");
        stateCodeLabel = new JLabel("State: ");
        cityLabel = new JLabel("City: ");
        zipCodeLabel = new JLabel("ZipCode: ");
        okButton = new JButton("OK");

        farmNameField = new JTextField(10);
        ownerNameField = new JTextField(10);
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
                String farmName = farmNameField.getText();
                String ownerName = ownerNameField.getText();
                String streetAddress = streetAddressField.getText();
                String stateCode = String.valueOf(stateCodeComboBox.getSelectedItem());
                String city = cityField.getText();
                String zipCode = zipcodeField.getText();

                //TODO: implement data handling

                System.out.println(farmName + ownerName);

                FarmFormEvent ev = new FarmFormEvent(e, farmName, ownerName, streetAddress,
                        stateCode, city, zipCode);

                if(farmFormListener != null){
                    farmFormListener.farmFormEventOccured(ev);
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

        add(farmNameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(farmNameField, gc);


        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(ownerNameLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(ownerNameField, gc);

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
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(okButton, gc);


    }

    public void setFarmFormListener(FarmFormListener farmFormListener){
        this.farmFormListener = farmFormListener;
    }

}
