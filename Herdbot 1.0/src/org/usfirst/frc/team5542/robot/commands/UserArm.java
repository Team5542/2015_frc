package org.usfirst.frc.team5542.robot.commands;

import org.usfirst.frc.team5542.robot.OI;
import org.usfirst.frc.team5542.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;



/**
 *arm control from user
 */
public class UserArm extends CommandBase {
	
    public UserArm() {
        requires(arm);
    }


    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Joystick controller;
    	double move;
    	double up;
    	double down;
    	if (OI.getxBox()){
    		controller = Robot.oi.getController();
    		move = controller.getRawAxis(OI.rTrigger) - controller.getRawAxis(OI.lTrigger);
    	}
    	else{
    		controller = Robot.oi.getJoystick();
    		OI.trigger.whenPressed(up = 1);
    		OI.thumb.whenPressed(down = 1);
    	}
    	arm.move(move);
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
    	arm.move(0);
    }
}
