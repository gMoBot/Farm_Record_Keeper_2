package main.java.com.farmrecordkeeper2.model;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;

/**
 * Created by garrettcoggon on 7/9/15.
 */

@Entity
@Table(name = "block_profile")
public class Block {
    public Block(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "block_id", unique = true, nullable = false)
    private int blockId;
//    @ManyToOne
    @Column(name = "farm_id")
    private int farmId;
    @Column(name = "block_name")
    private String blockName;
    @Column(name = "block_street_address")
    private String streetAddress;
    @Column(name = "block_state_code")
    private String stateCode;
    @Column(name = "city")
    private String city;
    @Column(name = "block_zipcode")
    private String zipcode;
    @Column(name = "block_size")
    private float size;
    @Column(name = "block_crop")
    private String blockCrop;


    public Block(int farmId, String blockName, String streetAddress, String stateCode, String city, String zipcode, float size, String blockCrop) {
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
