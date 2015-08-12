/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment.businessobject.customer;

/**
 *
 * @author Gus
 */
import java.util.List;
import java.util.Date;
import java.util.Iterator;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageCustomer {

    private static SessionFactory factory;

    ManageCustomer() {
        try {
            factory = new Configuration().configure().
                    //addPackage("com.xyz") //add package if used.
                    addAnnotatedClass(Customer.class).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void main(String[] args) {

        ManageCustomer MC = new ManageCustomer();
        MC.updateCustomer((long)3, "updated", "customer");
        /* Add few employee records in database */
    //  Long custID1 = MC.addCustomer("Zara", "Ali");
        //  Long custID2 = MC.addCustomer("Daisy", "Das");
        // Long custID3 = MC.addCustomer("John", "Paul");

        /* List down all the employees */
     // MC.listCustomers();

        /* Delete an employee from the database */
     // MC.deleteCustomer(custID2);

        /* List down new list of the employees */
        MC.listCustomers();
    }
    /* Method to CREATE an employee in the database */

    public Long addCustomer(String fname, String lname) {
        Session session = factory.openSession();
        Transaction tx = null;
        Long customerID = null;
        try {
            tx = session.beginTransaction();
            Customer customer = new Customer();
            customer.setFirstName(fname);
            customer.setLastName(lname);

            customerID = (Long) session.save(customer);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return customerID;
    }
    /* Method to  READ all the employees */

    public void listCustomers() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Customer").list();
            for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
                Customer employee = (Customer) iterator.next();
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print("  Last Name: " + employee.getLastName() + "\n");

            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
        public ArrayList<Customer> getAllCustomers() {
        Session session = factory.openSession();
        Transaction tx = null;
        ArrayList<Customer> cust = new ArrayList();
        try {
            tx = session.beginTransaction();
            List customers = session.createQuery("FROM Customer").list();
            for (Iterator iterator = customers.iterator(); iterator.hasNext();) {
                Customer customer = (Customer) iterator.next();
                cust.add(customer);            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cust;
        //return null;
    }

    /* Method to UPDATE salary for an employee */
    public Boolean updateCustomer(Long CustomerID, String fname, String lname) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Customer customer = (Customer) session.get(Customer.class, CustomerID);
            customer.setFirstName(fname);
            customer.setLastName(lname);
            session.update(customer);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
    /* Method to DELETE an employee from the records */

    public Boolean deleteCustomer(Long CustomerID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Customer customer
                    = (Customer) session.get(Customer.class, CustomerID);
            session.delete(customer);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
}
