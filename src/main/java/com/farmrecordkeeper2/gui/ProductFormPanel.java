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
public class ProductFormPanel extends JPanel {

    private JLabel productNameLabel;
    private JTextField productNameField;
    private JLabel activeIngredientLabel;
    private JTextField activeIngredientField;
    private JLabel epaNumberLabel;
    private JTextField epaNumberField;
    private JLabel reiLabel;
    private JTextField reiField;
    private JLabel phiLabel;
    private JTextField phiField;

    private JButton okButton;

    private ProductFormListener productFormListener;

    public ProductFormPanel() {
        Dimension dimension = getPreferredSize();
        dimension.width = 350;
        setPreferredSize(dimension);

        productNameLabel = new JLabel("Product Name: ");
        activeIngredientLabel = new JLabel("Active Ingredient: ");
        epaNumberLabel = new JLabel("EPA Reg. Number: ");
        reiLabel = new JLabel("REI (hrs): ");
        phiLabel = new JLabel("PHI (days): ");

        okButton = new JButton("OK");

        productNameField = new JTextField(10);
        activeIngredientField = new JTextField(10);
        epaNumberField = new JTextField(10);
        reiField = new JTextField(10);
        phiField = new JTextField(10);


        // Set Mnemonics
        okButton.setMnemonic(KeyEvent.VK_ENTER);


        // Set OK Button
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (productNameField.getText().isEmpty() || activeIngredientField.getText()
                        .isEmpty() || epaNumberField.getText().isEmpty() || reiField.getText().isEmpty()
                        || phiField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(ProductFormPanel.this, "Please enter " +
                            "information " + "for all fields ('0' if REI/PHI is not applicable)",
                            "Error",
                            JOptionPane
                            .ERROR_MESSAGE);
                }
                else {
                    String productName = productNameField.getText();
                    String activeIngredient = activeIngredientField.getText();
                    String epaNumber = epaNumberField.getText();
                    String rei = reiField.getText();
                    String phi = phiField.getText();

                    int farmid = 0;

                    ProductFormEvent ev = new ProductFormEvent(e, farmid, productName,
                            activeIngredient, epaNumber, rei, phi);

                    if (productFormListener != null) {
                        productFormListener.productFormEventOccurred(ev);
                    }
                }
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Add Product Profile");
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

        add(productNameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(productNameField, gc);

        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(activeIngredientLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(activeIngredientField, gc);

        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(epaNumberLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(epaNumberField, gc);

        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(reiLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(reiField, gc);

        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(phiLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(phiField, gc);

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

    public void setProductFormListener(ProductFormListener productFormListener) {
        this.productFormListener = productFormListener;
    }
}
