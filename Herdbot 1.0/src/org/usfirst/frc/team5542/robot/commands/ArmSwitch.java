package org.usfirst.frc.team5542.robot.commands;


/**
 *
 */
public class ArmSwitch extends CommandBase {

    public ArmSwitch() {
        requires(arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (arm.isUp())
    		arm.setBase();
    	else
    		arm.setLift();
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
