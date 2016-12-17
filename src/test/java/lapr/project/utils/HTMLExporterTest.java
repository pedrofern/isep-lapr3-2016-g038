/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class HTMLExporterTest {
    
    public HTMLExporterTest() {
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
     * Test of exportStringsToHTML method, of class HTMLExporter.
     */
    @Test
    public void testExportStringsToHTML() throws FileNotFoundException {
         System.out.println("exportStringsToCSV");
        String title = "title";
        String heading1 = "h1";
        String heading2 = "h2";
        String[] body = new String[2];
        body[0]="body0";
        body[1]= "body1";
        String filePath = "src/main/resources/exportfilesfortest/testHTML.html";
        
         HTMLExporter.exportStringsToHTML(title, heading1, heading2, body, filePath);
         Scanner scan = new Scanner (new File("src/main/resources/exportfilesfortest/testHTML.html"));
         boolean result=false;
         while(scan.hasNext())
         {
           String test= scan.next();
             result= test.contains(title) ||   test.contains(heading1) ||  test.contains(heading2) || test.contains(body[0]) ||  test.contains(body[1]) ||  test.contains("\n")|| test.contains("<")  ;
         }
         Assert.assertTrue(result);
    }
    
}
