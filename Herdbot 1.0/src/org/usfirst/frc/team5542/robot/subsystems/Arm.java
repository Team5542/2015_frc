package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;
import org.usfirst.frc.team5542.robot.commands.UserArm;



import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *arm motor stuff and arm micro
 */
public class Arm extends PIDSubsystem {
    private CANTalon leftMotor;
    private CANTalon rightMotor;
	//private DigitalInput armMicro1 = new DigitalInput(RobotMap.armMicro1);
	//private DigitalInput armMicro2 = new DigitalInput(RobotMap.armMicro2);
	//private DigitalInput infrared;
	private Counter leftHall = new Counter(RobotMap.leftHall);
	private Counter rightHall = new Counter(RobotMap.rightHall);
	//sets up motors and potentiometer
	
	private static double base, lift, place;//constants for each possible
	private static double dpp;
	
	private static final double kp = 1, ki = 0, kd = 0;
    public Arm() {
    	super(kp, ki, kd);
    	leftHall.setDistancePerPulse(dpp);
    	rightHall.setDistancePerPulse(dpp);
    	// Use these to get going:
    	// setSetpoint() -  Sets where the PID controller should move the system to
    	// enable() - Enables the PID controller.
    	setSetpoint(base);
    	enable();
    }
   
	

    public static Arm instance;
    	
    public static Arm getInstance(){
    	if (instance == null)
    		instance = new Arm();
    	return instance;
    }
    
    /*public boolean isInRange(){
    	return infrared.get();
    }*/
    
    public boolean isTouching(){
    	//return (armMicro1.get() && armMicro2.get());
    	return false;
    }
    
    public double compareHalls(){
    	return leftHall.getDistance() - rightHall.getDistance();
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return (leftHall.getDistance() + rightHall.getDistance()) / 2;
    }
    
    protected void usePIDOutput(double output) {
    	if (output > 0){
    		if (compareHalls() > 0){
    			leftMotor.set(0);
    			rightMotor.set(output);
    		}
    		else if (compareHalls() < 0){
    			leftMotor.set(output);
    			rightMotor.set(0);
    		}
    	}
    	else if (output < 0){
    		if (compareHalls() > 0){
    			leftMotor.set(output);
    			rightMotor.set(0);
    		}
    		else if (compareHalls() < 0){
    			leftMotor.set(0);
    			rightMotor.set(output);
    		}
    	}
    	else{
			leftMotor.set(output);
			rightMotor.set(output);
		}
    }

    public void setBase(){
    	setSetpoint(base);
    }
    public void setLift(){
    	setSetpoint(lift);
    }
    public void setPlace(){
    	setSetpoint(place);
    }
    
    
    public void initDefaultCommand() {
        setDefaultCommand(new UserArm());
    }
}
