package org.usfirst.frc.team5542.robot.commands;

import org.usfirst.frc.team5542.robot.OI;
import org.usfirst.frc.team5542.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;


/**
 *
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
    	double input;
    	Joystick controller = Robot.oi.getController();
    	input = controller.getRawAxis(OI.ryAxis);
    	if (input >= 0)
    		input = Math.pow(input, OI.sensitivity);
    	else
    		input = -(Math.pow(-input, OI.sensitivity));

    	
    	
    	if (input > -.05 && input < .05){
    		arm.move(.25);
    	}
    	else
    		arm.move(input);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	arm.move(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}