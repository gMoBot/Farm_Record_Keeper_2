package main.java.com.farmrecordkeeper2.gui;

/**
 * Created by garrettcoggon on 7/7/15.
 */
public interface ToolBarListener {

    public void newApplicationEventOccurred();
    public void newFarmEventOccurred();
    public void newBlockEventOccurred();
    public void newApplicatorEventOccurred();
    public void newProductEventOccurred();
    public void refreshEventOccurred();

}
