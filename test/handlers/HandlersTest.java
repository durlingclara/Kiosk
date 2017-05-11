/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author clara.durling
 */
public class HandlersTest {
    
    public HandlersTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMember method, of class Handlers.
     */
    @Test
    public void testGetMember() {
        System.out.println("getMember");
        String phoneNumber = "";
        Member expResult = null;
        Member result = Handlers.getMember(phoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isMember method, of class Handlers.
     */
    @Test
    public void testIsMember() {
        System.out.println("isMember");
        String phoneNumber = "";
        Boolean expResult = null;
        Boolean result = Handlers.isMember(phoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkIn method, of class Handlers.
     */
    @Test
    public void testCheckIn() {
        System.out.println("checkIn");
        String phoneNumber = "";
        String birthday = "";
        Handlers.checkIn(phoneNumber, birthday);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class Handlers.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        String expResult = "";
        String result = Handlers.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkRedeem method, of class Handlers.
     */
    @Test
    public void testCheckRedeem() {
        System.out.println("checkRedeem");
        String phoneNumber = "";
        Member expResult = null;
        Member result = Handlers.checkRedeem(phoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
