package org.usfirst.frc.team5542.robot.commands.autonomous;

import org.usfirst.frc.team5542.robot.commands.CommandBase;

/**
 *
 */
public class AutoCanLift extends CommandBase {

    public AutoCanLift() {
        requires(arm);
        requires(drivetrain);
        requires(grabber);
        requires(claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	claw.open();
    	arm.open();
    	arm.setBase();
    }

    private static final double distance = 12;
    protected void execute() {
    	drivetrain.fprDrive(.1, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (drivetrain.getDistance() > distance);
    }

    // Called once after isFinished returns true
    protected void end() {
    	arm.setLift();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
