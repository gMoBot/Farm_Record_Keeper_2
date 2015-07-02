package com.farmrecordkeeper2.gui;

import com.farmrecordkeeper2.controller.Controller;

import javax.swing.*;
import java.awt.*;
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

        toolBar = new ToolBar();
        tablePanel = new TablePanel();
        formPanel = new FormPanel();


        add(formPanel, BorderLayout.WEST);
        add(tablePanel, BorderLayout.CENTER);
        add(toolBar, BorderLayout.NORTH);

        // MainFrame Window Settings
        setMinimumSize(new Dimension(500, 400));
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }




}
