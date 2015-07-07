package com.farmrecordkeeper2.model;

import com.farmrecordkeeper2.service.DatabaseDAO;
import com.farmrecordkeeper2.service.DatabaseDAOImpl;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
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
public class Database {

//    @Autowired
//    private DatabaseDAO databaseDAO;
    //TODO Figure out why this isn't autowiring...
    DatabaseDAO databaseDAO = new DatabaseDAOImpl();

    private List<Application> applicationList;

    public Database(){
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
        applicationList.remove(row);
    }

    public List<Application> getApplications(){
        List<Application> applications = databaseDAO.getApplications();
        return applications;
    }


    public void save() {
        //TODO:Implement saveorupdate
    }

}
