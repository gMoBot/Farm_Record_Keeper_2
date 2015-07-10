package main.java.com.farmrecordkeeper2.dao;

import main.java.com.farmrecordkeeper2.model.Application;
import main.java.com.farmrecordkeeper2.model.Block;
import main.java.com.farmrecordkeeper2.model.Farm;
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

    public void saveApplication(Application application){
        sessionFactoryBean.getCurrentSession().beginTransaction();
        sessionFactoryBean.getCurrentSession().save(application);
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
    }

    public List<Farm> getFarms(){
        sessionFactoryBean.getCurrentSession().beginTransaction();
        Criteria criteria = sessionFactoryBean.getCurrentSession().createCriteria(Farm.class);
        criteria.add(Restrictions.isNotNull("id"));
        List list = criteria.list();
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
        return list;
    }
    public void saveFarm(Farm farm){
        sessionFactoryBean.getCurrentSession().beginTransaction();
        sessionFactoryBean.getCurrentSession().save(farm);
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
    }

    public List<Block> getBlocks(){
        sessionFactoryBean.getCurrentSession().beginTransaction();
        Criteria criteria = sessionFactoryBean.getCurrentSession().createCriteria(Block.class);
        criteria.add(Restrictions.isNotNull("blockId"));
        List list = criteria.list();
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
        return list;
    }

    public void saveBlock(Block block){
        sessionFactoryBean.getCurrentSession().beginTransaction();
        sessionFactoryBean.getCurrentSession().save(block);
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
    }

    public void doSomething(){
        System.out.println("Doing something from the dao...");
    }
}
