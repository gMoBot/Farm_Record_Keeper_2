package main.java.com.farmrecordkeeper2.model;

import javax.persistence.*;

/**
 * Created by garrettcoggon on 7/10/15.
 */
@Entity
@Table(name = "product_profile")
public class Product {

    public Product(){}

    @Column(name = "farm_Id")
    private int farmId;
    @Id
    @Column(name = "product_name")
    private String productName;
    @Column (name = "active_ingredient")
    private String activeIngredient;
    @Column(name = "epa_number")
    private String epaNumber;
    @Column(name = "rei_hrs")
    private String reiHrs;
    @Column(name = "phi_days")
    private String phiDays;

    public Product(int farmId, String productName, String activeIngredient, String epaNumber,
                   String reiHrs, String
            phiDays) {
        this.farmId = farmId;
        this.productName = productName;
        this.activeIngredient = activeIngredient;
        this.epaNumber = epaNumber;
        this.reiHrs = reiHrs;
        this.phiDays = phiDays;
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

    public int getFarmId() {
        return farmId;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
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
