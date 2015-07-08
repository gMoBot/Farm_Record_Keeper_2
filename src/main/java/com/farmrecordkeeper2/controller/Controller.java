package main.java.com.farmrecordkeeper2.controller;

import main.java.com.farmrecordkeeper2.model.Application;
import main.java.com.farmrecordkeeper2.service.DatabaseService;
import main.java.com.farmrecordkeeper2.gui.FormEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by garrettcoggon on 7/2/15.
 */
public class Controller {


    DatabaseService db = new DatabaseService();
//    @Autowired

//    @Resource(name = "databaseService")
//    private DatabaseService db;

    public void addAppl(FormEvent e){
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
    }


    public void getApplications(){
        List<Application> appList = db.getApplications();
        if (appList.isEmpty()){
            System.out.print("No Applications Found");
        }
        else {
            //TODO: Load into table
            System.out.print("Applications Found");
        }
    }

    public void save() {
        db.save();
    }
}
