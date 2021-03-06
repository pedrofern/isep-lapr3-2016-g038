/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro Fernandes
 */
public class FlightPlanTest {
    
    public FlightPlanTest() {
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
     * Test of toString method, of class FlightPlan.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        FlightPlan instance = new FlightPlan();
        String expResult = instance.getFlightDesignator();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class FlightPlan.
     */
    @Test
    public void testEquals() {
        System.out.println("equals1");
        Object otherObject = new FlightPlan();
        FlightPlan instance = new FlightPlan();
        boolean expResult = true;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
        
        System.out.println("equals2");
        Object otherObject2 = new Pattern();
        FlightPlan instance2 = new FlightPlan();
        boolean expResult2 = false;
        boolean result2 = instance2.equals(otherObject2);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of hashCode method, of class FlightPlan.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        FlightPlan instance = new FlightPlan(new FlightPlan());
        int expResult = 3;
        expResult = expResult * 53 + Objects.hashCode(instance.getFlightDesignator());
        expResult = expResult * 53 + instance.getMinStopTime();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of validate method, of class FlightPlan.
     */
    @Test
    public void testValidate() {
        System.out.println("validate1");
        Aircraft a1 = new Aircraft("dsfsdg", "fdh", new CabinConfiguration(), 2, new AircraftModel(
                "id", "description", "maker", "passenger", new Motorization(), 10, 
                10, 10, 10, 10, 10, 10, 10, 10, 10, new LinkedList<>()));
        
        Airport air1 = new Airport("opo", "porto", "porto", "portugal", new Location(10, 10, 10));
        Airport air2 = new Airport("lis", "lisboa", "lisboa", "portugal", new Location(20, 20, 20));
        Airport air3 = new Airport("fcl", "funchal", "funchal", "portugal", new Location(30, 30, 30));
        
        FlightPlan instance = new FlightPlan("FF0001A", 10, a1, air1, air2,
                new LinkedList<>(), new LinkedList<>(),new LinkedList<>());
        boolean expResult = true;
        boolean result = instance.validate();
        assertEquals(expResult, result);
        
        System.out.println("validate2");
        FlightPlan instance2 = new FlightPlan("FF0001A", -1, a1, air1, air2,
                new LinkedList<>(), new LinkedList<>(),new LinkedList<>());
        boolean expResult2 = false;
        boolean result2 = instance2.validate();
        assertEquals(expResult2, result2);
        
        System.out.println("validate3");
        FlightPlan instance3 = new FlightPlan("FF0001A", 10, new Aircraft(), air1, air2,
                new LinkedList<>(), new LinkedList<>(),new LinkedList<>());
        boolean expResult3 = false;
        boolean result3 = instance3.validate();
        assertEquals(expResult3, result3);
        
        System.out.println("validate4");
        FlightPlan instance4 = new FlightPlan("FF0001A", 10, a1, air1, air1,
                new LinkedList<>(), new LinkedList<>(),new LinkedList<>());
        boolean expResult4 = false;
        boolean result4 = instance4.validate();
        assertEquals(expResult4, result4);
        
        Node n1 = new Node("node1", 10, 10);
        Node n2 = new Node("node1", 20, 20);
        Node n3 = new Node("node1", 30, 30);
        
        System.out.println("validate5");
        LinkedList<Airport> listairport = new LinkedList<>();
        listairport.add(air1);
        FlightPlan instance5 = new FlightPlan("FF0001A", 10, a1, air1, air2,
                listairport, new LinkedList<>(),new LinkedList<>());
        boolean expResult5 = false;
        boolean result5 = instance5.validate();
        assertEquals(expResult5, result5);
        
        System.out.println("validate6");
        LinkedList<Node> listnodes = new LinkedList<>();
        listnodes.add(n1);
        FlightPlan instance6 = new FlightPlan("FF0001A", 10, a1, air1, air2,
                new LinkedList<>(), listnodes,new LinkedList<>());
        boolean expResult6 = false;
        boolean result6 = instance6.validate();
        assertEquals(expResult6, result6);
        
        System.out.println("validate7");
        LinkedList<Airport> listairport2 = new LinkedList<>();
        listairport2.add(air3);
        LinkedList<Node> listnodes2 = new LinkedList<>();
        listnodes2.add(n1);
        FlightPlan instance7 = new FlightPlan("FF0001A", 10, a1, air1, air2,
                listairport2, listnodes2,new LinkedList<>());
        boolean expResult7 = false;
        boolean result7 = instance7.validate();
        assertEquals(expResult7, result7);
    }

    /**
     * Test of getFlightDesignator method, of class FlightPlan.
     */
    @Test
    public void testGetFlightDesignator() {
        System.out.println("getFlightDesignator");
        FlightPlan instance = new FlightPlan();
        String expResult = "FF0001A";
        String result = instance.getFlightDesignator();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFlightDesignator method, of class FlightPlan.
     */
    @Test
    public void testSetFlightDesignator() {
        System.out.println("setFlightDesignator");
        String flightDesignator = "srtrhxfbgc";
        FlightPlan instance = new FlightPlan();
        instance.setFlightDesignator(flightDesignator);

    }

    /**
     * Test of getMinStopTime method, of class FlightPlan.
     */
    @Test
    public void testGetMinStopTime() {
        System.out.println("getMinStopTime");
        FlightPlan instance = new FlightPlan();
        int expResult = 0;
        int result = instance.getMinStopTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMinStopTime method, of class FlightPlan.
     */
    @Test
    public void testSetMinStopTime() {
        System.out.println("setMinStopTime");
        int minStopTime = 10;
        FlightPlan instance = new FlightPlan();
        instance.setMinStopTime(minStopTime);
    }

    /**
     * Test of setAircraft method, of class FlightPlan.
     */
    @Test
    public void testSetAircraft() {
        System.out.println("setAircraft");
        Aircraft aircraft = new Aircraft();
        FlightPlan instance = new FlightPlan();
        instance.setAircraft(aircraft);
    }

    /**
     * Test of setOrigin method, of class FlightPlan.
     */
    @Test
    public void testSetOrigin() {
        System.out.println("setOrigin");
        Airport origin = new Airport();
        FlightPlan instance = new FlightPlan();
        instance.setOrigin(origin);
    }

    /**
     * Test of setDestination method, of class FlightPlan.
     */
    @Test
    public void testSetDestination() {
        System.out.println("setDestination");
        Airport destination = new Airport();
        FlightPlan instance = new FlightPlan();
        instance.setDestination(destination);
    }

    /**
     * Test of setTechnicalStops method, of class FlightPlan.
     */
    @Test
    public void testSetTechnicalStops() {
        System.out.println("setTechnicalStops");
        List<Airport> technicalStops =  new LinkedList<>();
        FlightPlan instance = new FlightPlan();
        instance.setTechnicalStops(technicalStops);
    }

    /**
     * Test of setMandatoryWaypoints method, of class FlightPlan.
     */
    @Test
    public void testSetMandatoryWaypoints() {
        System.out.println("setMandatoryWaypoints");
        List<Node> mandatoryWaypoints = new LinkedList<>();
        FlightPlan instance = new FlightPlan();
        instance.setMandatoryWaypoints(mandatoryWaypoints);
    }

    /**
     * Test of getAircraft method, of class FlightPlan.
     */
    @Test
    public void testGetAircraft() {
        System.out.println("getAircraft");
        FlightPlan instance = new FlightPlan();
        Aircraft expResult = new Aircraft();
        Aircraft result = instance.getAircraft();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOrigin method, of class FlightPlan.
     */
    @Test
    public void testGetOrigin() {
        System.out.println("getOrigin");
        FlightPlan instance = new FlightPlan();
        Airport expResult = new Airport();
        Airport result = instance.getOrigin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDestination method, of class FlightPlan.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        FlightPlan instance = new FlightPlan();
        Airport expResult = new Airport();
        Airport result = instance.getDestination();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTechnicalStops method, of class FlightPlan.
     */
    @Test
    public void testGetTechnicalStops() {
        System.out.println("getTechnicalStops");
        FlightPlan instance = new FlightPlan();
        List<Airport> expResult = new LinkedList<>();
        instance.setTechnicalStops(expResult);
        List<Airport> result = instance.getTechnicalStops();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMandatoryWaypoints method, of class FlightPlan.
     */
    @Test
    public void testGetMandatoryWaypoints() {
        System.out.println("getMandatoryWaypoints");
        FlightPlan instance = new FlightPlan();
        List<Node> expResult = new LinkedList<>();
        instance.setMandatoryWaypoints(expResult);
        List<Node> result = instance.getMandatoryWaypoints();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListPattern method, of class FlightPlan.
     */
    @Test
    public void testGetListPattern() {
        System.out.println("getListPattern");
        FlightPlan instance = new FlightPlan();
        List<Pattern> expResult = new LinkedList<>();
        instance.setListPattern(expResult);
        List<Pattern> result = instance.getListPattern();
        assertEquals(expResult, result);
    }

    /**
     * Test of setListPattern method, of class FlightPlan.
     */
    @Test
    public void testSetListPattern() {
        System.out.println("setListPattern");
        List<Pattern> listPattern = null;
        FlightPlan instance = new FlightPlan();
        instance.setListPattern(listPattern);
    }
    
}
