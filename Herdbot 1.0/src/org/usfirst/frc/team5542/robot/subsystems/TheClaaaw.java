package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;
import org.usfirst.frc.team5542.robot.commands.ClawControl;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TheClaaaw extends Subsystem {

	private Solenoid openClaw;
	private Solenoid closeClaw;
	public static TheClaaaw instance;

	public static TheClaaaw getInstance(){
		if (instance == null)
			instance = new TheClaaaw();
		return instance;			
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private TheClaaaw(){
		openClaw= new Solenoid(RobotMap.openClaw);
		closeClaw= new Solenoid(RobotMap.closeClaw);
	}

	public boolean isOpen(){
		return openClaw.get();
	}
	public void open(){
		closeClaw.set(false);
		openClaw.set(true);
	}
	public void close(){
		openClaw.set(false);
		closeClaw.set(true);
	}
	public void initDefaultCommand() {
	}



}

