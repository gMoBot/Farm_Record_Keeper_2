package com.farmrecordkeeper2.model;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by garrettcoggon on 7/7/15.
 */

@Repository
public class Database {

    private List<Application> applicationList;

    @Autowired
    private SessionFactory sessionFactoryBean;

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
        sessionFactoryBean.getCurrentSession().beginTransaction();
        Criteria criteria = sessionFactoryBean.getCurrentSession().createCriteria(Application
                .class);
        List list = criteria.list();
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
        return list;
    }


    public void save() {
        //TODO:Implement saveorupdate
    }
}
