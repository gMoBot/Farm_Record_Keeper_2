package com.farmrecordkeeper2.service;

import com.farmrecordkeeper2.model.Application;

import java.util.List;

/**
 * Created by garrettcoggon on 7/7/15.
 */
public interface DatabaseDAO {

    public List<Application> getApplications();
}
