package main.java.com.farmrecordkeeper2.dao;

import main.java.com.farmrecordkeeper2.model.Application;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by garrettcoggon on 7/7/15.
 */
@Repository
public interface DatabaseDAO {

    public List<Application> getApplications();
}
