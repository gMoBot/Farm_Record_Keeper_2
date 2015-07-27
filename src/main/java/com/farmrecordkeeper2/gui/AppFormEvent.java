package main.java.com.farmrecordkeeper2.gui;

import main.java.com.farmrecordkeeper2.model.ApplicatorProfile;
import main.java.com.farmrecordkeeper2.model.Block;
import main.java.com.farmrecordkeeper2.model.Product;

import java.util.EventObject;

/**
 * Created by garrettcoggon on 7/6/15.
 */
public class AppFormEvent extends EventObject {

    private String block;
    private Block selectedBlock;
    private int blockId;
    private String date;
    private String time;
    private String appl;
    private ApplicatorProfile applProfile;
    private String target;
    private String productName;
    private Product selectedProduct;
    private String rate;
    private String rateUnit;
    private String carrierVol;
    private String appMethod;
    private String rowsApplied;
    private String weatherCondition;
    private String temp;
    private String windSpeed;
    private String windDirection;
    private String notes;

    public AppFormEvent(Object source, Block selectedBlock, int blockId, String block, String date,
                        String time, String appl, ApplicatorProfile applProfile,
                        String target, String productName, Product selectedProduct, String rate,
                        String rateUnit, String carrierVol, String appMethod, String rowsApplied,
                        String weatherCondition, String temp, String windSpeed, String windDirection, String notes) {
        super(source);
        this.block = block;
        this.selectedBlock = selectedBlock;
        this.blockId = blockId;
        this.date = date;
        this.time = time;
        this.appl = appl;
        this.applProfile = applProfile;
        this.target = target;
        this.productName = productName;
        this.selectedProduct = selectedProduct;
        this.rate = rate;
        this.rateUnit = rateUnit;
        this.carrierVol = carrierVol;
        this.appMethod = appMethod;
        this.rowsApplied = rowsApplied;
        this.weatherCondition = weatherCondition;
        this.temp = temp;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.notes = notes;
    }

    public Block getSelectedBlock(){return selectedBlock;}


    public ApplicatorProfile getApplProfile() {
        return applProfile;
    }

    public Product getSelectedProduct(){return selectedProduct;}

    public void setApplProfile(ApplicatorProfile applProfile) {
        this.applProfile = applProfile;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public int getBlockId() {
        return blockId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAppl() {
        return appl;
    }

    public void setAppl(String appl) {
        this.appl = appl;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRateUnit() {
        return rateUnit;
    }

    public void setRateUnit(String rateUnit) {
        this.rateUnit = rateUnit;
    }

    public String getCarrierVol() {
        return carrierVol;
    }

    public void setCarrierVol(String carrierVol) {
        this.carrierVol = carrierVol;
    }

    public String getAppMethod() {
        return appMethod;
    }

    public void setAppMethod(String appMethod) {
        this.appMethod = appMethod;
    }

    public String getRowsApplied() {
        return rowsApplied;
    }

    public void setRowsApplied(String rowsApplied) {
        this.rowsApplied = rowsApplied;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
