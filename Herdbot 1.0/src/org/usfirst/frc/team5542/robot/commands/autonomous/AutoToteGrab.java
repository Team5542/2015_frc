package org.usfirst.frc.team5542.robot.commands.autonomous;

import org.usfirst.frc.team5542.robot.commands.CommandBase;

/**
 *
 */
public class AutoToteGrab extends CommandBase {

    public AutoToteGrab() {
        requires(drivetrain);
        requires(claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.fprDrive(.2, 0);
    }
    private double distance = 12;
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (drivetrain.getDistance() >= distance);
    }

    // Called once after isFinished returns true
    protected void end() {
    	claw.close();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
