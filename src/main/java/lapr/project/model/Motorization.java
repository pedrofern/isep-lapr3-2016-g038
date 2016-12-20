/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Class that represents the motorization of aircraft
 * @author Diana Silva
 */
@XmlRootElement(name="motorization")
@XmlAccessorType(XmlAccessType.FIELD)
public class Motorization {
    /**
     * number of motors
     */
    @XmlElement(name="number_motors")
    private int number_motors;
    
    /**
     * motor code (ex: GE CF6-80C2B1F
     */
    @XmlElement(name="motor")
    private String motor;
    
    /**
     * motor type (Ex: turbofan)
     */
    @XmlElement(name="motor_type")
    private String motor_type;
    @XmlElementWrapper(name="regime_list")
    @XmlElement(name="regime")
    private List<Regime> regimeList;
    @XmlTransient
    private Regime regime;
    @XmlTransient
    private static final int DEFAULT_NUMBER_MOTORS = 0;
    @XmlTransient
    private static final String DEFAULT_MOTOR = "NOMOTOR";
    @XmlTransient
    private static final String DEFAULT_MOTOR_TYPE = "NOMOTORTYPE";
    
    public Motorization(){
        this.number_motors=DEFAULT_NUMBER_MOTORS;
        this.motor=DEFAULT_MOTOR;
        this.motor_type=DEFAULT_MOTOR_TYPE;
        this.regimeList=new LinkedList<>();
    }
    
    public Motorization(int number_motors, String motor, String motor_type,
            List<Regime> regimeList){
        this.number_motors=number_motors;
        this.motor=motor;
        this.motor_type=motor_type;
        this.regimeList=new LinkedList<>();
    }

    /**
     * @return the number_motors
     */
    public int getNumber_motors() {
        return number_motors;
    }

    /**
     * @param number_motors the number_motors to set
     */
    public void setNumber_motors(int number_motors) {
        this.number_motors = number_motors;
    }

    /**
     * @return the motor
     */
    public String getMotor() {
        return motor;
    }

    /**
     * @param motor the motor to set
     */
    public void setMotor(String motor) {
        this.motor = motor;
    }

    /**
     * @return the motor_type
     */
    public String getMotor_type() {
        return motor_type;
    }

    /**
     * @param motor_type the motor_type to set
     */
    public void setMotor_type(String motor_type) {
        this.motor_type = motor_type;
    }

    
//********************** regime list ***************************************
    /**
     * @return the regimeList
     */
    public List<Regime> getRegimeList() {
        return regimeList;
    }

    /**
     * @param regimeList the regimeList to set
     */
    public void setRegimeList(List<Regime> regimeList) {
        this.regimeList = regimeList;
    }
    
    /**
     * create Regime 
     */
    public void setRegime(double TSFC, double speed, double thrust, long altitude){
        regime = new Regime();
        regime.setAltitude(altitude);
        regime.setSpeed(speed);
        regime.setTSFC(TSFC);
        regime.setThrust(thrust);
    }
    
    /**
     * validate and saves the regime into regimeList
     * @param regime
     * @return true if regiem is valid and it´s added, false if not
     */
    public boolean saveRegime(Regime regime){
        if(validate(regime)){
            addRegime(regime);
            return true;
        }
        return false;       
    }
    
    /**
     * validate if regime is valid and do not exist in the list
     * @param regime regime
     * @return true if regime is valid and do not exist in the list, false if not
     */
    public boolean validate(Regime regime){
        return regime.validate() && !regimeList.contains(regime);
    }
    
    /**
     * add the regime into the list
     * @return true if regime is added, false if not
     */
    private boolean addRegime(Regime regime){
        return regimeList.add(regime);
    }
// ************************* end regime list ***********************************
    /**
     * 
     * @return 
     */
    public boolean validate(){ 
        boolean v1 = !this.motor.isEmpty()
                && !this.motor_type.isEmpty()
                && this.number_motors!=0
                && !this.regimeList.isEmpty(); 
        return v1;
    }
}
