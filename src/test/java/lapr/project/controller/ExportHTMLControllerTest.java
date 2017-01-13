/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lapr.project.model.AirNetwork;
import lapr.project.model.FlightPlan;
import lapr.project.model.Project;
import lapr.project.model.analysis.Path;
import lapr.project.model.analysis.ShortestPathResult;
import lapr.project.model.analysis.Simulation;
import lapr.project.model.analysis.TypePath;
import lapr.project.model.lists.SimulationsList;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class ExportHTMLControllerTest {

    ExportHTMLController instance;
    Project p;

    public ExportHTMLControllerTest() {
        p = new Project();
        this.instance = new ExportHTMLController(p);

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
     * Test of getAvailableResults method, of class ExportHTMLController.
     */
    @Test
    public void testGetAvailableResults() {
        System.out.println("getAvailableResults");
        String sim = "1";
        ExportHTMLController instance = this.instance;
        ShortestPathResult sp = new ShortestPathResult(new FlightPlan());
        sp.calculateBestPath(new AirNetwork());
        Simulation simu = new Simulation();
        simu.setShortestResultPath(sp);
        p.getSimulationsList().getSimulationsList().add(simu);
        Map<String, Path> expResult = new HashMap<>();
        expResult.put("Best consumption", p.getSimulationsList().getSimulationsList().getFirst().getEcologicResultPath());
        expResult.put("Fastest path", p.getSimulationsList().getSimulationsList().getFirst().getFastestResultPath());
        expResult.put("ShortestPath", p.getSimulationsList().getSimulationsList().getFirst().getShortestResultPath());
        Map<String, Path> result = instance.getAvailableResults(sim);
        assertEquals(expResult, result);

    }

    /**
     * Test of getSimulationsList method, of class ExportHTMLController.
     */
    @Test
    public void testGetSimulationsList() {
        System.out.println("getSimulationsList");
    
        List<String> simString = new LinkedList<>();
        List<Simulation> simlist = new LinkedList();
        Simulation sim = new Simulation();
        sim.createPathSimulation(TypePath.ALL);
        simlist.add(sim);
     
            p.getSimulationsList().getSimulationsList().add(sim);
         this.instance = new ExportHTMLController(p);
        simString.add(sim.toString());
        List<String> result = instance.getSimulationsList();
        assertEquals(simString, result);

    }

//    /**
//     * Test of getFlightPathAnalisysResultsGroupedByOriginDestination method, of
//     * class ExportHTMLController.
//     */
//    @Test
//    public void testGetFlightPathAnalisysResultsGroupedByOriginDestination() {
//        System.out.println("getFlightPathAnalisysResultsGroupedByOriginDestination");
//        String startNode = "";
//        String endNode = "";
//        ExportHTMLController instance = null;
//        List<String> expResult = null;
//        List<String> result = instance.getFlightPathAnalisysResultsGroupedByOriginDestination(startNode, endNode);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFlightPathAnalisysResultsGroupedByAircraftType method, of
//     * class ExportHTMLController.
//     */
//    @Test
//    public void testGetFlightPathAnalisysResultsGroupedByAircraftType() {
//        System.out.println("getFlightPathAnalisysResultsGroupedByAircraftType");
//        String aircrafType = "";
//        ExportHTMLController instance = null;
//        List<String> expResult = null;
//        List<String> result = instance.getFlightPathAnalisysResultsGroupedByAircraftType(aircrafType);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getListOfAircraftTypes method, of class ExportHTMLController.
//     */
//    @Test
//    public void testGetListOfAircraftTypes() {
//        System.out.println("getListOfAircraftTypes");
//        ExportHTMLController instance = null;
//        List<String> expResult = null;
//        List<String> result = instance.getListOfAircraftTypes();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getListOfNodes method, of class ExportHTMLController.
//     */
//    @Test
//    public void testGetListOfNodes() {
//        System.out.println("getListOfNodes");
//        ExportHTMLController instance = null;
//        List<String> expResult = null;
//        List<String> result = instance.getListOfNodes();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of exportResult method, of class ExportHTMLController.
//     */
//    @Test
//    public void testExportResult() {
//        System.out.println("exportResult");
//        Simulation s = null;
//        String filePath = "";
//        ExportHTMLController instance = null;
//        boolean expResult = false;
//        boolean result = instance.exportResult(s, filePath);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of exportResults method, of class ExportHTMLController.
//     */
//    @Test
//    public void testExportResults() {
//        System.out.println("exportResults");
//        String[] s = null;
//        String filePath = "";
//        String whatToExport = "";
//        ExportHTMLController instance = null;
//        boolean expResult = false;
//        boolean result = instance.exportResults(s, filePath, whatToExport);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
