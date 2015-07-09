package main.java.com.farmrecordkeeper2.dao;

import main.java.com.farmrecordkeeper2.model.Application;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by garrettcoggon on 7/7/15.
 */

@Repository("databaseDAO")
public class DatabaseDAOImpl implements DatabaseDAO {

    public DatabaseDAOImpl(){}

    @Autowired
    private SessionFactory sessionFactoryBean;

    public DatabaseDAOImpl(SessionFactory sessionFactoryBean) {
        System.out.println("Setting daoimpl sessionfactorybean");
        this.sessionFactoryBean = sessionFactoryBean;
    }


    public List<Application> getApplications(){
        sessionFactoryBean.getCurrentSession().beginTransaction();
        Criteria criteria = sessionFactoryBean.getCurrentSession().createCriteria(Application
                .class);
        criteria.add(Restrictions.isNotNull("id"));
        List list = criteria.list();
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
        return list;
    }

    public void doSomething(){
        System.out.println("Doing something from the dao...");
    }
}
