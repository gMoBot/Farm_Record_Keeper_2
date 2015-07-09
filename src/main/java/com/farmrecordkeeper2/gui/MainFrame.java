package main.java.com.farmrecordkeeper2.gui;

import javafx.stage.FileChooser;
import main.java.com.farmrecordkeeper2.AppConfig;
import main.java.com.farmrecordkeeper2.controller.Controller;
import main.java.com.farmrecordkeeper2.dao.DatabaseDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    private FormPanel formPanel;
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
        formPanel = new FormPanel();
        prefsDialog = new PrefsDialog(this);


        jFileChooser = new JFileChooser();
        jFileChooser.addChoosableFileFilter(new ApplicationFileFilter());
        setJMenuBar(createMenuBar());


        formPanel.setApplFormListener(new ApplFormListener() {
            @Override
            public void applFormEventOccured(FormEvent e) {
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

        toolBar.setToolBarListener(new ToolBarListener() {
            @Override
            public void saveEventOccurred() {
                System.out.print("save");

                controller.save();
            }

            @Override
            public void refreshEventOccurred() {

                //TODO: refresh Table Data
                System.out.print("refresh");
                controller.getApplications();
            }
        });


        add(formPanel, BorderLayout.WEST);
        add(tablePanel, BorderLayout.CENTER);
        add(toolBar, BorderLayout.NORTH);

        // MainFrame Window Settings
        setMinimumSize(new Dimension(500, 450));
        setSize(550, 425);
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

        showMenu.add(showAppFormItem);
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
                formPanel.setVisible(menuItem.isSelected());
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
