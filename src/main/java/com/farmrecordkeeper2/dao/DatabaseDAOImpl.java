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

//@Repository("databaseDAOImpl")
public class DatabaseDAOImpl implements DatabaseDAO {

    // TODO: session factorybean is null-correct autowiring
//    @Autowired
    private SessionFactory sessionFactoryBean;
//    ApplicationContext context =

//    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


//    public DatabaseDAOImpl(){}
//
//    public DatabaseDAOImpl(SessionFactory sessionFactoryBean) {
//        this.sessionFactoryBean = sessionFactoryBean;
//    }


//
//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory){
//        this.sessionFactoryBean = sessionFactory;
//    }

    public List<Application> getApplications(){
        sessionFactoryBean.getCurrentSession().beginTransaction();
        Criteria criteria = sessionFactoryBean.getCurrentSession().createCriteria(Application
                .class);
        criteria.add(Restrictions.isNotNull("id"));
        List list = criteria.list();
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
        return list;
    }
}
