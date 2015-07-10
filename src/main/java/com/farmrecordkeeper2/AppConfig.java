package main.java.com.farmrecordkeeper2;

import main.java.com.farmrecordkeeper2.controller.Controller;
import main.java.com.farmrecordkeeper2.dao.DatabaseDAO;
import main.java.com.farmrecordkeeper2.dao.DatabaseDAOImpl;
import main.java.com.farmrecordkeeper2.model.*;
import main.java.com.farmrecordkeeper2.service.DatabaseService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by garrettcoggon on 7/8/15.
 */

@Configuration
@ComponentScan({"com.farmrecordkeeper2"})
public class AppConfig {

    @Bean(name = "controller")
    public Controller getController(){
        Controller controller = new Controller();
        controller.setDatabaseService(getDatabaseService());
        return controller;
    }

    @Bean(name = "databaseService")
    public DatabaseService getDatabaseService(){
        DatabaseService databaseService = new DatabaseService();
//        databaseService.setDatabaseDAO(getDatabaseDAO());
        return databaseService;
    }

    @Bean(name = "databaseDAO")
    public DatabaseDAO getDatabaseDAO(SessionFactory sessionFactory){
        return new DatabaseDAOImpl(sessionFactory);
    }


    @Bean(name = "dataSource")
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:farmrecords.db");
        return dataSource;
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource){
        LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder
                (dataSource);
        sessionFactoryBuilder.addAnnotatedClasses(Application.class, Farm.class, Block.class,
                ApplicatorProfile.class, Product.class);
        sessionFactoryBuilder.addProperties(getHibernateProperties());

        return sessionFactoryBuilder.buildSessionFactory();


    }


//    @Bean(name = "hibernateProperties")
    private Properties getHibernateProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "main.java.org.hibernate" +
                ".dialect" +
                ".SQLiteDialect");
        properties.put("hibernate.current_session_context_class", "thread");
        return properties;
    }


    @Autowired
    @Bean(name = "transactionManager")
    public org.springframework.orm.hibernate4.HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
        org.springframework.orm.hibernate4.HibernateTransactionManager transactionManager = new
                org.springframework.orm.hibernate4.HibernateTransactionManager(sessionFactory);
        return transactionManager;

    }

}
