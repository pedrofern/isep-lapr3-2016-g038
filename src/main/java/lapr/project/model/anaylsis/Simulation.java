/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import lapr.project.model.Aircraft;
import lapr.project.model.Node;
import lapr.project.model.physics.AircraftAlgorithms;

/**
 *
 * @author Diana Silva
 */
public class Simulation{
    /**
     * number of passengers and members crew of simulation flight
     */
    private int passengers, crew;
    /**
     * cargoLoad of simulation flight
     */
    private double cargoLoad;
    
    /**
     * Fuel loaded in aircraft (g)
     */
    private double fuelWeight;
    
    /**
     * total weight (g)
     */
    private double totalWeight;
    
    /**
     * aircraft of simulation flight
     */
    private Aircraft aircraft;
    /**
     * result of the most ecological path
     */
    private EcologicPathResult ecologicResultPath;
    /**
     * result of the fastest path
     */
    private FastestPathResult fastestResultPath;
    /**
     * result of the shortest path
     */
    private ShortestPathResult shortestResultPath;
    /**
     * default value
     */
    private static final double DEFAULT_VALUE=0;
    /**
     * the origin of flight simlation
     */
    private Node startNode;
    /**
     * destination of flight simulation
     */
    private Node endNode;
    
    /**
     * constructor
     */
    public Simulation(){
        this.passengers=(int) DEFAULT_VALUE;
        this.crew=(int) DEFAULT_VALUE;
        this.cargoLoad=DEFAULT_VALUE;
        this.totalWeight=DEFAULT_VALUE;
        this.fuelWeight=DEFAULT_VALUE;
        this.aircraft=new Aircraft();  
        this.startNode = new Node();
        this.endNode = new Node();
        this.ecologicResultPath=new EcologicPathResult();
        this.fastestResultPath = new FastestPathResult();
        this.shortestResultPath = new ShortestPathResult();
    }

    /** Gets the number of passengers
     * @return the passengers
     */
    public int getPassengers() {
        return passengers;
    }

    /**
     * Sets the number of passengers
     * @param passengers the passengers to set
     */
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    /**
     * Get the number of cabine crew members
     * @return the crew
     */
    public int getCrew() {
        return crew;
    }

    /**
     * Sets the number of cabine crew members
     * @param crew the crew to set
     */
    public void setCrew(int crew) {
        this.crew = crew;
    }

    /**
     * Gets the cargo load
     * @return the cargoLoad
     */
    public double getCargoLoad() {
        return cargoLoad;
    }

    /**
     * Sets the cargo load
     * @param cargoLoad the cargoLoad to set
     */
    public void setCargoLoad(double cargoLoad) {
        this.cargoLoad = cargoLoad;
    }

    /**
     * Gets the aircraft of flight
     * @return the aircraft
     */
    public Aircraft getAircraft() {
        return aircraft;
    }

    /**
     * Sets the aircraft of flight
     * @param aircraft the aircraft to set
     */
    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    /**
     * @return the totalWeight
     */
    public double getTotalWeight() {
        return totalWeight;
    }

    /**
     * @param totalWeight the totalWeight to set
     */
    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    /**
     * @return the ecologicResultPath
     */
    public EcologicPathResult getEcologicResultPath() {
        return ecologicResultPath;
    }

    /**
     * @param ecologicResultPath the ecologicResultPath to set
     */
    public void setEcologicResultPath(EcologicPathResult ecologicResultPath) {
        this.ecologicResultPath = ecologicResultPath;
    }

    /**
     * @return the fastestResultPath
     */
    public FastestPathResult getFastestResultPath() {
        return fastestResultPath;
    }

    /**
     * @param fastestResultPath the fastestResultPath to set
     */
    public void setFastestResultPath(FastestPathResult fastestResultPath) {
        this.fastestResultPath = fastestResultPath;
    }

    /**
     * @return the shortestResultPath
     */
    public ShortestPathResult getShortestResultPath() {
        return shortestResultPath;
    }

    /**
     * @param shortestResultPath the shortestResultPath to set
     */
    public void setShortestResultPath(ShortestPathResult shortestResultPath) {
        this.shortestResultPath = shortestResultPath;
    }
    
    public Node getStartNode() {
        return startNode;
    }

    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    public Node getEndNode() {
        return endNode;
    }

    public void setEndNode(Node endNode) {
        this.endNode = endNode;
    }
    
    public void setData(Aircraft aircraft, int passengers, int crew, double cargoLoad){
        this.aircraft=aircraft;
        this.passengers=passengers;
        this.crew=crew;
        this.cargoLoad=cargoLoad;
        this.totalWeight=calculateTotalWeight();
    }

    public boolean validate() {
        boolean v1=this.passengers<=aircraft.getCabinConfig().getTotalSeats() &&
                this.crew<=aircraft.getNrOfCrewElements() && 
                this.fuelWeight<=aircraft.getAircraftModel().getFuelCapacity()
                && Double.doubleToLongBits(totalWeight)<=aircraft.getAircraftModel().getMTOW() &&
                this.aircraft!=null;
        boolean v2= aircraft.validate();
        boolean v3= ecologicResultPath.validate() || fastestResultPath.validate() 
                || shortestResultPath.validate();
        
        return v1 && v2 && v3;
    }

    private double calculateTotalWeight(){
       return AircraftAlgorithms.calculateInitialWeight(passengers, crew,
               cargoLoad, getFuelWeight(), aircraft.getAircraftModel().geteWeight());
    
    }
    
    @Override
    public String toString()
    {
        return "Simulation";
    }

    /**
     * @return the fuelWeight
     */
    public double getFuelWeight() {
        return fuelWeight;
    }

    /**
     * @param fuelWeight the fuelWeight to set
     */
    public void setFuelWeight(double fuelWeight) {
        this.fuelWeight = fuelWeight;
    }
}
