package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//math: voltage divided by 2 for every 10 mm//
/**
 * sonar sensing stuff
 */


public class Sonar extends Subsystem {
	AnalogInput sonar;
	private Sonar(){
		sonar = new AnalogInput(RobotMap.sonar);//analog input object
	}
	
	public double distance;

	public double getdistance(){
		double volts = sonar.getVoltage(); //gets the voltage
		distance = volts/2; //divides the value given by volts by two
		return distance;
	}
	public void distance() {
		SmartDashboard.putNumber("Distance in cm", distance);
	}
	//get the channel and voltage from here
	protected void initDefaultCommand() { 
	}
	private static Sonar instance;
	
	public static Sonar getInstance(){
		if (instance == null)
			instance = new Sonar();
		return instance;
	}
}
//send the distance to the driver station
