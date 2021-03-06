package org.usfirst.frc.team5542.robot.commands;



/**
 *
 */
public class ClawControl extends CommandBase {

    public ClawControl() {
        requires(claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (claw.isOpen())
    		claw.close();
    	else
    		claw.open();
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
