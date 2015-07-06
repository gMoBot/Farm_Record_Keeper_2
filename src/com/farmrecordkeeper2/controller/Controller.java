package com.farmrecordkeeper2.controller;

import com.farmrecordkeeper2.gui.FormEvent;
import com.farmrecordkeeper2.model.Application;

/**
 * Created by garrettcoggon on 7/2/15.
 */
public class Controller {

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

}
