package main.java.com.farmrecordkeeper2.gui;

import main.java.com.farmrecordkeeper2.model.Block;

import java.util.EventObject;

/**
 * Created by garrettcoggon on 7/6/15.
 */
public class AppFormEvent extends EventObject {

    private String block;
    private Block selectedBlock;
    private String date;
    private String time;
    private String appl;
    private String target;
    private String product;
    private String rate;
    private String rateUnit;
    private String carrierVol;
    private String appMethod;
    private String weatherCondition;
    private String temp;
    private String windSpeed;
    private String windDirection;
    private String notes;

    public AppFormEvent(Object source, Block selectedBlock, String block, String date, String time,
                        String
            appl,
                        String target, String product, String rate, String rateUnit, String carrierVol, String appMethod, String weatherCondition, String temp, String windSpeed, String windDirection, String notes) {
        super(source);
        this.block = block;
        this.selectedBlock = selectedBlock;
        this.date = date;
        this.time = time;
        this.appl = appl;
        this.target = target;
        this.product = product;
        this.rate = rate;
        this.rateUnit = rateUnit;
        this.carrierVol = carrierVol;
        this.appMethod = appMethod;
        this.weatherCondition = weatherCondition;
        this.temp = temp;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.notes = notes;
    }

    public Block getSelectedBlock(){return selectedBlock;}

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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
