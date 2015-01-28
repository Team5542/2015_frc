package org.usfirst.frc.team5542.robot.commands;

import org.usfirst.frc.team5542.robot.OI;
import org.usfirst.frc.team5542.robot.Robot;
import org.usfirst.frc.team5542.robot.RobotMap;
import org.usfirst.frc.team5542.robot.subsystems.Camera;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;

/**
 *
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
    	double leftright = controller.getRawAxis(OI.dPad);
    	double updown = controller.getRawAxis(OI.dPad);
    	if (updown <= 0)
    		updown = Servo.getAngle(RobotMap.cudMotor);
    	if
    		
    			
    	
    	
    	
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
    }
}
