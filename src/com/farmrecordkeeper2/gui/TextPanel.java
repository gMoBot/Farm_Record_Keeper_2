package com.farmrecordkeeper2.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by garrettcoggon on 7/2/15.
 */
public class TextPanel extends JPanel {
    private JTextArea textArea;

    public TextPanel(){
        textArea = new JTextArea();

        setLayout(new BorderLayout());

        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public void appendText(String text){
        textArea.append(text);
    }
}
