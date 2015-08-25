/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment.data;

import appointment.businessobject.Customer;
import appointment.businessobject.CustomerChar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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

    public static void main(String[] args) {

        ObjectFactory MC = new ObjectFactory();
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

    public Customer addCustomer(Customer cust) {
        Session session = factory.openSession();
        Transaction tx = null;
        Long customerID = null;
        Customer customer = cust;
        try {
            tx = session.beginTransaction();
      
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
        return customer;
    }
    public Object addDataResource(Object resource) {
        Session session = factory.openSession();
        Transaction tx = null;
        Long resourceID = null;
        Object customer = resource;
        try {
            tx = session.beginTransaction();
      
            resourceID = (Long) session.save(resource);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return resource;
    }
    
        public Object getDataResource(Class resourceClass, long id) {
        Session session = factory.openSession();
        Object dataObject = session.get(resourceClass, new Long(id));
        return dataObject;
    }
        
        
        public Customer addCustomer(String fname, String lname) {
        Session session = factory.openSession();
        Transaction tx = null;
        Long customerID = null;
        Customer customer = new Customer();
        try {
            tx = session.beginTransaction();
            
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
        return customer;
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
        
       public Customer getCustomer(Long id) {
        Session session = factory.openSession();
        Transaction tx = null;
        Customer cust = new Customer();
        try {
            tx = session.beginTransaction();
 
            List customers = session.createQuery("FROM Customer WHERE cust_id = " + id).list();
            for (Iterator iterator = customers.iterator(); iterator.hasNext();) {
                cust = (Customer) iterator.next();
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


///**
// *
// * @author Marrows
// */
//public class ObjectFactory {
//
//    // JDBC driver name and database URL
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://52.27.193.81/base";
//    //  Database credentials
//    static final String USER = "sysuser";
//    static final String PASS = "sysuser00";
//
//    public Customer addCustomer(Customer cust) {
//        Connection conn = null;
//        Statement stmt = null;
//        Customer returnCust = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            stmt = conn.createStatement();
//            String first_name = cust.getFirstName();
//            String last_name = cust.getLastName();
//
//            //prep string and execute
//            String insertStatement = "INSERT INTO customer (first_name, last_name) VALUES (?, ?)";
//            PreparedStatement preparedStatement = conn.prepareStatement(insertStatement);
//            preparedStatement.setString(1, first_name);
//            preparedStatement.setString(2, last_name);
//            preparedStatement.executeUpdate();
//
//            String selectStatement;
//            selectStatement = "SELECT * FROM customer WHERE first_name = '" + first_name + "' AND last_name = '" + last_name + "'";
//            System.out.println(selectStatement);
//            ResultSet rs = stmt.executeQuery(selectStatement);
//
//            // Extract data from result set
//            while (rs.next()) {
//                //Retrieve by column name
//                String first = rs.getString("first_name");
//                String last = rs.getString("last_name");
//                Long id = rs.getLong("cust_id");
//
//                returnCust = new Customer(first, last, id);
//                return returnCust;
//            }
//            // Clean-up environment
//            rs.close();
//            stmt.close();
//            conn.close();
//        } catch (SQLException se) {
//            //Handle errors for JDBC
//
//        } catch (ClassNotFoundException e) {
//            //Handle errors for Class.forName
//
//        } finally {
//            //finally block used to close resources
//            try {
//                if (stmt != null) {
//                    stmt.close();
//                }
//            } catch (SQLException se2) {
//            }// nothing we can do
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException se) {
//            }
//        }
//        return null;
//    }
//
//    public Customer getCustomer(Customer cust) {
//        Connection conn = null;
//        Statement stmt = null;
//        Customer returnCust = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            stmt = conn.createStatement();
//            String first_name = cust.getFirstName();
//            String last_name = cust.getLastName();
//
//            String selectStatement;
//            selectStatement = "SELECT * FROM customer WHERE first_name = '" + first_name + "' AND last_name = '" + last_name + "'";
//            ResultSet rs = stmt.executeQuery(selectStatement);
//
//            // Extract data from result set
//            while (rs.next()) {
//                //Retrieve by column name
//                String first = rs.getString("first_name");
//                String last = rs.getString("last_name");
//                Long id = rs.getLong("cust_id");
//
//                returnCust = new Customer(first, last, id);
//                return returnCust;
//            }
//            // Clean-up environment
//            rs.close();
//            stmt.close();
//            conn.close();
//        } catch (SQLException se) {
//            //Handle errors for JDBC
//
//        } catch (ClassNotFoundException e) {
//            //Handle errors for Class.forName
//
//        } finally {
//            //finally block used to close resources
//            try {
//                if (stmt != null) {
//                    stmt.close();
//                }
//            } catch (SQLException se2) {
//            }// nothing we can do
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException se) {
//            }
//        }
//        return null;
//    }
//
//    public Customer getCustomer(Long ID) {
//        Connection conn = null;
//        Statement stmt = null;
//        Customer returnCust = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            stmt = conn.createStatement();
//            String selectStatement;
//            selectStatement = "SELECT * FROM customer WHERE cust_id = '" + ID + "'";
//            ResultSet rs = stmt.executeQuery(selectStatement);
//
//            // Extract data from result set
//            while (rs.next()) {
//                //Retrieve by column name
//                String first = rs.getString("first_name");
//                String last = rs.getString("last_name");
//                Long id = rs.getLong("cust_id");
//
//                returnCust = new Customer(first, last, id);
//                return returnCust;
//            }
//            // Clean-up environment
//            rs.close();
//            stmt.close();
//            conn.close();
//        } catch (SQLException se) {
//            //Handle errors for JDBC
//
//        } catch (ClassNotFoundException e) {
//            //Handle errors for Class.forName
//
//        } finally {
//            //finally block used to close resources
//            try {
//                if (stmt != null) {
//                    stmt.close();
//                }
//            } catch (SQLException se2) {
//            }// nothing we can do
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException se) {
//            }
//        }
//        return null;
//    }
//
//    public void deleteCustomer(Long ID) {
//        Connection conn = null;
//        Statement stmt = null;
//        Customer returnCust = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            stmt = conn.createStatement();
//            String selectStatement;
//            selectStatement = "Delete * FROM customer WHERE cust_id = '" + ID + "'";
//
//            stmt.close();
//            conn.close();
//        } catch (SQLException se) {
//            //Handle errors for JDBC
//
//        } catch (ClassNotFoundException e) {
//            //Handle errors for Class.forName
//
//        } finally {
//            //finally block used to close resources
//            try {
//                if (stmt != null) {
//                    stmt.close();
//                }
//            } catch (SQLException se2) {
//            }// nothing we can do
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException se) {
//            }
//        }
//
//    }
//
//    public List<Customer> getAllCustomers() {
//        Connection conn = null;
//        Statement stmt = null;
//        Customer returnCust = null;
//        ArrayList<Customer> allCustomers = new ArrayList();
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            stmt = conn.createStatement();
//
//            String selectStatement;
//            selectStatement = "SELECT * FROM customer";
//            ResultSet rs = stmt.executeQuery(selectStatement);
//
//            // Extract data from result set
//            while (rs.next()) {
//                //Retrieve by column name
//                String first = rs.getString("first_name");
//                String last = rs.getString("last_name");
//                Long id = rs.getLong("cust_id");
//                allCustomers.add(new Customer(first, last, id));
//            }
//
//            // Clean-up environment
//            rs.close();
//            stmt.close();
//            conn.close();
//            return allCustomers;
//        } catch (SQLException se) {
//            //Handle errors for JDBC
//
//        } catch (ClassNotFoundException e) {
//            //Handle errors for Class.forName
//
//        } finally {
//            //finally block used to close resources
//            try {
//                if (stmt != null) {
//                    stmt.close();
//                }
//            } catch (SQLException se2) {
//            }// nothing we can do
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException se) {
//            }
//        }
//        return null;
//    }
//
//    public static void main(String[] args) {
//        Customer test1 = new Customer("Test3", "Test3", (long) 1);
//        Customer test2;
//        ObjectFactory_tutorial a = new ObjectFactory_tutorial();
//        //test2 = a.setCustomer(test1);
//        //test2 = a.getCustomer(test1);
//        test2 = a.getAllCustomers().get(2);
//
//        System.out.println(test2.getFirstName() + " " + test2.getLastName() + " " + test2.getID());
//
//    }
//}
