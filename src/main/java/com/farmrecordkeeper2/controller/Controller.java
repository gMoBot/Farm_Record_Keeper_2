package main.java.com.farmrecordkeeper2.controller;

import main.java.com.farmrecordkeeper2.gui.FarmFormEvent;
import main.java.com.farmrecordkeeper2.model.Application;
import main.java.com.farmrecordkeeper2.model.Farm;
import main.java.com.farmrecordkeeper2.model.StateCodes;
import main.java.com.farmrecordkeeper2.service.DatabaseService;
import main.java.com.farmrecordkeeper2.gui.AppFormEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by garrettcoggon on 7/2/15.
 */

@Component
public class Controller {

    @Autowired
    public DatabaseService db;

    public void setDatabaseService(DatabaseService db){
        System.out.print("setting databaseService");
        this.db = db;
    }


    public void addAppl(AppFormEvent e){
        String block = e.getBlock();
        String date = e.getDate();
        String time = e.getTime();
        String appl = e.getAppl();
        String target = e.getTarget();
        String product = e.getProduct();
        String rate = e.getRate();
        String notes = e.getNotes();

        System.out.println("Controller : " + block + date + time + appl + target + product +
                rate + notes);

        Application application = new Application (block, date, time, appl, target, product,
                rate, notes);
        save(application);
    }


    public List<Application> getApplications(){
        List<Application> appList = db.getApplications();
        if (appList.isEmpty()){
            System.out.print("No Applications Found");
        }
        else {
            //TODO: Load into table
            System.out.print("Applications Found");
        }
        return appList;


    }


    public void save(Application application) {
        db.save(application);
    }

    public void loadFromFile(File file) throws IOException{
        db.loadFromFile(file);
    }

    public void saveToFile(File file) throws IOException{
        db.saveToFile(file);
    }

    public void removeApplication(int row){
        db.removeApplicationAtIndex(row);
    }

    public void doSomething(){
        db.doSomething();
    }

    public List<Farm> getFarms(){
        List<Farm> farms = db.getFarms();
        return farms;
    }

    public void addFarm(FarmFormEvent e) {
        String farmName = e.getFarmName();
        String ownerName = e.getOwnerName();
        String streetAddress = e.getStreetAddress();
        String stateCode = e.getStateCode();
        String city = e.getCity();
        String zipCode = e.getZipcode();

        Farm farm = new Farm(farmName, ownerName, streetAddress, stateCode, city, zipCode);
        save(farm);
    }
    public void save(Farm farm){
        db.save(farm);
    }
}
