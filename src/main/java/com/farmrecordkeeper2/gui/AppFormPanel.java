package main.java.com.farmrecordkeeper2.gui;

import main.java.com.farmrecordkeeper2.gui.AppFormEvent;
import main.java.com.farmrecordkeeper2.gui.ApplFormListener;
import main.java.com.farmrecordkeeper2.model.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * Created by garrettcoggon on 7/2/15.
 */
public class AppFormPanel extends JPanel {
    private JLabel blockLabel;
    private JComboBox<String> blockList;
    private JLabel dateLabel;
    private JSpinner dateSpinner;
    private JLabel timeLabel;
    private JSpinner timeSpinner;
    private JLabel appLabel;
    private JComboBox<String> appList;
    private JLabel targetLabel;
    private JTextField targetField;
    private JLabel productLabel;
    private JComboBox<String> productList;
    private JLabel rateLabel;
    private JTextField rateField;
    private JRadioButton ozRadioButton;
    private JRadioButton galRadioButton;
    private ButtonGroup rateUnitGroup;
    private JLabel appMethodLabel;
    private JLabel carrierLabel;
    private JTextField carrierField;
    private JComboBox appMethodJComboBox;
    private JRadioButton allRowsRadioButton;
    private JRadioButton alternateRowsRadioButton;
    private ButtonGroup rowSelectorButtonGroup;
    private JLabel weatherCondition;
    private JComboBox weatherCodesJComboBox;
    private JLabel tempLabel;
    private JTextField tempField;
    private JLabel windSpeedLabel;
    private JSpinner windSpeedSpinner;
    private JLabel windDirectionLabel;
    private JComboBox windDirectionJComboBox;
    private JLabel notesLabel;
    private JTextArea notesField;
    private JButton okButton;
    private ApplFormListener applFormListener;
    private int selectionCount;

