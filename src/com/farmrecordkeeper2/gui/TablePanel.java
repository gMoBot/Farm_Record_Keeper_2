package com.farmrecordkeeper2.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by garrettcoggon on 7/2/15.
 */
public class TablePanel extends JPanel {
    private JTable table;
    private AppTableModel appTableModel;
    private JPopupMenu popupMenu;


    public TablePanel(){
        appTableModel = new AppTableModel();
        table = new JTable(appTableModel);
        popupMenu = new JPopupMenu();

        JMenuItem removeItem = new JMenuItem("Delete Row");
        popupMenu.add(removeItem);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());

                table.getSelectionModel().setSelectionInterval(row, row);

                if (e.getButton() == MouseEvent.BUTTON3) {
                    popupMenu.show(table, e.getX(), e.getY());

                    System.out.println(row);

                }
            }
        });

        removeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();

                System.out.println(row);

                //TODO: implement remove item

            }
        });

        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);

    }


}
