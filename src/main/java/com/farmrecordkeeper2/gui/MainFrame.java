package main.java.com.farmrecordkeeper2.gui;

import main.java.com.farmrecordkeeper2.AppConfig;
import main.java.com.farmrecordkeeper2.controller.Controller;
import main.java.com.farmrecordkeeper2.model.StateCodes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.prefs.Preferences;

/**
 * Created by garrettcoggon on 7/2/15.
 */
public class MainFrame extends JFrame{
//    private TextPanel textPanel;
    private ToolBar toolBar;
    private AppFormPanel appFormPanel;
    private FarmFormPanel farmFormPanel;
    private JFileChooser jFileChooser;
    private Controller controller;
    private TablePanel tablePanel;
    private PrefsDialog prefsDialog;
    private Preferences preferences;



    //TODO: intercept window closing to disconnect from db-maybe different with hiberate-check

    public MainFrame(){
        super("Farm Records App");

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        controller = context.getBean("controller", Controller.class);
        controller.doSomething();


        toolBar = new ToolBar();
        tablePanel = new TablePanel();
        appFormPanel = new AppFormPanel();
        prefsDialog = new PrefsDialog(this);
        farmFormPanel = new FarmFormPanel();

        farmFormPanel.setVisible(false);

        preferences = Preferences.userRoot().node("db");


        tablePanel.setData(controller.getApplications());

        tablePanel.setApplicationTableListener(new ApplicationTableListener() {
            @Override
            public void rowDeleted(int row) {
                System.out.println(row);
                controller.removeApplication(row);
            }
        });

        jFileChooser = new JFileChooser();
        jFileChooser.addChoosableFileFilter(new ApplicationFileFilter());
        setJMenuBar(createMenuBar());


        prefsDialog.setPrefsListener(new PrefsListener() {
            @Override
            public void preferencesSet(String user, String password, int port) {
                System.out.println(user + ";" + password + ";" + port);

                preferences.put("user", user);
                preferences.put("password", password);
                preferences.putInt("port", port);
            }
        });

        String user = preferences.get("user", "");
        String password = preferences.get("password", "");
        int port = preferences.getInt("port", 7532);
        prefsDialog.setDefaults(user, password, port);

        appFormPanel.setApplFormListener(new ApplFormListener() {
            @Override
            public void applFormEventOccured(AppFormEvent e) {
                String block = e.getBlock();
                String date = e.getDate();
                String time = e.getTime();
                String appl = e.getAppl();
                String target = e.getTarget();
                String product = e.getProduct();
                String rate = e.getRate();
                String notes = e.getNotes();

                System.out.println("Main frame: " + block + date + time + appl + target + product +
                        rate + notes + "\n");

                controller.addAppl(e);
            }
        });


        farmFormPanel.setFarmFormListener(new FarmFormListener() {
            @Override
            public void farmFormEventOccured(FarmFormEvent e) {
                String farmName = e.getFarmName();
                String ownerName = e.getOwnerName();
                String streetAddress = e.getStreetAddress();
                String stateCode = e.getStateCode();
                String city = e.getCity();
                String zipCode = e.getZipcode();

                System.out.println("Main Frame :" + farmName + ownerName);

                controller.addFarm(e);
            }
        });

        toolBar.setToolBarListener(new ToolBarListener() {
            @Override
            public void newFarmEventOccurred() {
                System.out.print("New Farm...");
                //TODO: is this necessary/Change to different function
//                controller.save();
                remove(appFormPanel);
                add(farmFormPanel, BorderLayout.WEST);
                farmFormPanel.setVisible(true);
                appFormPanel.setVisible(false);
            }

            @Override
            public void refreshEventOccurred() {

                //TODO: refresh Table Data
                System.out.print("refresh");
                controller.getApplications();
            }
        });


        add(appFormPanel, BorderLayout.WEST);
        add(tablePanel, BorderLayout.CENTER);
        add(toolBar, BorderLayout.NORTH);

        // MainFrame Window Settings
        setMinimumSize(new Dimension(500, 450));
        setSize(850, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu windowMenu = new JMenu("Window");

        JMenuItem exportDataItem = new JMenuItem("Export Data...");
        JMenuItem importDataItem = new JMenuItem("Import Data...");
        JMenuItem exitItem = new JMenuItem("Exit");

        JMenu showMenu = new JMenu("Show");

        JMenuItem prefsItem = new JMenuItem("Preferences...");

        JCheckBoxMenuItem showAppFormItem = new JCheckBoxMenuItem("Application Form");
        showAppFormItem.setSelected(true);

        JCheckBoxMenuItem showFarmFormItem = new JCheckBoxMenuItem("Farm Form");
        showFarmFormItem.setSelected(false);

        showMenu.add(showAppFormItem);
        showMenu.add(showFarmFormItem);
        windowMenu.add(showMenu);
        windowMenu.add(prefsItem);

        fileMenu.add(exportDataItem);
        fileMenu.add(importDataItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        menuBar.add(windowMenu);

        prefsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prefsDialog.setVisible(true);
            }
        });

        showAppFormItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
                appFormPanel.setVisible(menuItem.isSelected());
            }
        });

        showFarmFormItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
                appFormPanel.setVisible(menuItem.isSelected());
            }
        });


        // for mac ctrl+option/alt+indicated key //
        fileMenu.setMnemonic(KeyEvent.VK_F);
        exitItem.setMnemonic(KeyEvent.VK_Q);


        prefsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.META_MASK));

        importDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));

        importDataItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jFileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.loadFromFile(jFileChooser.getSelectedFile());
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Could not load data from " +
                                "file", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        exportDataItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jFileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
                    try {
                        controller.saveToFile(jFileChooser.getSelectedFile());
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Could not save data to " +
                                "file", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int action = JOptionPane.showConfirmDialog(MainFrame.this, "Are you sure you want" +
                        " to exit the application?", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
                if(action == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });

        return menuBar;

    }


}
