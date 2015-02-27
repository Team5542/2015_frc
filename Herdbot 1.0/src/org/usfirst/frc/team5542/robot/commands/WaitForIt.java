package org.usfirst.frc.team5542.robot.commands;


/**
 *
 */
public class WaitForIt extends CommandBase {

    public WaitForIt() {
        requires(arm);
        requires(claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//arm.setSetpointRelative(-10);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        /*if (arm.onTarget()){
        	complete = true;
        	return true;
        }
        else
        	return false;*/
    	return true;
    }

    private boolean complete = false;
    protected void end() {
    	if (complete)
    		(new Stack2()).start();
    	else
    		claw.close();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
