package org.usfirst.frc.team5542.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
//math: voltage divided by 2 for every 10 mm//
/**
 * sonar sensing stuff
 */


public class Sonar extends Subsystem {
		AnalogInput sonar = new AnalogInput(0);
		
		public void math(){
		double volts = sonar.getVoltage();
		double distance = volts/2;
		}
//get the channel and voltage from here
	protected void initDefaultCommand() { 
		//calculate the distance and add the unit here
		// TODO Auto-generated method stub
		}
}
//send the distance to the driver station
