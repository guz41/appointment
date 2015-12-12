///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package appointment.data;
//
//import appointment.businessobject.Customer;
//import java.util.ArrayList;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Gus
// */
//public class ObjectFactoryTest {
//    
//    public ObjectFactoryTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of main method, of class ObjectFactory.
//     */
////    @Test
////    public void testMain() {
////        System.out.println("main");
////        String[] args = null;
////        ObjectFactory.main(args);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
//
//    /**
//     * Test of addCustomer method, of class ObjectFactory.
//     */
//    @Test
//    public void testAddCustomer_Customer() {
//        System.out.println("addCustomer");
//        Customer cust = new Customer("junitFirst1","jUnitLast1");
//        ObjectFactory instance = new ObjectFactory();
//        Customer expResult = cust;
//        Customer result = instance.addCustomer(cust);
//        assertEquals(expResult, result);
//        
//    }
//
//    /**
//     * Test of addDataResource method, of class ObjectFactory.
//     */
//    @Test
//    public void testAddDataResource() {
//        System.out.println("addDataResource");
//        Object resource = new Customer("junitFirst1","jUnitLast1");
//        ObjectFactory instance = new ObjectFactory();
//        Object expResult = resource;
//        Object result = instance.addDataResource(resource);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of addCustomer method, of class ObjectFactory.
//     */
//    @Test
//    public void testAddCustomer_String_String() {
//        System.out.println("addCustomer");
//        String fname = "test1";
//        String lname = "test2";
//        ObjectFactory instance = new ObjectFactory();
//        Customer expResult = null;
//        Customer result = instance.addCustomer(fname, lname);
//        assertEquals(fname, result.getFirstName());
//        assertEquals(lname, result.getLastName());
//
//    }
//
////    /**
////     * Test of listCustomers method, of class ObjectFactory.
////     */
////    @Test
////    public void testListCustomers() {
////        System.out.println("listCustomers");
////        ObjectFactory instance = new ObjectFactory();
////        instance.listCustomers();
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
//
//    /**
//     * Test of getAllCustomers method, of class ObjectFactory.
//     */
////    @Test
////    public void testGetAllCustomers() {
////        System.out.println("getAllCustomers");
////        ObjectFactory instance = new ObjectFactory();
////        ArrayList<Customer> expResult = null;
////        ArrayList<Customer> result = instance.getAllCustomers();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
//
//    /**
//     * Test of getCustomer method, of class ObjectFactory.
//     */
////    @Test
////    public void testGetCustomer() {
////        System.out.println("getCustomer");
////        Long id = null;
////        ObjectFactory instance = new ObjectFactory();
////        Customer expResult = null;
////        Customer result = instance.getCustomer(id);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
//
//    /**
//     * Test of updateCustomer method, of class ObjectFactory.
//     */
////    @Test
////    public void testUpdateCustomer() {
////        System.out.println("updateCustomer");
////        Long CustomerID = null;
////        String fname = "";
////        String lname = "";
////        ObjectFactory instance = new ObjectFactory();
////        Boolean expResult = null;
////        Boolean result = instance.updateCustomer(CustomerID, fname, lname);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
//
//    /**
//     * Test of deleteCustomer method, of class ObjectFactory.
//     */
//    //@Test
////    public void testDeleteCustomer() {
////        System.out.println("deleteCustomer");
////        Long CustomerID = null;
////        ObjectFactory instance = new ObjectFactory();
////        Boolean expResult = null;
////        Boolean result = instance.deleteCustomer(CustomerID);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
//    
//}
