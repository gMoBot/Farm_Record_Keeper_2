package main.java.com.farmrecordkeeper2.testservice;

import main.java.com.farmrecordkeeper2.testmodel.Customer;

import java.util.List;

/**
 * Created by garrettcoggon on 7/8/15.
 */
public interface CustomerService {

    List<Customer> findAll();

}
