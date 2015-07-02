package com.farmrecordkeeper2.gui;

import javax.swing.*;

/**
 * Created by garrettcoggon on 7/2/15.
 */
public class FarmRecordKeeper {
    public static void main(String[] args){

        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
    }
}
