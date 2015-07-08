package main.java.com.farmrecordkeeper2.testrepo;

import main.java.com.farmrecordkeeper2.testmodel.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by garrettcoggon on 7/8/15.
 */

@Repository("customerRepository")
public class HibernateCustomerRepositoryImpl implements CustomerRepository {

    public List<Customer> findAll() {

        List<Customer> customers = new ArrayList<Customer>();

        Customer customer = new Customer();

        customer.setFirstname("John");
        customer.setLastname("Smith");

        customers.add(customer);

        return customers;

    }

}
