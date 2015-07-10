package main.java.com.farmrecordkeeper2.gui;

import java.util.EventObject;

/**
 * Created by garrettcoggon on 7/10/15.
 */
public class ApplProfileFormEvent extends EventObject {

    private int farmId;
    private String applName;
    private String licenseNumber;
    private String streetAddress;
    private String stateCode;
    private String city;
    private String zipcode;

    public ApplProfileFormEvent(Object source, int farmId, String applName, String licenseNumber, String streetAddress, String stateCode, String city, String zipcode) {
        super(source);
        this.farmId = farmId;
        this.applName = applName;
        this.licenseNumber = licenseNumber;
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

    public String getApplName() {
        return applName;
    }

    public void setApplName(String applName) {
        this.applName = applName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
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
