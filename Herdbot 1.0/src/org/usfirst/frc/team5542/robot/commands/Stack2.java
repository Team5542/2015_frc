package org.usfirst.frc.team5542.robot.commands;


/**
 *
 */
public class Stack2 extends CommandBase {

    public Stack2() {
        requires(arm);
        requires(drivetrain);
        requires(claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	arm.setBase();
    	drivetrain.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.fprDrive(.2, 0);
    }

    private static final double distance = 12;
    protected boolean isFinished() {
        if (drivetrain.getDistance() >= distance){
        	complete = true;
        	return true;
        }
        else return false;
    }

    private boolean complete = false;
    protected void end() {
    	if (complete){
    		arm.setLift();
    	}
    	claw.close();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
