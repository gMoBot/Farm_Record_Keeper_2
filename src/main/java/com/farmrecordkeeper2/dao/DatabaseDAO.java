package main.java.com.farmrecordkeeper2.dao;

import main.java.com.farmrecordkeeper2.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by garrettcoggon on 7/7/15.
 */
public interface DatabaseDAO {

    public List<Application> getApplications();
    public void saveApplication(Application application);
    public void removeSelectedApplication(int row);
    public List<Farm> getFarm();
    public void editFarm(Farm farm);
    public void saveBlock(Block block);
    public List<Block> getBlocks();
    public void removeSelectedBlock(int row);
    public List<ApplicatorProfile> getApplicatorProfiles();
    public void saveApplicatorProfile(ApplicatorProfile applicatorProfile);
    public void removeSelectedApplicator(int row);
    public List<Product> getProducts();
    public void saveProduct(Product product);
    public void removeSelectedProduct(int row);

    public List<Application> getBlockApplications(int row);
    public List<Application> getApplicatorApplications(int row);
    public List<Application> getProductApplications(int row);
}
