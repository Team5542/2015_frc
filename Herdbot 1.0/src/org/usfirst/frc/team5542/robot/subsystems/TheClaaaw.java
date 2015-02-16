package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TheClaaaw extends Subsystem {

	private Solenoid openSolenoid;
	public static TheClaaaw instance;
	
	public static TheClaaaw getInstance() {
		if (instance == null)
			instance = new TheClaaaw();
		return instance;			
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private TheClaaaw(){
		openSolenoid= new Solenoid(RobotMap.openSolenoid);
	}

	public void open(){
		
			openSolenoid.set(true);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}



}

