package com.farmrecordkeeper2.controller;

import com.farmrecordkeeper2.gui.FormEvent;
import com.farmrecordkeeper2.model.Application;
import com.farmrecordkeeper2.model.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by garrettcoggon on 7/2/15.
 */
//@Component
public class Controller {


    Database db = new Database();

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
