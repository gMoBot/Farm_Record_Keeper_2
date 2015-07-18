package main.java.com.farmrecordkeeper2.gui;

import main.java.com.farmrecordkeeper2.model.ApplicatorProfile;
import main.java.com.farmrecordkeeper2.model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by garrettcoggon on 7/15/15.
 */
public class ProductTablePanel extends JPanel {

    private JTable table;
    private ProductTableModel productTableModel;
    private JPopupMenu popupMenu;
    private ProductTableListener productTableListener;

    public ProductTablePanel() {
        productTableModel = new ProductTableModel();
        table = new JTable(productTableModel);
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
                }
            }
        });

        removeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                int id = (int) productTableModel.getValueAt(row, 0);

                if (productTableListener != null) {
                    productTableListener.rowDeleted(id);
                    productTableModel.fireTableRowsDeleted(row, row);
                }
            }
        });

        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(java.util.List<Product> db){
        productTableModel.setData(db);
    }
    public void refresh(){
        productTableModel.fireTableDataChanged();
    }
    public void setProductTableListener(ProductTableListener productTableListener){
        this.productTableListener = productTableListener;
    }
}
