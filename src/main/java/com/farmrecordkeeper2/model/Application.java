package main.java.com.farmrecordkeeper2.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by garrettcoggon on 7/6/15.
 */

@Entity
@Table(name = "application_profile")
public class Application implements Serializable{
    public Application(){}

    private static int count = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id", unique = true, nullable = false)
    private int id;
    @Column(name = "block_name")
    private String block;
    @Column(name = "app_date")
    private String date;
    @Column(name = "app_time")
    private String time;
    @Column(name = "app_number")
    private String appl;
    @Column(name = "target_pest")
    private String target;
    @Column(name = "product_name")
    private String product;
    @Column(name = "app_rate")
    private String rate;
    @Column(name = "rate_unit")
    private String rateUnit;
    @Column(name = "carrier_vol")
    private String carrierVol;
    @Column (name = "app_method")
    private String appMethod;
    @Column (name = "weather_condition")
    private String weatherCondition;
    @Column (name = "temp")
    private String temp;
    @Column (name = "wind_speed")
    private String windSpeed;
    @Column (name = "wind_direction")
    private String windDirection;
    @Column(name = "app_notes")
    private String notes;

    public Application(String block, String date, String time, String appl, String target,
                       String product, String rate, String rateUnit, String
                               carrierVol, String appMethod, String weatherCondition, String temp, String windSpeed, String windDirection, String notes){
        this.block = block;
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

        this.id = count;
        count++;
    }

    public Application(int id, String block, String date, String time, String appl, String target,
                       String product, String rate, String rateUnit, String
                               carrierVol, String appMethod, String weatherCondition, String temp, String windSpeed, String windDirection, String notes){
        this(block, date, time, appl, target, product, rate, rateUnit, carrierVol, appMethod, weatherCondition, temp, windSpeed,
                windDirection, notes);
        this.id = id;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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