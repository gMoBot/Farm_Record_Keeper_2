package main.java.com.farmrecordkeeper2.gui;

import main.java.com.farmrecordkeeper2.model.Application;
import main.java.com.farmrecordkeeper2.model.Block;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by garrettcoggon on 7/15/15.
 */
public class BlockTableModel extends AbstractTableModel{
    private List<Block> db;
    private String[] colNames = {"Id", "Block Name", "Street Address", "State",
            "City", "ZipCode", "Size", "Crop"};

    public BlockTableModel(){}

    public void setData(List<Block> db){
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
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Block block = db.get(rowIndex);

        switch (columnIndex){
            case 0:
                return block.getBlockId();
            case 1:
                return block.getBlockName();
            case 2:
                return block.getStreetAddress();
            case 3:
                return block.getStateCode();
            case 4:
                return block.getCity();
            case 5:
                return block.getZipcode();
            case 6:
                return block.getSize();
            case 7:
                return block.getBlockCrop();
            default:
                return null;
        }
    }
}
