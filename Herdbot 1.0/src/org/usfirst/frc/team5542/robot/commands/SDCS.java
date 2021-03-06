package org.usfirst.frc.team5542.robot.commands;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *Smartdashboard command scheme
 */
public class SDCS extends Command {
	
	SendableChooser sc = new SendableChooser();
	Sendable twoController;
	Sendable xBox;
	double controller;
	
    public SDCS() {

    }

    // Called just before this Command runs the first time
    public void initialize() {
    	sc.addDefault("Joystick + X-Box Controller", twoController);
    	SmartDashboard.putNumber("Nunber Of Drivers", 2);
    	sc.addObject("X-Box Controller", xBox);
    	SmartDashboard.putData("Control Choser", sc);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (controller != SmartDashboard.getNumber("Number Of Drivers"));{
    		
    	}
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