    public AppFormPanel(List<Block> enteredBlocks, List<ApplicatorProfile> enteredApplicators,
                        List<Product>
            enteredProducts){
        Dimension dimension = getPreferredSize();
        dimension.width = 375;
        setPreferredSize(dimension);

        blockLabel = new JLabel("Block: ");
        dateLabel = new JLabel("Application Date: ");
        timeLabel = new JLabel("Application Time: ");
        appLabel = new JLabel("Applicator: ");
        targetLabel = new JLabel("Target Pest(s): ");
        productLabel = new JLabel("Product Name: ");
        rateLabel = new JLabel("Rate Applied/acre: ");
        carrierLabel = new JLabel("Carrier Vol/Acre (gal): ");
        appMethodLabel = new JLabel("Application Method: ");
        weatherCondition = new JLabel("Weather Condition: ");
        tempLabel = new JLabel("Temperature (°F): ");
        windSpeedLabel = new JLabel("Wind Speed (mph): ");
        windDirectionLabel = new JLabel("Wind Direction: ");
        notesLabel = new JLabel("Application Notes: ");
        okButton = new JButton("OK");
        selectionCount = 0;

        // Set Radio Buttons //
        ozRadioButton = new JRadioButton("oz.");
        ozRadioButton.setSelected(true);
        galRadioButton = new JRadioButton("gal.");

        ozRadioButton.setActionCommand("oz");
        galRadioButton.setActionCommand("gal");

        rateUnitGroup = new ButtonGroup();
        rateUnitGroup.add(ozRadioButton);
        rateUnitGroup.add(galRadioButton);

        allRowsRadioButton = new JRadioButton("All Rows");
        allRowsRadioButton.setSelected(true);
        alternateRowsRadioButton = new JRadioButton("Alternate Rows");

        allRowsRadioButton.setActionCommand("All");
        alternateRowsRadioButton.setActionCommand("Alternate");

        rowSelectorButtonGroup = new ButtonGroup();
        rowSelectorButtonGroup.add(allRowsRadioButton);
        rowSelectorButtonGroup.add(alternateRowsRadioButton);

        // Set ComboBox values //
        Vector productVector = new Vector();
        for(Product product : enteredProducts){
            productVector.add(product);
        }

        Vector blockVector = new Vector();
        for (Block block : enteredBlocks){
            blockVector.add(block);
        }

        Vector appVector = new Vector();
        for(ApplicatorProfile applicatorProfile: enteredApplicators){
            appVector.add(applicatorProfile);
        }


        // Set Spinner Models //
        SpinnerDateModel timeModel = new SpinnerDateModel();
        timeModel.setCalendarField(Calendar.MINUTE);

        SpinnerDateModel dateModel = new SpinnerDateModel();
        dateModel.setCalendarField(Calendar.DATE);

        SpinnerNumberModel windModel = new SpinnerNumberModel(3, 0, 35, 1);

        // Set other components //
        blockList = new JComboBox(new DefaultComboBoxModel<>(blockVector));
        blockList.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Block){
                    Block block = (Block) value;
                    setText(block.getBlockName());
                }
                return this;
            }
        });

        dateSpinner = new JSpinner();
        dateSpinner.setModel(dateModel);
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "MM/dd/yyyy"));
        dateSpinner.setValue(new Date());

        timeSpinner = new JSpinner();
        timeSpinner.setModel(timeModel);
        timeSpinner.setEditor(new JSpinner.DateEditor(timeSpinner, "h:mm a"));
        timeSpinner.setValue(new Date());

        appList = new JComboBox(new DefaultComboBoxModel<>(appVector));
        appList.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof ApplicatorProfile){
                    ApplicatorProfile applicatorProfile = (ApplicatorProfile) value;
                    setText(applicatorProfile.getApplName());
                }
                return this;
            }
        });

        targetField = new JTextField(10);

        productList = new JComboBox(new DefaultComboBoxModel<>(productVector));
        productList.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Product) {
                    Product product = (Product) value;
                    setText(product.getProductName());
                }
                return this;
            }
        });
        productList.setSelectedIndex(-1);
        rateField = new JTextField(10);
        carrierField = new JTextField(10);
        appMethodJComboBox = new JComboBox<>(AppMethod.values());
        weatherCodesJComboBox = new JComboBox<>(WeatherCodes.values());
        tempField = new JTextField(10);
        windSpeedSpinner = new JSpinner(windModel);
        windDirectionJComboBox = new JComboBox(WindDirection.values());
        notesField = new JTextArea(3, 10);

        // Set Mnemonics
        okButton.setMnemonic(KeyEvent.VK_ENTER);

        // Set OK Button
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (blockList.getSelectedIndex() == -1 || appList.getSelectedIndex() == -1 ||
                        productList.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(AppFormPanel.this, "Please Select a Block, " +
                            "Applicator & " +
                            "Product", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Block selectedBlock = (Block) blockList.getModel().getSelectedItem();
                    String block = selectedBlock.getBlockName();
                    int blockId = selectedBlock.getBlockId();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                    String date = dateFormat.format(dateSpinner.getValue());
                    SimpleDateFormat formatTime = new SimpleDateFormat("h:mm a");
                    String time = formatTime.format(timeSpinner.getValue());
                    ApplicatorProfile selectedAppProfile = (ApplicatorProfile) appList.getModel()
                            .getSelectedItem();
                    String appl = selectedAppProfile.getApplName();
                    String target = targetField.getText();
                    Product selectedProduct = (Product) productList.getModel().getSelectedItem();
                    String product = selectedProduct.getProductName();
                    String rate = rateField.getText();
                    String rateUnit = rateUnitGroup.getSelection().getActionCommand();
                    String carrierVol = carrierField.getText();
                    String appMethod = appMethodJComboBox.getSelectedItem().toString();
                    String rowsApplied = rowSelectorButtonGroup.getSelection().getActionCommand();
                    String weatherCondition = weatherCodesJComboBox.getSelectedItem().toString();
                    String temp = tempField.getText();
                    String windSpeed = windSpeedSpinner.getValue().toString();
                    String windDirection = windDirectionJComboBox.getSelectedItem().toString();
                    String notes = notesField.getText();

                    AppFormEvent ev = new AppFormEvent(e, selectedBlock, blockId, block, date, time,
                            appl, selectedAppProfile, target, product, selectedProduct,
                            rate, rateUnit, carrierVol, appMethod, rowsApplied, weatherCondition,
                            temp, windSpeed, windDirection, notes);


                    if (applFormListener != null) {
                        applFormListener.appFormEventOccurred(ev);
                    }
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

//        add(dateField, gc);
        add(dateSpinner, gc);

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

//        add(timeField, gc);
        add(timeSpinner, gc);

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

//        add(appField, gc);
        add(appList, gc);


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
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(ozRadioButton, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(galRadioButton, gc);

        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(carrierLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(carrierField, gc);

        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(appMethodLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(appMethodJComboBox, gc);

        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(allRowsRadioButton, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(alternateRowsRadioButton, gc);

        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(weatherCondition, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(weatherCodesJComboBox, gc);

        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(tempLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(tempField, gc);

        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(windSpeedLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(windSpeedSpinner, gc);

        // Next Row//
        gc.gridy++;

        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = leftInsets;

        add(windDirectionLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = rightInsets;

        add(windDirectionJComboBox, gc);

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
