/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment.data;

import java.util.HashMap;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Expression;

public class ObjectFactory {

    private static SessionFactory factory;

    public ObjectFactory() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    //add or update a data resource
     public Object updateDataResource(Object resource) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Object mergedOne = session.merge(resource);
        session.saveOrUpdate(mergedOne);
            tx.commit();
        
        return mergedOne;
    }
     
    public Object getDataResource(Class resourceClass, long id) {
        Session session = factory.openSession();
        Object dataObject = session.get(resourceClass, new Long(id));
        return dataObject;
    }
        
    public List<Object> getDataResourceList(Class resourceClass) {
        Session session = factory.openSession();
        List<Object> dataObjects = session.createCriteria(resourceClass).list();
        return dataObjects;
    }
    
    public List<Object> getDataResourceList(Class resourceClass, String column, String value) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(resourceClass);
        criteria.add(Expression.eq(column, value));
        List<Object> dataObjects = criteria.list();
        return dataObjects;
    }
    
    public List<Object> getDataResourceList(Class resourceClass, HashMap<String, Object> criteriaList) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(resourceClass);
        for (String k: criteriaList.keySet()) {
            criteria.add(Expression.eq(k, criteriaList.get(k)));
        }
        List<Object> dataObjects = criteria.list();
        return dataObjects;
    }
    
    public void deleteResource (Object cannedObject) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(cannedObject);
        session.flush() ;
        tx.commit();

    }
}