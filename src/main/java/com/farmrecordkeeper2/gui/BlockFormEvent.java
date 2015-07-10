package main.java.com.farmrecordkeeper2.gui;

import java.util.EventObject;

/**
 * Created by garrettcoggon on 7/9/15.
 */
public class BlockFormEvent extends EventObject {

    private int blockId;
    private int farmId;
    private String blockName;
    private String streetAddress;
    private String stateCode;
    private String city;
    private String zipcode;
    private float size;
    private String blockCrop;


    public BlockFormEvent(Object source, int farmId, String blockName, String streetAddress, String
            stateCode, String city, String zipcode, float size, String blockCrop) {
        super(source);
        this.farmId = farmId;
        this.blockName = blockName;
        this.streetAddress = streetAddress;
        this.stateCode = stateCode;
        this.city = city;
        this.zipcode = zipcode;
        this.size = size;
        this.blockCrop = blockCrop;
    }

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    public int getFarmId() {
        return farmId;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
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

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getBlockCrop() {
        return blockCrop;
    }

    public void setBlockCrop(String blockCrop) {
        this.blockCrop = blockCrop;
    }
}
