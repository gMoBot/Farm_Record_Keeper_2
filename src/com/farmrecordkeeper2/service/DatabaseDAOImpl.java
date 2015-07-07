package com.farmrecordkeeper2.service;

import com.farmrecordkeeper2.model.Application;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by garrettcoggon on 7/7/15.
 */

@Repository
public class DatabaseDAOImpl implements DatabaseDAO {

    @Autowired
    private SessionFactory sessionFactoryBean;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactoryBean = sessionFactory;
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
}
