package org.usfirst.frc.team5542.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//math: voltage divided by 2 for every 10 mm//
/**
 * sonar sensing stuff
 */


public class Sonar extends Subsystem {
	AnalogInput sonar = new AnalogInput(0);//analog imput object
	double distance;

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
		// TODO Auto-generated method stub
	}
}
//send the distance to the driver station
