package main.java.com.farmrecordkeeper2.gui;

import java.util.EventObject;

/**
 * Created by garrettcoggon on 7/10/15.
 */
public class ProductFormEvent extends EventObject {

    private int farmId;
    private String productName;
    private String activeIngredient;
    private String epaNumber;
    private String reiHrs;
    private String phiDays;

    public ProductFormEvent(Object source, int farmId, String productName, String
            activeIngredient, String epaNumber, String reiHrs, String phiDays) {
        super(source);
        this.farmId = farmId;
        this.productName = productName;
        this.activeIngredient = activeIngredient;
        this.epaNumber = epaNumber;
        this.reiHrs = reiHrs;
        this.phiDays = phiDays;
    }

    public int getFarmId() {
        return farmId;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getActiveIngredient() {
        return activeIngredient;
    }

    public void setActiveIngredient(String activeIngredient) {
        this.activeIngredient = activeIngredient;
    }

    public String getEpaNumber() {
        return epaNumber;
    }

    public void setEpaNumber(String epaNumber) {
        this.epaNumber = epaNumber;
    }

    public String getReiHrs() {
        return reiHrs;
    }

    public void setReiHrs(String reiHrs) {
        this.reiHrs = reiHrs;
    }

    public String getPhiDays() {
        return phiDays;
    }

    public void setPhiDays(String phiDays) {
        this.phiDays = phiDays;
    }
}
