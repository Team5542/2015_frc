package org.usfirst.frc.team5542.robot.commands;

import org.usfirst.frc.team5542.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;


/**
 *
 */
public class ClawControl extends CommandBase {

    public ClawControl() {
        requires(claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Joystick controller = Robot.oi.getController();
    	boolean open = controller.getRawButton(1);
    	if(open)
    		claw.open();
    	else
    		claw.close();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	claw.open();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	claw.open();
    }
}
