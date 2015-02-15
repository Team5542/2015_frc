package org.usfirst.frc.team5542.robot.commands;

import org.usfirst.frc.team5542.robot.OI;
import org.usfirst.frc.team5542.robot.Robot;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class PullMotor extends CommandBase {

    public PullMotor() {
    	requires (grabber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	int input;
    	Joystick controller;
    	if (OI.getxBox()){
    		controller = Robot.oi.getController();
    		input = controller.getPOV(OI.dPad);
    	}
    	else{
    		controller = Robot.oi.getJoystick();
    		input = controller.getPOV(OI.pov);
    	}
    	if (input == 0){
    		grabber.spit();
    	}
    	if (input == 90){
    		grabber.right();
    	}
    	if (input == 180){
    		grabber.feed();
    	}
    	if (input == 270){
    		grabber.left();
    	}
    	else {
    		grabber.stop();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	grabber.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	grabber.stop();
    }
}
