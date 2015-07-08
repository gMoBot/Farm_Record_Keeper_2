package main.java.com.farmrecordkeeper2;

import main.java.com.farmrecordkeeper2.controller.Controller;
import main.java.com.farmrecordkeeper2.dao.DatabaseDAO;
import main.java.com.farmrecordkeeper2.dao.DatabaseDAOImpl;
import main.java.com.farmrecordkeeper2.service.DatabaseService;
import main.java.com.farmrecordkeeper2.testrepo.CustomerRepository;
import main.java.com.farmrecordkeeper2.testrepo.HibernateCustomerRepositoryImpl;
import main.java.com.farmrecordkeeper2.testservice.CustomerService;
import main.java.com.farmrecordkeeper2.testservice.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by garrettcoggon on 7/8/15.
 */

@Configuration
@ComponentScan({"com.farmrecordkeeper2"})
public class AppConfig {

    @Bean(name = "customerService")
    public CustomerService getCustomerService(){
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        customerService.setCustomerRepository(getCustomerRepository());


        return customerService;
    }

    @Bean(name = "customerRepository")
    public CustomerRepository getCustomerRepository(){
        return new HibernateCustomerRepositoryImpl();
    }

    @Bean(name = "controller")
    public Controller getController(){
        Controller controller1 = new Controller();
        controller1.setDatabaseService(getDatabaseService());
        return controller1;
    }

    @Bean(name = "databaseService")
    public DatabaseService getDatabaseService(){
        DatabaseService databaseService = new DatabaseService();
        databaseService.setDatabaseDAO(getDatabaseDAO());
        return databaseService;
    }

    @Bean(name = "databaseDAO")
    public DatabaseDAO getDatabaseDAO(){
        return new DatabaseDAOImpl();
    }

}
