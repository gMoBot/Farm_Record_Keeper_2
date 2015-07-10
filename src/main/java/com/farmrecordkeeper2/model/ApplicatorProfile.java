package main.java.com.farmrecordkeeper2.model;

import javax.persistence.*;

/**
 * Created by garrettcoggon on 7/10/15.
 */

@Entity
@Table(name = "applicator_profile")
public class ApplicatorProfile {

    @Column(name = "farm_id")
    private int farmId;
    @Column(name = "app_name")
    private String applName;
    @Id
    @Column(name = "app_number")
    private String licenseNumber;
    @Column(name = "street_address")
    private String streetAddress;
    @Column(name = "state_code")
    private String stateCode;
    @Column(name = "city")
    private String city;
    @Column(name = "zipcode")
    private String zipcode;

    public ApplicatorProfile(int farmId, String applName, String licenseNumber, String streetAddress, String stateCode, String city, String zipcode) {
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
