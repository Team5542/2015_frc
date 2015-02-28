package org.usfirst.frc.team5542.robot.commands.autonomous;

import org.usfirst.frc.team5542.robot.commands.CommandBase;

/**
 *
 */
public class AutoZone extends CommandBase {

    public AutoZone() {
        requires(drivetrain);
        requires(arm);
    }
    
    private double heading;
    // Called just before this Command runs the first time
    protected void initialize() {
    	heading = gyro.getXangle();
    }

    private double turn = 0;
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (gyro.getZangle() > heading)
    		turn = turn - .02;
    	if (gyro.getZangle() < heading)
    		turn = turn +.02;
    	drivetrain.fprDrive(.2, 0, turn);
    }

    private double distance = 84;
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (drivetrain.getDistance() > distance);
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
