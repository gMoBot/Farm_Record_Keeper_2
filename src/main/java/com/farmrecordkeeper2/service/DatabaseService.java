package main.java.com.farmrecordkeeper2.service;

import main.java.com.farmrecordkeeper2.dao.DatabaseDAO;
import main.java.com.farmrecordkeeper2.dao.DatabaseDAOImpl;
import main.java.com.farmrecordkeeper2.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    public void saveToFile(File file) throws IOException{
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Application[] applicationsArray = applicationList.toArray(new Application[applicationList
                .size()]);

        oos.writeObject(applicationsArray);

        oos.close();
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

    public void save(Farm farm){
        databaseDAO.saveFarm(farm);
    }

    public void save(Block block){
        databaseDAO.saveBlock(block);
    }

    public List<Block> getBlocks(){
        List<Block> blocks =  databaseDAO.getBlocks();
        return blocks;
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

    public List<Product> getProducts() {
        List<Product> products = databaseDAO.getProducts();
        return products;
    }

    public void save(Product product){
        databaseDAO.saveProduct(product);

    }
}
