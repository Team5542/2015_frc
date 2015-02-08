package org.usfirst.frc.team5542.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *toggles between the two drives
 */
public class ToggleDrive extends Command {

    private static boolean tankDrive = false;
	
	public ToggleDrive() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (tankDrive)
    		new FprDrive().start();
    	else
    		new UserDrive().start();
    	tankDrive = !tankDrive;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
