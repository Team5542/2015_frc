package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TheClaaaw extends Subsystem {

	private Solenoid openSolenoid1;
	private Solenoid openSolenoid2;
	public static TheClaaaw instance;

	public static TheClaaaw getInstance() {
		if (instance == null)
			instance = new TheClaaaw();
		return instance;			
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private TheClaaaw(){
		openSolenoid1= new Solenoid(RobotMap.openSolenoid1);
		openSolenoid2= new Solenoid(RobotMap.openSolenoid2);
	}

	public void open(){
		openSolenoid1.set(true);
		openSolenoid2.set(true);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}



}

