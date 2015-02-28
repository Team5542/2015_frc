package org.usfirst.frc.team5542.robot.commands;


/**
 *
 */
public class Stack extends CommandBase {

    public Stack() {
        requires(arm);
        requires(drivetrain);
        requires(claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(!arm.isInRange()) end();
    	drivetrain.reset();
    	claw.open();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.fprDrive(-.2, 0);
    }

    protected boolean isFinished() {
        if (!arm.isInRange()){
        	complete = true;
        	return true;
        }
        else
        	return false;
    }

    private boolean complete = false;
    protected void end() {
    	if (complete)
    		(new WaitForIt()).start();
    	else
    		claw.close();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
