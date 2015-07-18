package main.java.com.farmrecordkeeper2.service;

import main.java.com.farmrecordkeeper2.dao.DatabaseDAO;
import main.java.com.farmrecordkeeper2.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by garrettcoggon on 7/7/15.
 */
@Service
public class DatabaseService {

    public DatabaseService(){}

    @Autowired
    private DatabaseDAO databaseDAO;

    @Autowired
    public DatabaseService(DatabaseDAO databaseDAO){
        System.out.print("constructing databaseDAO");
        this.databaseDAO = databaseDAO;
    }

    public void setDatabaseDAO(DatabaseDAO databaseDAO){
        this.databaseDAO = databaseDAO;
    }

    private List<Application> applicationList;

//    private
    public void DatabaseService(){
        applicationList = new LinkedList<Application>();
    }

    public void addApplication(Application application){
        applicationList.add(application);
    }

    public List<Application> getApplicationList(){
        return Collections.unmodifiableList(applicationList);
    }
    public void saveAllRecordsToFile(File file) throws IOException{
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        //TODO: Load app list, iterate through to add data to array of correct type //

        List<Application> allApps = databaseDAO.getApplications();
//        String fedHeaders = ("Product Name, EPA Number, Amount/Acre, Date, Block, Crop, Block " +
//                "Size, Applicator, Applicator Number, Active Ingredients, REI\n");


        Application[] applicationsArray = allApps.toArray(new Application[allApps.size()]);

//        oos.writeBytes(fedHeaders);

//        for(Application application : applicationsArray){
//            oos.writeBytes(application.getProductName());
//            oos.writeBytes(",");
//            oos.writeBytes(application.getProduct().getEpaNumber());
//            oos.writeBytes(",");
//            oos.writeBytes(application.getRate());
//            oos.writeBytes(application.getRateUnit());
//            oos.writeBytes(",");
//            oos.writeBytes(application.getDate());
//            oos.writeBytes(",");
//            oos.writeBytes(application.getBlockName());
//            oos.writeBytes(",");
//            oos.writeBytes(application.getBlock().getBlockCrop());
//            oos.writeBytes(",");
//            oos.writeBytes(String.valueOf(application.getBlock().getSize()));
//            oos.writeBytes(",");
//            oos.writeBytes(application.getApplicatorProfile().getApplName());
//            oos.writeBytes(",");
//            oos.writeBytes(application.getApplicatorProfile().getLicenseNumber());
//            oos.writeBytes(",");
//            oos.writeBytes(application.getProduct().getActiveIngredient());
//            oos.writeBytes(",");
//            oos.writeBytes(application.getProduct().getReiHrs());
//            oos.writeBytes("\n");
//        }


        oos.writeObject(applicationsArray);

        oos.close();
    }

    public void saveFedRecordsToFile(File file) throws IOException{
//        FileOutputStream fos = new FileOutputStream(file);
        FileWriter fw = new FileWriter(file);
//        ObjectOutputStream oos = new ObjectOutputStream(fos);

        //TODO: Load app list, iterate through to add data to array of correct type //

        List<Application> allApps = databaseDAO.getApplications();
        String fedHeaders = ("Product Name, EPA Number, Amount/Acre, Date, Block, Crop, Block " +
                "Size, Applicator, Applicator Number, Active Ingredients, REI\n");


        Application[] applicationsArray = allApps.toArray(new Application[allApps.size()]);

        fw.append(fedHeaders);


        for(Application application : applicationsArray){
            fw.append(application.getProductName());
            fw.append(",");
            fw.append(application.getProduct().getEpaNumber());
            fw.append(",");
            fw.append(application.getRate());
            fw.append(application.getRateUnit());
            fw.append(",");
            fw.append(application.getDate());
            fw.append(",");
            fw.append(application.getBlockName());
            fw.append(",");
            fw.append(application.getBlock().getBlockCrop());
            fw.append(",");
            fw.append(String.valueOf(application.getBlock().getSize()));
            fw.append(",");
            fw.append(application.getApplicatorProfile().getApplName());
            fw.append(",");
            fw.append(application.getApplicatorProfile().getLicenseNumber());
            fw.append(",");
            fw.append(application.getProduct().getActiveIngredient());
            fw.append(",");
            fw.append(application.getProduct().getReiHrs());
            fw.append("\n");
        }


//        oos.writeObject(applicationsArray);

        fw.flush();
        fw.close();
    }

    public void loadFromFile(File file) throws IOException{
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            Application[] applicationArray = (Application[]) ois.readObject();

            applicationList.clear();
            applicationList.addAll(Arrays.asList(applicationArray));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ois.close();
    }

    public void removeApplicationAtIndex(int row){
//        applicationList.remove(row);
//        int adjRow = row - 1;
        databaseDAO.removeSelectedApplication(row);

        //TODO: remove row from DB
    }


    public List<Application> getApplications(){
        List<Application> applications = databaseDAO.getApplications();
        return applications;
    }


    public void save(Application application) {
        //TODO:Implement saveorupdate
        databaseDAO.saveApplication(application);
    }

    public List<Farm> getFarm(){
        List<Farm> returnedFarm = databaseDAO.getFarm();
        return returnedFarm;
    }

    public void edit(Farm farm){
        databaseDAO.editFarm(farm);
    }

    public void save(Block block){
        databaseDAO.saveBlock(block);
    }

    public List<Block> getBlocks(){
        List<Block> blocks =  databaseDAO.getBlocks();
        return blocks;
    }

    public void removeBlockAtIndex(int row) {
        databaseDAO.removeSelectedBlock(row);
    }

    public void doSomething(){
        databaseDAO.doSomething();
    }

    public void save(ApplicatorProfile applicatorProfile) {
        databaseDAO.saveApplicatorProfile(applicatorProfile);
    }

    public List<ApplicatorProfile> getApplicatorProfiles(){
        List<ApplicatorProfile> applicatorProfiles = databaseDAO.getApplicatorProfiles();
        return applicatorProfiles;
    }

    public void removeApplicatorAtIndex(int row) {databaseDAO.removeSelectedApplicator(row);
    }

    public List<Product> getProducts() {
        List<Product> products = databaseDAO.getProducts();
        return products;
    }

    public void save(Product product){
        databaseDAO.saveProduct(product);

    }

    public void removeSelectedProduct(int row){databaseDAO.removeSelectedProduct(row); }

    public List getAllInfo() { List info = databaseDAO.getAllInfo(); return info;
    }
}
