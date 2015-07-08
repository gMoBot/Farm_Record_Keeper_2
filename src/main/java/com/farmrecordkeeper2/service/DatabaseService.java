package main.java.com.farmrecordkeeper2.service;

import main.java.com.farmrecordkeeper2.dao.DatabaseDAO;
import main.java.com.farmrecordkeeper2.dao.DatabaseDAOImpl;
import main.java.com.farmrecordkeeper2.model.Application;
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

//    public DatabaseService(){}

    DatabaseDAO databaseDAO = new DatabaseDAOImpl();

//    @Autowired
//    @Qualifier(value = "databaseDAOImpl")

//    @Resource(name = "databaseDAO")
//    @Autowired
//    private DatabaseDAO databaseDAO;
//    public void setDatabaseDAO(DatabaseDAO databaseDAO){
//        this.databaseDAO = databaseDAO;
//    }

    private List<Application> applicationList;

//    private
//    public DatabaseService(){
//        applicationList = new LinkedList<Application>();
//    }

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
        applicationList.remove(row);
    }

    public List<Application> getApplications(){
        List<Application> applications = databaseDAO.getApplications();
        return applications;
    }


    public void save() {
        //TODO:Implement saveorupdate
    }

//    public void setDatabaseDAO(DatabaseDAO databaseDAO){
//        this.databaseDAO = databaseDAO;
//    }
}
