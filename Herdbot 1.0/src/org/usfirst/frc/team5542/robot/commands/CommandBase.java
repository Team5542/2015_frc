package org.usfirst.frc.team5542.robot.commands;

import org.usfirst.frc.team5542.robot.subsystems.Arm;
import org.usfirst.frc.team5542.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *Base class to allow for direct subsystem reference in Commands and more organization in Robot.
 *I'm told this is a good idea...
 */
public abstract class CommandBase extends Command {

	protected static Drivetrain drivetrain;
	protected static Arm Arm;
	
	
	
	
	
	public static void init(){
		drivetrain = Drivetrain.getInstance();
	}
}