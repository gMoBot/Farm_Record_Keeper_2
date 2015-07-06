package com.farmrecordkeeper2.model;

import java.io.Serializable;

/**
 * Created by garrettcoggon on 7/6/15.
 */
public class Application implements Serializable{
    private static int count = 1;
    private int id;
    private String block;
    private String date;
    private String time;
    private String appl;
    private String target;
    private String product;
    private String rate;
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