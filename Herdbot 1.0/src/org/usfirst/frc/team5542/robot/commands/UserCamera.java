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
    	Joystick controller;
    	int cam;
    	controller = Robot.oi.getJoystick();
    	cam = controller.getPOV(OI.pov);
    	if (cam == 0 || cam == 45 || cam == 315)
    		camera.tilt(true);
    	if (cam == 135 || cam == 180 || cam == 225)
    		camera.tilt(false);
    	if (cam == 45 || cam == 90 || cam == 135)
    		camera.pan(true);
    	if (cam == 225 || cam == 270 || cam == 315)
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
    	camera.setPan(camera.getPan());
    	camera.setTilt(camera.getTilt());
    }
}
