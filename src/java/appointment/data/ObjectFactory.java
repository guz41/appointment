/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment.data;

import appointment.businessobject.customer.Customer;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Marrows
 */
public class ObjectFactory {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://52.27.193.81/base";
    //  Database credentials
    static final String USER = "sysuser";
    static final String PASS = "sysuser00";

    public Customer addCustomer(Customer cust) {
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

    public Customer getCustomer(Long ID) {
        Connection conn = null;
        Statement stmt = null;
        Customer returnCust = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String selectStatement;
            selectStatement = "SELECT * FROM customer WHERE cust_id = '" + ID + "'";
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

    public void deleteCustomer(Long ID) {
        Connection conn = null;
        Statement stmt = null;
        Customer returnCust = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String selectStatement;
            selectStatement = "Delete * FROM customer WHERE cust_id = '" + ID + "'";

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
        Customer test1 = new Customer("Test3", "Test3", (long) 1);
        Customer test2;
        ObjectFactory_tutorial a = new ObjectFactory_tutorial();
        //test2 = a.setCustomer(test1);
        //test2 = a.getCustomer(test1);
        test2 = a.getAllCustomers().get(2);

        System.out.println(test2.getFirstName() + " " + test2.getLastName() + " " + test2.getID());

    }
}
