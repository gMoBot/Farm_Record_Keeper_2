package main.java.com.farmrecordkeeper2.dao;

import main.java.com.farmrecordkeeper2.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by garrettcoggon on 7/7/15.
 */
//@Repository
public interface DatabaseDAO {

    public List<Application> getApplications();
    public void saveApplication(Application application);
    public void removeSelectedApplication(int row);
    public List<Farm> getFarm();
    public void saveFarm(Farm farm);
    public void saveBlock(Block block);
    public List<Block> getBlocks();
    public List<ApplicatorProfile> getApplicatorProfiles();
    public void saveApplicatorProfile(ApplicatorProfile applicatorProfile);
    public List<Product> getProducts();
    public void saveProduct(Product product);

    public void doSomething();



}
