/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.LinkedList;
import lapr.project.model.Node;
import lapr.project.model.Project;
import lapr.project.model.anaylsis.ShortestPathResult;
import lapr.project.model.lists.NodeList;
import lapr.project.model.mapgraph.GraphAlgorithms;

/**
 * Controller to find shortest path between two airports
 * @author Diana Silva
 */
public class FindShortestController {
    
    ShortestPathResult result;
    
    public void newResult(Node startNode){
       result=Project.getListResults().newShortestResult(startNode);
    }
    
    public Node[] getVertices(){
        return Project.getAirNetwork().getAirNetwork().allkeyVerts();
    }
    
    public NodeList getPossibleEndNodes(Node startNode){
        return Project.getAirNetwork().getPossibleEndNodes(startNode);
    }
    
    public void setEndNode(Node endNode){
        result.setEndNode(endNode);
    }
    
    public double calculateShortestPath(Node startNode, Node endNode, LinkedList<Node> shortPath){
        double shortestPath = GraphAlgorithms.shortestPath(Project.getAirNetwork().getAirNetwork(), startNode, endNode, shortPath);
        result.setResult(shortestPath);
        return shortestPath;
    }
  
    public boolean saveResult(){
        return Project.getListResults().getShortesPathResultsList().add(result);
    }
    
}
