package main.java.com.farmrecordkeeper2.model;

import javax.persistence.*;


/**
 * Created by garrettcoggon on 7/9/15.
 */

@Entity
@Table(name = "farm_profile")
public class Farm {

    public Farm(){}

    @Id
    @Column(name = "farm_id", unique = true, nullable = false)
    private int farmId;
    @Column(name = "farm_name")
    private String farmName;
    @Column(name = "owner_name")
    private String ownerName;
    @Column(name = "street_address")
    private String streetAddress;
    @Column(name = "state_code")
    private String stateCode;
    @Column(name = "city")
    private String city;
    @Column(name = "zipcode")
    private String zipcode;


    public Farm(int farmId, String farmName, String ownerName, String streetAddress, String
            stateCode, String city, String zipcode) {
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
