package main.java.com.farmrecordkeeper2.gui;

import main.java.com.farmrecordkeeper2.model.ApplicatorProfile;
import main.java.com.farmrecordkeeper2.model.Product;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by garrettcoggon on 7/15/15.
 */
public class ProductTableModel extends AbstractTableModel {

    private List<Product> db;
    private String[] colNames = {"Id", "Product Name", "Active Ingredient", "EPA Number", "REI hrs",
            "PHI days"};

    public ProductTableModel(){}

    public void setData(List<Product> db){
        this.db = db;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = db.get(rowIndex);

        switch (columnIndex){
            case 0:
                return product.getProdId();
            case 1:
                return product.getProductName();
            case 2:
                return product.getActiveIngredient();
            case 3:
                return product.getEpaNumber();
            case 4:
                return product.getReiHrs();
            case 5:
                return product.getPhiDays();
            default:
                return null;
        }
    }
}

