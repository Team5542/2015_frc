package org.usfirst.frc.team5542.robot.commands.autonomous;

import org.usfirst.frc.team5542.robot.commands.CommandBase;

/**
 *Gets robot into auto zone after picking up tote/can.
 */
public class AutoZone extends CommandBase {

    public AutoZone() {
        requires(drivetrain);
        requires(arm);
        requires(gyro);
    }
    
    private double heading;
    // Called just before this Command runs the first time
    protected void initialize() {
    	heading = gyro.getZangle();
    }

    private double turn = 0;
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (gyro.getZangle() > heading)
    		turn = turn - .02;
    	if (gyro.getZangle() < heading)
    		turn = turn +.02;
    	drivetrain.fprDrive(-.5, turn);
    }

    private static double distance = 84;
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (drivetrain.getDistance() > distance);
    }

    // Called once after isFinished returns true
    protected void end() {
    	//arm.down();
    	//arm.down();
    	drivetrain.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
