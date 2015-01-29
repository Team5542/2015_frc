package org.usfirst.frc.team5542.robot.commands;

import org.usfirst.frc.team5542.robot.OI;
import org.usfirst.frc.team5542.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 *dPad control for camera
 */
public class UserCamera extends CommandBase {
	
    public UserCamera() {
    	requires(camera);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Joystick controller = Robot.oi.getController();
    	int cam = controller.getPOV(OI.dPad);
    	if (cam == 0 || cam == 1 || cam == 7)
    		camera.tilt(true);
    	if (cam == 3 || cam == 4 || cam == 5)
    		camera.tilt(false);
    	if (cam == 1 || cam == 2 || cam == 3)
    		camera.pan(true);
    	if (cam == 5 || cam == 6 || cam == 7)
    		camera.pan(false);
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
    	camera.setTilt(.5);
    	camera.setPan(.5);
    }
}
