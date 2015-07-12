package main.java.com.farmrecordkeeper2.controller;

import main.java.com.farmrecordkeeper2.gui.*;
import main.java.com.farmrecordkeeper2.model.*;
import main.java.com.farmrecordkeeper2.service.DatabaseService;
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

    public void addBlock(BlockFormEvent e) {

        String blockName = e.getBlockName();
        String streetAddress = e.getStreetAddress();
        String stateCode = e.getStateCode();
        String city = e.getCity();
        String zipCode = e.getZipcode();
        Float blockSize = e.getSize();
        String blockCrop = e.getBlockCrop();

        //TODO: store/access farmid
        int farmid = 1;

        Block block = new Block(farmid, blockName, streetAddress, stateCode, city, zipCode,
                blockSize, blockCrop);
        save(block);
    }
    public void save(Block block){
        db.save(block);
    }

    public List<Block> getBlocks(){
        List<Block> blocks = db.getBlocks();
        return blocks;
    }

    public void addApplProfile(ApplProfileFormEvent e) {
        String applName = e.getApplName();
        String licenseNumber = e.getLicenseNumber();
        String streetAddress = e.getStreetAddress();
        String stateCode = e.getStateCode();
        String city = e.getCity();
        String zipCode = e.getZipcode();

        //TODO: store/access farmid
        int farmid = 1;

        ApplicatorProfile applicatorProfile = new ApplicatorProfile(farmid, applName,
                licenseNumber, streetAddress, stateCode, city, zipCode);
        save(applicatorProfile);
    }
    public void save(ApplicatorProfile applicatorProfile){
        db.save(applicatorProfile);
    }

    public List<Product> getProducts(){
        List<Product> products = db.getProducts();
        return products;
    }

    public void addProduct(ProductFormEvent e) {
        String productName = e.getProductName();
        String epaNumber = e.getEpaNumber();
        String rei = e.getReiHrs();
        String phi = e.getPhiDays();

        int farmid = 1;

        Product product = new Product(farmid, productName,epaNumber, rei, phi);
        save(product);

    }

    public void save(Product product){
        db.save(product);
    }


}
