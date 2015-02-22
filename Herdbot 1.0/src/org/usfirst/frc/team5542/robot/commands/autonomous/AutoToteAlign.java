package org.usfirst.frc.team5542.robot.commands.autonomous;

import org.usfirst.frc.team5542.robot.commands.CommandBase;

/**
 *
 */
public class AutoToteAlign extends CommandBase {

    public AutoToteAlign() {
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.fprDrive(0, .2);
    }
    private double targetAngle = 90;
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (gyro.getXangle() >= targetAngle);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
