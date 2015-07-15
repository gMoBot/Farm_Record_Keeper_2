package main.java.com.farmrecordkeeper2.gui;

import main.java.com.farmrecordkeeper2.model.ApplicatorProfile;
import main.java.com.farmrecordkeeper2.model.Block;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by garrettcoggon on 7/15/15.
 */
public class ApplicatorTablePanel extends JPanel{
    private JTable table;
    private ApplicatorTableModel applicatorTableModel;
    private JPopupMenu popupMenu;
    private ApplicatorTableListener applicatorTableListener;

    public ApplicatorTablePanel() {
        applicatorTableModel = new ApplicatorTableModel();
        table = new JTable(applicatorTableModel);
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
                int id = (int) applicatorTableModel.getValueAt(row, 0);


                System.out.println(row + id + "Removing item");

                if (applicatorTableListener != null) {
                    applicatorTableListener.rowDeleted(id);
                    applicatorTableModel.fireTableRowsDeleted(row, row);
                }

            }
        });

        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);


    }

    public void setData(java.util.List<ApplicatorProfile> db){
        applicatorTableModel.setData(db);
    }
    public void refresh(){
        applicatorTableModel.fireTableDataChanged();
    }
    public void setApplicatorTableListener(ApplicatorTableListener applicatorTableListener){
        this.applicatorTableListener = applicatorTableListener;
    }
}

