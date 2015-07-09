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
    @Column(name = "app_notes")
    private String notes;


    public Application(String block, String date, String time, String appl, String target,
                       String product, String rate, String notes){
        this.block = block;
        this.date = date;
        this.time = time;
        this.appl = appl;
        this.target = target;
        this.product = product;
        this.rate = rate;
        this.notes = notes;

        this.id = count;
        count++;
    }

    public Application(int id, String block, String date, String time, String appl, String target,
                       String product, String rate, String notes){
        this(block, date, time, appl, target, product, rate, notes);
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}