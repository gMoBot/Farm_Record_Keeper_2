package main.java.com.farmrecordkeeper2.gui;

import java.util.EventObject;

/**
 * Created by garrettcoggon on 7/9/15.
 */
public class FarmFormEvent extends EventObject {

    private int farmId;
    private String farmName;
    private String ownerName;
    private String streetAddress;
    private String stateCode;
    private String city;
    private String zipcode;

    public FarmFormEvent(Object source, int farmId, String farmName, String ownerName, String
            streetAddress,
                         String stateCode, String city, String zipcode) {
        super(source);
        this.farmId = farmId;
        this.farmName = farmName;
        this.ownerName = ownerName;
        this.streetAddress = streetAddress;
        this.stateCode = stateCode;
        this.city = city;
        this.zipcode = zipcode;
    }

    public int getFarmId() {
        return farmId;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

}
