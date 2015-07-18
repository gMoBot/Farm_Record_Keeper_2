package main.java.com.farmrecordkeeper2.gui;

import main.java.com.farmrecordkeeper2.model.ApplicatorProfile;
import main.java.com.farmrecordkeeper2.model.Block;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by garrettcoggon on 7/15/15.
 */
public class ApplicatorTableModel extends AbstractTableModel {

private List<ApplicatorProfile> db;
private String[] colNames = {"Id", "License Number", "Name", "Street Address", "State",
        "City", "ZipCode"};

    public ApplicatorTableModel(){}

    public void setData(List<ApplicatorProfile> db){
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
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ApplicatorProfile applicatorProfile = db.get(rowIndex);

        switch (columnIndex){
            case 0:
                return applicatorProfile.getApplId();
            case 1:
                return applicatorProfile.getLicenseNumber();
            case 2:
                return applicatorProfile.getApplName();
            case 3:
                return applicatorProfile.getStreetAddress();
            case 4:
                return applicatorProfile.getStateCode();
            case 5:
                return applicatorProfile.getCity();
            case 6:
                return applicatorProfile.getZipcode();
            default:
                return null;
        }
    }
}
