package main.java.com.farmrecordkeeper2.dao;

import main.java.com.farmrecordkeeper2.model.*;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
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

    public void removeSelectedApplication(int row){
        sessionFactoryBean.getCurrentSession().beginTransaction();
        Object selectedApp = sessionFactoryBean.getCurrentSession().load(Application.class, row);
        if(selectedApp != null){
            sessionFactoryBean.getCurrentSession().delete(selectedApp);
        }
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
    }

    public List<Farm> getFarm(){
        sessionFactoryBean.getCurrentSession().beginTransaction();
        Criteria criteria = sessionFactoryBean.getCurrentSession().createCriteria(Farm.class);
        criteria.add(Restrictions.isNotNull("id"));
        criteria.setMaxResults(2);
        List list = criteria.list();
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
        return list;
    }

    public void editFarm(Farm farm){
        sessionFactoryBean.getCurrentSession().beginTransaction();
        sessionFactoryBean.getCurrentSession().saveOrUpdate(farm);
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

    public void removeSelectedBlock(int row){
        sessionFactoryBean.getCurrentSession().beginTransaction();
        Object selectedBlock = sessionFactoryBean.getCurrentSession().load(Block.class, row);
        if(selectedBlock != null){
            sessionFactoryBean.getCurrentSession().delete(selectedBlock);
        }
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
    }

    public List<ApplicatorProfile> getApplicatorProfiles() {
        sessionFactoryBean.getCurrentSession().beginTransaction();
        Criteria criteria = sessionFactoryBean.getCurrentSession().createCriteria(ApplicatorProfile.class);
        criteria.add(Restrictions.isNotNull("farmId"));
        List list = criteria.list();
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
        return list;
    }

    public void saveApplicatorProfile(ApplicatorProfile applicatorProfile) {
        sessionFactoryBean.getCurrentSession().beginTransaction();
        sessionFactoryBean.getCurrentSession().save(applicatorProfile);
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
    }
    public void removeSelectedApplicator(int row){
        sessionFactoryBean.getCurrentSession().beginTransaction();
        Object selectedApplicator = sessionFactoryBean.getCurrentSession().load(ApplicatorProfile.class, row);
        if(selectedApplicator != null){
            sessionFactoryBean.getCurrentSession().delete(selectedApplicator);
        }
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
    }

    public List<Product> getProducts() {
        sessionFactoryBean.getCurrentSession().beginTransaction();
        Criteria criteria = sessionFactoryBean.getCurrentSession().createCriteria(Product.class);
        criteria.add(Restrictions.isNotNull("farmId"));
        List list = criteria.list();
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
        return list;
    }

    public void saveProduct(Product product) {
        sessionFactoryBean.getCurrentSession().beginTransaction();
        sessionFactoryBean.getCurrentSession().save(product);
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
    }

    public void removeSelectedProduct(int row){
        sessionFactoryBean.getCurrentSession().beginTransaction();
        Object selectedProduct = sessionFactoryBean.getCurrentSession().load(Product.class, row);
        if(selectedProduct != null){
            sessionFactoryBean.getCurrentSession().delete(selectedProduct);
        }
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
    }

    public List getAllInfo() {
        sessionFactoryBean.getCurrentSession().beginTransaction();
//        Criteria criteria = sessionFactoryBean.getCurrentSession().createCriteria(Application
//                .class);
//        criteria.createAlias("block", "blockName", JoinType.LEFT_OUTER_JOIN);
        DetachedCriteria appCriteria = DetachedCriteria.forClass(Application.class);
        appCriteria.setProjection(Property.forName("blockName"));
        Criteria criteria = sessionFactoryBean.getCurrentSession().createCriteria(Block.class);
        criteria.add(Property.forName("blockName").in(appCriteria));
        List list = criteria.list();
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
        return list;

//        System.out.println(String.valueOf(list.get(0).toString()));

    }

    public void doSomething(){
        System.out.println("Doing something from the dao...");
    }
}
