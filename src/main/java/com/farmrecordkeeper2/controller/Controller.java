package main.java.com.farmrecordkeeper2.controller;

import main.java.com.farmrecordkeeper2.gui.*;
import main.java.com.farmrecordkeeper2.model.*;
import main.java.com.farmrecordkeeper2.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by garrettcoggon on 7/2/15.
 */

@Component
public class Controller {

    @Autowired
    public DatabaseService db;

    public void setDatabaseService(DatabaseService db){
        this.db = db;
    }


    public void addAppl(AppFormEvent e){
        String block = e.getBlock();
        Block selectedBlock = e.getSelectedBlock();
        String date = e.getDate();
        String time = e.getTime();
        String appl = e.getAppl();
        ApplicatorProfile selectedAppProfile = e.getApplProfile();
        String target = e.getTarget();
        String productName = e.getProductName();
        Product selectedProduct = e.getSelectedProduct();
        String rate = e.getRate();
        String rateUnit = e.getRateUnit();
        String carrierVol = e.getCarrierVol();
        String appMethod = e.getAppMethod();
        String weatherCondition = e.getWeatherCondition();
        String temp = e.getTemp();
        String windSpeed = e.getWindSpeed();
        String windDirection = e.getWindDirection();
        String notes = e.getNotes();

        Application application = new Application (block, date, time, appl, target,
                productName,
                rate, rateUnit, carrierVol, appMethod, weatherCondition, temp, windSpeed,
                windDirection, notes);

        application.setBlock(selectedBlock);
        application.setApplicatorProfile(selectedAppProfile);
        application.setProduct(selectedProduct);

        save(application);
    }


    public List<Application> getApplications(){
        List<Application> appList = db.getApplications();
        if (appList.isEmpty()){
            System.out.print("No Applications Found");
        }
        else {
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

    public void saveMIDataToFile(File file) throws IOException{
        db.saveMIRecordsToFile(file);
    }
    public void saveProcessorDataToFile(File file) throws IOException{
        db.saveProcessorRecordsToFile(file);
    }
    public void saveFederalDataToFile(File file) throws IOException{
        db.saveFedRecordsToFile(file);
    }

    public void removeApplication(int row){
        db.removeApplicationAtIndex(row);
    }

    public List<Farm> getFarm(){
        List<Farm> returnedfarm = db.getFarm();
        return returnedfarm;
    }

    public void editFarm(FarmFormEvent e) {
        int farmId = e.getFarmId();
        String farmName = e.getFarmName();
        String ownerName = e.getOwnerName();
        String streetAddress = e.getStreetAddress();
        String stateCode = e.getStateCode();
        String city = e.getCity();
        String zipCode = e.getZipcode();

        Farm farm = new Farm(farmId, farmName, ownerName, streetAddress, stateCode, city, zipCode);
        edit(farm);
    }
    public void edit(Farm farm){
        db.edit(farm);
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

    public void removeBlock(int row) {
        db.removeBlockAtIndex(row);
    }

    public void addApplProfile(ApplProfileFormEvent e) {
        String applName = e.getApplName();
        String licenseNumber = e.getLicenseNumber();
        String streetAddress = e.getStreetAddress();
        String stateCode = e.getStateCode();
        String city = e.getCity();
        String zipCode = e.getZipcode();

        // Farmid could be expanded if app is used for multiple farms //
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
        String activeIngredient = e.getActiveIngredient();
        String epaNumber = e.getEpaNumber();
        String rei = e.getReiHrs();
        String phi = e.getPhiDays();

        int farmid = 1;

        Product product = new Product(farmid, productName, activeIngredient, epaNumber, rei, phi);
        save(product);
    }

    public void save(Product product){
        db.save(product);
    }

    public void removeProduct(int row){
        db.removeSelectedProduct(row);
    }

    public List<ApplicatorProfile> getApplicatorProfiles() {
        List<ApplicatorProfile> applicators = db.getApplicatorProfiles();
        return applicators;
    }

    public void removeApplicator(int row) {
        db.removeApplicatorAtIndex(row);
    }

}
