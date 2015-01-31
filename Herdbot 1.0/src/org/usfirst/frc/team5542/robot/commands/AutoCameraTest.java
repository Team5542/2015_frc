package org.usfirst.frc.team5542.robot.commands;


/**
 *
 */
public class AutoCameraTest extends CommandBase {

    public AutoCameraTest() {
        requires(camera);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	camera.setPan(0);
    	camera.setTilt(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	camera.setPan(1);
    	camera.setTilt(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (camera.getTilt() == 1 && camera.getPan() == 1)
        	return true;
        else
        	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	camera.setPan(.5);
    	camera.setTilt(.5);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
