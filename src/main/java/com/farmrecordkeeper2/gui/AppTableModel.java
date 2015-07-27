package main.java.com.farmrecordkeeper2.gui;

import main.java.com.farmrecordkeeper2.model.Application;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by garrettcoggon on 7/2/15.
 */
public class AppTableModel extends AbstractTableModel {

    private List<Application> db;
    private String[] colNames = {"Id", "Block Name", "Date", "Time",
            "Applicator", "Target Pest", "Product Name", "Rate", "Units", "Rows",
            "Notes"};

    public AppTableModel(){}

    public void setData(List<Application> db){
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
        return 11;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Application application = db.get(rowIndex);

        switch (columnIndex){
            case 0:
                return application.getId();
            case 1:
                return application.getBlockName();
            case 2:
                return application.getDate();
            case 3:
                return application.getTime();
            case 4:
                return application.getAppl();
            case 5:
                return application.getTarget();
            case 6:
                return application.getProductName();
            case 7:
                return application.getRate();
            case 8:
                return application.getRateUnit();
            case 9:
                return application.getRowsApplied();
            case 10:
                return application.getNotes();
            default:
                return null;
        }
    }

}
