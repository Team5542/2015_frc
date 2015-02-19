package org.usfirst.frc.team5542.robot.commands;

import org.usfirst.frc.team5542.robot.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 *Base class to allow for direct subsystem reference in Commands and more organization in Robot.
 *I'm told this is a good idea...
 */
public abstract class CommandBase extends Command {

	protected static Drivetrain drivetrain;
	protected static Arm arm;
	protected static Gyro gyro;
	protected static Camera camera;
	protected static PDP pdp;
	protected static Sonar sonar;
	
	
	
	
	public static void init(){
		drivetrain = Drivetrain.getInstance();
		arm = Arm.getInstance(); //DO NOT initiate until potentiometer is set up and coded
		//gyro = Gyro.getInstance();
		camera = Camera.getInstance();
		pdp = PDP.getInstance();
		sonar = Sonar.getInstance();
	}
}