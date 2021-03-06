/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.analysis.Path;
import lapr.project.model.analysis.Simulation;
import lapr.project.model.lists.AircraftList;
import lapr.project.model.lists.AircraftModelList;
import lapr.project.model.lists.AirportList;
import lapr.project.model.lists.CompareResultsList;
import lapr.project.model.lists.FlightList;
import lapr.project.model.lists.SimulationsList;
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
public class ProjectTest {

    public ProjectTest() {
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
     * Test of getAircraftList method, of class Project.
     */
    @Test
    public void testGetAircraftList() {
        System.out.println("getAircraftList");
        Project instance2 = new Project();
        Project instance = new Project(instance2);
        AircraftList expResult = new AircraftList();
        instance.setAircraftList(expResult);
        AircraftList result = instance.getAircraftList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAircraftList method, of class Project.
     */
    @Test
    public void testSetAircraftList() {
        System.out.println("setAircraftList");
        AircraftList aircraftList = new AircraftList();
        Project instance = new Project(99, "teste", "teste", new AircraftList(),
                new AirNetwork(), new AirportList(), new CompareResultsList(), new FlightList(),
                new AircraftModelList(), new SimulationsList());
        instance.setAircraftList(aircraftList);
    }

    /**
     * Test of getAirNetwork method, of class Project.
     */
    @Test
    public void testGetAirNetwork() {
        System.out.println("getAirNetwork");
        Project instance = new Project();
        AirNetwork expResult = new AirNetwork();
        instance.setAirNetwork(expResult);
        AirNetwork result = instance.getAirNetwork();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAirNetwork method, of class Project.
     */
    @Test
    public void testSetNetwork() {
        System.out.println("setNetwork");
        AirNetwork network = new AirNetwork();
        Project instance = new Project();
        instance.setAirNetwork(network);
    }

    /**
     * Test of getAirportList method, of class Project.
     */
    @Test
    public void testGetAirportList() {
        System.out.println("getAirportList");
        Project instance = new Project();
        AirportList expResult = new AirportList();
        instance.setAirportList(expResult);
        AirportList result = instance.getAirportList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAirportList method, of class Project.
     */
    @Test
    public void testSetAirportList() {
        System.out.println("setAirportList");
        AirportList airportList = new AirportList();
        Project instance = new Project();
        instance.setAirportList(airportList);
    }

    /**
     * Test of getCompareList method, of class Project.
     */
    @Test
    public void testGetCompareList() {
        System.out.println("getCompareList");
        Project instance = new Project();
        CompareResultsList expResult = new CompareResultsList();
        instance.setCompareList(expResult);
        CompareResultsList result = instance.getCompareList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCompareList method, of class Project.
     */
    @Test
    public void testSetCompareList() {
        System.out.println("setCompareList");
        CompareResultsList compareList = new CompareResultsList();
        Project instance = new Project();
        instance.setCompareList(compareList);
    }

    /**
     * Test of getAircraftModelList method, of class Project.
     */
    @Test
    public void testGetAircraftModelList() {
        System.out.println("getAircraftModelList");
        Project instance = new Project();
        AircraftModelList expResult = new AircraftModelList();
        instance.setAircraftModelList(expResult);
        AircraftModelList result = instance.getAircraftModelList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAircraftModelList method, of class Project.
     */
    @Test
    public void testSetModelList() {
        System.out.println("setModelList");
        AircraftModelList modelList = new AircraftModelList();
        Project instance = new Project();
        instance.setAircraftModelList(modelList);
    }

    /**
     * Test of getSimulationsList method, of class Project.
     */
    @Test
    public void testGetSimulationsList() {
        System.out.println("getSimulationsList");
        Project instance = new Project();
        SimulationsList expResult = new SimulationsList();
        instance.setSimulationsList(expResult);
        SimulationsList result = instance.getSimulationsList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSimulationsList method, of class Project.
     */
    @Test
    public void testSetSimulationsList() {
        System.out.println("setSimulationsList");
        SimulationsList simulationsList = new SimulationsList();
        Project instance = new Project();
        instance.setSimulationsList(simulationsList);
    }

    /**
     * Test of getIdProject method, of class Project.
     */
    @Test
    public void testGetIdProject() {
        System.out.println("getIdProject");
        Project instance = new Project();
        int expResult = 0;
        int result = instance.getIdProject();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdProject method, of class Project.
     */
    @Test
    public void testSetIdProject() {
        System.out.println("setIdProject");
        int idProject = 1;
        Project instance = new Project();
        instance.setIdProject(idProject);
    }

    /**
     * Test of getName method, of class Project.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Project instance = new Project();
        String expResult = "NO_NAME_PROJECT";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Project.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "abc";
        Project instance = new Project();
        instance.setName(name);
    }

    /**
     * Test of getDescription method, of class Project.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Project instance = new Project();
        String expResult = "NO_DESCRIPTION";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Project.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "abc";
        Project instance = new Project();
        instance.setDescription(description);

    }

    /**
     * Test of getEcologicPathResults method, of class Project.
     */
    @Test
    public void testGetEcologicPathResults() {
        System.out.println("getEcologicPathResults");
        Project instance = new Project();
        List<Path> expResult = new LinkedList<>();
        instance.getSimulationsList().getSimulationsList().stream().forEach((s) -> {
            expResult.add(s.getEcologicResultPath());
        });
        List<Path> result = instance.getEcologicPathResults();
        assertEquals(expResult, result);
    }

    /**
     * Test of getShortestPathResults method, of class Project.
     */
    @Test
    public void testGetShortestPathResults() {
        System.out.println("getShortestPathResults");
        Project instance = new Project();
        List<Path> expResult = new LinkedList<>();
        instance.getSimulationsList().getSimulationsList().stream().forEach((s) -> {
            expResult.add(s.getEcologicResultPath());
        });
        List<Path> result = instance.getShortestPathResults();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFastestPathResults method, of class Project.
     */
    @Test
    public void testGetFastestPathResults() {
        System.out.println("getFastestPathResults");
        Project instance = new Project();
        List<Path> expResult = new LinkedList<>();
        instance.getSimulationsList().getSimulationsList().stream().forEach((s) -> {
            expResult.add(s.getEcologicResultPath());
        });
        List<Path> result = instance.getFastestPathResults();
        assertEquals(expResult, result);
    }

    /**
     * Test of validate method, of class Project.
     */
    @Test
    public void testValidate() {
        System.out.println("validate1");
        String name = "";
        String desc = "descr";
        Project instance = new Project();
        instance.setName(name);
        instance.setDescription(desc);
        boolean expResult = false;
        boolean result = instance.validate();
        assertEquals(expResult, result);

        System.out.println("validate2");
        String name2 = "abc";
        String desc2 = "";
        Project instance2 = new Project();
        instance2.setName(name2);
        instance2.setDescription(desc2);
        boolean expResult2 = false;
        boolean result2 = instance2.validate();
        assertEquals(expResult2, result2);

        System.out.println("validate3");
        String name3 = "abc";
        String desc3 = "descr";
        Project instance3 = new Project();
        instance3.setName(name3);
        instance3.setDescription(desc3);
        boolean expResult3 = true;
        boolean result3 = instance3.validate();
        assertEquals(expResult3, result3);
    }

    /**
     * Test of toString method, of class Project.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Project instance = new Project();
        String expResult = instance.getName();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPossibleEndAirports method, of class Project.
     */
    @Test
    public void testGetPossibleEndAirports() {
        System.out.println("getPossibleEndAirports");

        Project instance = new Project();
        Node startNode = new Node("test1", 40, 40);
        Node intNode = new Node("test2", 50, 70);
        Node endNode = new Node("test3", 40, 80);

        Wind windTest = new Wind(10, 10);
        String direction = "BIDIRECTIONAL";
        Segment segment1=new Segment("segmentTest1",startNode, endNode, direction,windTest,0,0);       
        Segment segment2=new Segment("segmentTest2", startNode, intNode, direction,windTest,0,0);
        Segment segment3=new Segment("segmentTest3", intNode, endNode, direction, windTest,0,0);

        AirNetwork airnetwork = instance.getAirNetwork();
        airnetwork.getAirNetwork().insertVertex(startNode);
        airnetwork.getAirNetwork().insertVertex(intNode);
        airnetwork.getAirNetwork().insertVertex(endNode);

        airnetwork.getAirNetwork().insertEdge(startNode, intNode, segment2, 10);
        airnetwork.getAirNetwork().insertEdge(intNode, endNode, segment3, 30);
        airnetwork.getAirNetwork().insertEdge(startNode, endNode, segment1, 20);

        Airport airport1 = new Airport("1", "", "", "", new Location(40, 40, 10));
        Airport airport2 = new Airport("2", "", "", "", new Location(50, 70, 10));
        Airport airport3 = new Airport("3", "", "", "", new Location(40, 80, 10));

        AirportList airportsList = instance.getAirportList();
        airportsList.getAirportList().add(airport1);
        airportsList.getAirportList().add(airport2);
        airportsList.getAirportList().add(airport3);

        LinkedList<Airport> result = new LinkedList<>();
        result.add(airport2);
        result.add(airport3);
        assertEquals(result, instance.getPossibleEndAirports(startNode));
    }

    /**
     * Test of setAirNetwork method, of class Project.
     */
    @Test
    public void testSetAirNetwork() {
        System.out.println("setAirNetwork");
        AirNetwork expResult = new AirNetwork();
        Project instance = new Project();
        instance.setAirNetwork(expResult);
        assertEquals(expResult, instance.getAirNetwork());
    }

    /**
     * Test of setAircraftModelList method, of class Project.
     */
    @Test
    public void testSetAircraftModelList() {
        System.out.println("setAircraftModelList");
        AircraftModelList expResult = new AircraftModelList();
        expResult.getModelList().add(new AircraftModel());
        Project instance = new Project();
        instance.setAircraftModelList(expResult);
        assertEquals(expResult, instance.getAircraftModelList());
    }

    /**
     * Test of getPossibleEndNodes method, of class Project.
     */
    @Test
    public void testGetPossibleEndNodes() {
        System.out.println("getPossibleEndNodes");
        Project instance = new Project();
        
        Node startNode = new Node("test1", 40, 40);
        Node intNode = new Node("test2", 50, 70);
        Node endNode = new Node("test3", 40, 80);

        Wind windTest = new Wind(10, 10);
        String direction = "BIDIRECTIONAL";
        Segment segment1=new Segment("segmentTest1",startNode, endNode, direction,windTest,0,0);       
        Segment segment2=new Segment("segmentTest2", startNode, intNode, direction,windTest,0,0);
        Segment segment3=new Segment("segmentTest3", intNode, endNode, direction, windTest,0,0);

        AirNetwork airnetwork = instance.getAirNetwork();
        airnetwork.getAirNetwork().insertVertex(startNode);
        airnetwork.getAirNetwork().insertVertex(intNode);
        airnetwork.getAirNetwork().insertVertex(endNode);

        airnetwork.getAirNetwork().insertEdge(startNode, intNode, segment2, 10);
        airnetwork.getAirNetwork().insertEdge(intNode, endNode, segment3, 30);
        airnetwork.getAirNetwork().insertEdge(startNode, endNode, segment1, 20);
        
        List<Node> expResult = new LinkedList<>();
        expResult.add(intNode);
        expResult.add(endNode);
        List<Node> result = instance.getPossibleEndNodes(startNode);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFlightList method, of class Project.
     */
    @Test
    public void testGetFlightList() {
        System.out.println("getFlightList");
        Project instance = new Project();
        FlightList expResult = new FlightList();
        instance.setFlightList(expResult);
        FlightList result = instance.getFlightList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFlightList method, of class Project.
     */
    @Test
    public void testSetFlightList() {
        System.out.println("setFlightList");
        FlightList flightList = new FlightList();
        Project instance = new Project();
        instance.setFlightList(flightList);
    }

    /**
     * Test of getModelList method, of class Project.
     */
    @Test
    public void testGetModelList() {
        System.out.println("getModelList");
        Project instance = new Project();
        AircraftModelList expResult = new AircraftModelList();
        instance.setModelList(expResult);
        AircraftModelList result = instance.getModelList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSimulationsAircraft method, of class Project.
     */
    @Test
    public void testGetSimulationsAircraft() {
        System.out.println("getSimulationsAircraft");
        String type = "";
        Project instance = new Project();
        List<Simulation> expResult = new LinkedList<>(); 
        List<Simulation> sims = instance.getSimulationsList().getSimulationsList();
        for (Simulation s : sims) {
            if (s.getFlightPlan().getAircraft().getAircraftModel().getType().equals(type)) {
                expResult.add(s);
            }
        }
        List<Simulation> result = instance.getSimulationsAircraft(type);
        assertEquals(expResult, result);
    }

    /**
     * Test of getTypesAircraftSimulated method, of class Project.
     */
    @Test
    public void testGetTypesAircraftSimulated() {
        System.out.println("getTypesAircraftSimulated");
        Project instance = new Project();
        List<String> expResult = new LinkedList<>();
        List<Simulation> sims = instance.getSimulationsList().getSimulationsList();
        for (Simulation s : sims) {
            String a = s.getFlightPlan().getAircraft().getAircraftModel().getType();
            if (!expResult.contains(a)) {
                expResult.add(a);
            }
        }
        List<String> result = instance.getTypesAircraftSimulated();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Project.
     */
    @Test
    public void testCompareTo() {
        Project test = new Project();
        test.setIdProject(2);
        
        System.out.println("compareTo1");
        Object t = new Project();
        Project instance = new Project();
        int expResult = 0;
        int result = instance.compareTo(t);
        assertEquals(expResult, result);
        
        System.out.println("compareTo2");
        Object t2 = new Project();
        Project instance2 = new Project(test);
        int expResult2 = 1;
        int result2 = instance2.compareTo(t2);
        assertEquals(expResult2, result2);
        
        System.out.println("compareTo3");
        
        Object t3 = new Project(test);
        Project instance3 = new Project();
        int expResult3 = -1;
        int result3 = instance3.compareTo(t3);
        assertEquals(expResult3, result3);

    }

    /**
     * Test of equals method, of class Project.
     */
    @Test
    public void testEquals() {
        System.out.println("equals1");
        Object otherObject = null;
        Project instance = new Project();
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
        
        System.out.println("equals2");
        Object otherObject2 = new Project();
        Project instance2 = new Project();
        boolean expResult2 = true;
        boolean result2 = instance2.equals(otherObject2);
        assertEquals(expResult2, result2);
        
        System.out.println("equals3");
        Object otherObject3 = new Project();
        Project instance3 = new Project();
        instance3.setName("abc");
        boolean expResult3 = false;
        boolean result3 = instance3.equals(otherObject3);
        assertEquals(expResult3, result3);
    }
}
