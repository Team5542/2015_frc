package org.usfirst.frc.team5542.robot.commands.autonomous;

import org.usfirst.frc.team5542.robot.commands.CommandBase;

/**
 *
 */
public class AutoTurnLeft extends CommandBase {

    public AutoTurnLeft() {
        requires(drivetrain);
        requires(grabber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.fprDrive(0, 0, .2);
    	grabber.feed();
    }
    private double targetDist = 60;
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (drivetrain.rightDistance() >= targetDist);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
