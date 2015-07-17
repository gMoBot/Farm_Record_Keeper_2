package main.java.com.farmrecordkeeper2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by garrettcoggon on 7/6/15.
 */

@Entity
@Table(name = "application_profile")
public class Application implements Serializable {
    public Application(){}

    private static int count = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id", unique = true, nullable = false)
    private int id;
    @Column(name = "block_name")
    private String blockName;
    @Column(name = "app_block_id")
    private int blockId;
    @Column(name = "app_date")
    private String date;
    @Column(name = "app_time")
    private String time;
    @Column(name = "app_number")
    private String appl;
    @Column(name = "app_appl_id")
    private int applId;
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

//    private Block block;


    public Application(String blockName, int blockId, String date, String time, String appl, String
            target,
                       String product, String rate, String rateUnit, String
                               carrierVol, String appMethod, String weatherCondition, String temp, String windSpeed, String windDirection, String notes){
        this.blockName = blockName;
        this.blockId = blockId;
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

    public Application(int id, String block, int blockId, String date, String time, String appl,
                       String target,
                       String product, String rate, String rateUnit, String
                               carrierVol, String appMethod, String weatherCondition, String temp, String windSpeed, String windDirection, String notes){
        this(block, blockId, date, time, appl, target, product, rate, rateUnit, carrierVol,
                appMethod,
                weatherCondition, temp, windSpeed,
                windDirection, notes);
        this.id = id;
    }

    //TODO: Change to single instances, combine
    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "app_block_jtable",
//            joinColumns = {@JoinColumn(name = "app_id"), @JoinColumn(name =
//                    "appl_id")},
//            inverseJoinColumns = @JoinColumn(name = "block_id"))
    @JoinTable(name = "app_block_jtable", joinColumns = @JoinColumn(name = "app_id"),
            inverseJoinColumns = @JoinColumn(name = "block_id"))
    private Set<Block> blockSet;

//    @JoinTable(name = "app_block_jtable", joinColumns = @JoinColumn(name = "app_id"),
//            inverseJoinColumns = @JoinColumn(name = "appl_id"))
//    @JoinColumn(name = "app_id")
    @OneToMany(mappedBy = "appl_id")
    private Set<ApplicatorProfile> appProfileSet;



//    @OneToMany(cascade = CascadeType.ALL)
////    @JoinTable(name = "app_block_jtable",
////            joinColumns = {@JoinColumn(name = "app_id"), @JoinColumn(name =
////                    "block_id")},
////            inverseJoinColumns = @JoinColumn(name = "appl_id"))
//    @JoinTable(name = "app_block_jtable", joinColumns = @JoinColumn(name = "app_id"), inverseJoinColumns = @JoinColumn(name = "appl_id"))
////    @JoinColumn(name = "app_id")

    public void setBlockProfile(Set<Block> block) {
        //    private Block block;

        this.blockSet = block;
    }
    public Set<Block> getBlockProfile(){ return blockSet;}

    public Set<ApplicatorProfile> getAppProfileSet() {
        return appProfileSet;
    }

    public void setAppProfileSet(Set<ApplicatorProfile> appProfileSet) {
        this.appProfileSet = appProfileSet;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlock() {
        return blockName;
    }

    public void setBlock(String block) {
        this.blockName = blockName;
    }


    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
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


    public int getApplId() {
        return applId;
    }

    public void setApplId(int applId) {
        this.applId = applId;
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