package lapr.project.model.lists;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import lapr.project.model.FlightPlan;

/**
 *
 * @author Flavio Relvas
 */
public class FlightList implements Serializable {

    /**
     * List of existing Flights
     */
    private List<FlightPlan> flightList;

    public FlightList() {
        flightList = new LinkedList<>();
    }

    public FlightList(List<FlightPlan> flightList) {
        this.flightList = flightList;
    }

    public FlightList(FlightList flightList) {
        this.flightList = flightList.flightList;
    }

    public FlightPlan newFlight() {
        return new FlightPlan();
    }

    public boolean validate(FlightPlan flight) {
        if (flight == null) {
            return false;
        }

        for (FlightPlan f : getFlightList()) {
            if (flight.equals(f)) {
                return false;
            }
        }
        return true;
    }

    private void add(FlightPlan flight) {
        getFlightList().add(flight);
    }

    public boolean saveFlight(FlightPlan flight) {
        if (validate(flight) && !flightList.contains(flight)) {
            add(flight);
            return true;
        }
        return false;
    }

    /**
     * @return the flightList
     */
    public List<FlightPlan> getFlightList() {
        return flightList;
    }

    /**
     * @param flightList the flightList to set
     */
    public void setFlightList(List<FlightPlan> flightList) {
        this.flightList = flightList;
    }
}
