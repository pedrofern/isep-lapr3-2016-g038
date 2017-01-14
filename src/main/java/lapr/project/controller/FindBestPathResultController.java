/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.analysis.SegmentResult;
import lapr.project.model.analysis.Simulation;
import lapr.project.model.analysis.TypePath;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class FindBestPathResultController {

    private Simulation simulation;
    private String nodeID;
    private String endNodeID;
    double tas_0;

    private double tas;
    private double initAltitude;
    private double finalAlt;
    private double fuelConsumption;
    private double distance;
    private double flightTime;

    public FindBestPathResultController(Simulation simulation) {
        this.simulation = simulation;
    }

    /**
     * Gets segment result info.
     * @param segID  the seg result id
     */
    public void getSegmentInformation(String segID) {
        List<SegmentResult> resultsList = getSegmentsList(TypePath.ALL);
        SegmentResult seg = null;
        SegmentResult prevSeg = null;
        for (int i = 0; i < resultsList.size(); i++) {
            if (resultsList.get(i).getSegment().getId().equals(segID)) {
                seg = resultsList.get(i);
                if (i != 0) {
                    prevSeg = resultsList.get(i - 1);
                }
            }
            nodeID = seg.getSegment().getStartNode().getId();
            endNodeID = seg.getSegment().getEndNode().getId();
            tas = seg.getTas();
            tas_0 = seg.getTas() - prevSeg.getTas();
            initAltitude = seg.getInitialAltitude();
            finalAlt = seg.getAltitudeFinal();
            fuelConsumption = seg.getEnergyConsume();
            distance = seg.getDistance();
            flightTime = seg.getFlightTime();

        }
    }

    public Simulation getSimulation() {
        return simulation;
    }

    public String getNodeID() {
        return nodeID;
    }

    public String getEndNodeID() {
        return endNodeID;
    }

    public double getTas() {
        return tas;
    }

    public double getInitAltitude() {
        return initAltitude;
    }

    public double getFinalAlt() {
        return finalAlt;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getDistance() {
        return distance;
    }

    public double getFlightTime() {
        return flightTime;
    }

    /**
     * Gets the list of segments of a type path.
     * @param type the type path
     * @return  the list of segment results
     */
    public List<SegmentResult> getSegmentsList(TypePath type) {

        return this.simulation.getResult(type).getSegments();
    }
}