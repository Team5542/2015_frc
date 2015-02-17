package org.usfirst.frc.team5542.robot.commands;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 *Smartdashboard command scheme
 */
public class SDCS extends Command {
	
	SendableChooser sc = new SendableChooser();
	Sendable twoController;
	Sendable joystick;
	Sendable xBox;
	
    public SDCS() {

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	sc.addObject("Joystick + X-Box Controller", twoController);
    	sc.addObject("Joystick", joystick);
    	sc.addObject("X-Box Controller", xBox);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
