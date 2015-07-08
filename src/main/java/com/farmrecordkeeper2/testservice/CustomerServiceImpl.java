package main.java.com.farmrecordkeeper2.testservice;

import main.java.com.farmrecordkeeper2.testmodel.Customer;
import main.java.com.farmrecordkeeper2.testrepo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by garrettcoggon on 7/8/15.
 */

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    public CustomerServiceImpl(){}

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        System.out.println("Using constructor");

        this.customerRepository = customerRepository;
    }

//    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        System.out.println("Using setter");
        this.customerRepository = customerRepository;
    }


    public List<Customer> findAll() {
        return customerRepository.findAll();
    }


}
