/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment.data;

import appointment.businessobject.Customer;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


/**
 *
 * @author Marrows
 */
public class ObjectFactory_tutorial {

    // JDBC driver name and database URL

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://52.27.193.81/base";
    //  Database credentials
    static final String USER = "sysuser";
    static final String PASS = "sysuser00";

    public Customer setCustomer(Customer cust) {
        Connection conn = null;
        Statement stmt = null;
        Customer returnCust = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String first_name = cust.getFirstName();
            String last_name = cust.getLastName();

            //prep string and execute
            String insertStatement = "INSERT INTO customer (first_name, last_name) VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertStatement);
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);
            preparedStatement.executeUpdate();
            
            String selectStatement;
            selectStatement = "SELECT * FROM customer WHERE first_name = '" + first_name + "' AND last_name = '" + last_name + "'";
            System.out.println(selectStatement);
            ResultSet rs = stmt.executeQuery(selectStatement);

            // Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");
                Long id = rs.getLong("cust_id");

                returnCust = new Customer(first, last, id);
                return returnCust;                
            }
            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC

        } catch (ClassNotFoundException e) {
            //Handle errors for Class.forName

        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) { 
        }
    }
        return null;
}
    
     public Customer getCustomer(Customer cust) {
        Connection conn = null;
        Statement stmt = null;
        Customer returnCust = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String first_name = cust.getFirstName();
            String last_name = cust.getLastName();
          
            String selectStatement;
            selectStatement = "SELECT * FROM customer WHERE first_name = '" + first_name + "' AND last_name = '" + last_name + "'";
            ResultSet rs = stmt.executeQuery(selectStatement);

            // Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");
                Long id = rs.getLong("cust_id");

                returnCust = new Customer(first, last, id);
                return returnCust;                
            }
            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC

        } catch (ClassNotFoundException e) {
            //Handle errors for Class.forName

        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) { 
        }
    }
        return null;
}
     
      public List<Customer> getAllCustomers() {
        Connection conn = null;
        Statement stmt = null;
        Customer returnCust = null;
        ArrayList<Customer> allCustomers = new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

          
            String selectStatement;
            selectStatement = "SELECT * FROM customer";
            ResultSet rs = stmt.executeQuery(selectStatement);

            // Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");
                Long id = rs.getLong("cust_id");
                allCustomers.add(new Customer(first, last, id));                             
            }
               
            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return allCustomers;
        } catch (SQLException se) {
            //Handle errors for JDBC

        } catch (ClassNotFoundException e) {
            //Handle errors for Class.forName

        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) { 
        }
    }
        return null;
}

    
    public static void main(String[] args) {
        Customer test1 = new Customer("Test3","Test3",(long) 1);
        Customer test2;
        ObjectFactory_tutorial a = new ObjectFactory_tutorial();
        //test2 = a.setCustomer(test1);
        //test2 = a.getCustomer(test1);
        test2 = a.getAllCustomers().get(2);
        System.out.println(test2.getFirstName() + " " + test2.getLastName() + " " + test2.getID());
                
    }
}
    
//    public static void main(String[] args) {
//        Connection conn = null;
//        Statement stmt = null;
//        try {
//            //STEP 2: Register JDBC driver
//            Class.forName("com.mysql.jdbc.Driver");
//
//            //STEP 3: Open a connection
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//
//            //STEP 4: Execute a query
//            System.out.println("Creating statement...");
//            stmt = conn.createStatement();
//            String sql2;
//            sql2 = "SELECT * FROM customer";
//
//            String first_name = "What";
//            String last_name = "Up";
//
//            String sql = "INSERT INTO customer (first_name, last_name) VALUES (?, ?)";
//            PreparedStatement preparedStatement = conn.prepareStatement(sql);
//            preparedStatement.setString(1, first_name);
//            preparedStatement.setString(2, last_name);
//            preparedStatement.executeUpdate();
//            ResultSet rs = stmt.executeQuery(sql2);
//
//            //STEP 5: Extract data from result set
//            while (rs.next()) {
//                //Retrieve by column name
//                String first = rs.getString("first_name");
//                String last = rs.getString("last_name");
//
//                //Display values
//                System.out.print("First: " + first);
//                System.out.println(" Last: " + last);
//            }
//            //STEP 6: Clean-up environment
//            rs.close();
//            stmt.close();
//            conn.close();
//        } catch (SQLException se) {
//            //Handle errors for JDBC
//            se.printStackTrace();
//        } catch (Exception e) {
//            //Handle errors for Class.forName
//            e.printStackTrace();
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
//                se.printStackTrace();
//            }//end finally try
//        }//end try
//        System.out.println("Goodbye!");
//    }//end main
//}

//public class ObjectFactory_tutorial {
//    private SimpleMySQL mysql;
//    public ObjectFactory_tutorial (){
//        mysql = new SimpleMySQL();
//        mysql.connect("52.27.193.81:3306", "sysuser", "sysuser00", "base");
//    }
//    
//    public Customer getCustomer(long ID){
//        Customer returnCustomer = null;
//        
//        SimpleMySQLResult result;
//        result = mysql.Query ("SELECT * FROM customer WHERE cust_id = " + Long.toString(ID));
//
//     
//        while (result.next()){
//            returnCustomer = new Customer(result.getString("first_name"), result.getString("last_name"), ID);
//            break;
//        }
//        
//        return returnCustomer;
//    }
//    
//        public List<Customer> getAllCustomers(){
//        ArrayList<Customer> allCustomers = new ArrayList();
//        
//        SimpleMySQLResult result;
//        result = mysql.Query ("SELECT * FROM customer");
//
//        while (result.next()){       
//            allCustomers.add(new Customer(result.getString("first_name"), result.getString("last_name"), Long.parseLong(result.getString("cust_id"))));
//        }
//        
//        return allCustomers;
//    }
//    
//    public Customer addCustomer(Customer newCustomer){
//        
//        SimpleMySQLResult result;
//        result = mysql.Query ("INSERT INTO customer (first_name, last_name) VALUES(\"" + newCustomer.getFirstName() + "\", \"" + newCustomer.getLastName() + "\"");
//        
//        return newCustomer;
//    }
//}
