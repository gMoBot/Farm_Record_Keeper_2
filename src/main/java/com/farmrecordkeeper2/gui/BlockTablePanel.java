package main.java.com.farmrecordkeeper2.gui;

import main.java.com.farmrecordkeeper2.model.Application;
import main.java.com.farmrecordkeeper2.model.Block;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

/**
 * Created by garrettcoggon on 7/15/15.
 */
public class BlockTablePanel extends JPanel{

    private JTable table;
    private BlockTableModel blockTableModel;
    private JPopupMenu popupMenu;
    private BlockTableListener blockTableListener;

    public BlockTablePanel(){
        blockTableModel = new BlockTableModel();
        table = new JTable(blockTableModel);
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
                int id = (int) blockTableModel.getValueAt(row, 0);


                System.out.println(row + id + "Removing item");

                if (blockTableListener != null) {
                    blockTableListener.rowDeleted(id);
                    blockTableModel.fireTableRowsDeleted(row, row);
                }

            }
        });


        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);


    }

    public void setData(java.util.List<Block> db){
        blockTableModel.setData(db);
    }
    public void refresh(){
        blockTableModel.fireTableDataChanged();
    }
    public void setBlockTableListener(BlockTableListener blockTableListener){
        this.blockTableListener = blockTableListener;
    }
}
