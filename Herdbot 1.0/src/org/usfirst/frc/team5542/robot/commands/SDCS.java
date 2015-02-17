package org.usfirst.frc.team5542.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *Smartdashboard command sceam
 */
public class SDCS extends Command {
	
	SendableChooser sc = new SendableChooser();
	
	
    public SDCS() {

    }
    
    void CS() {
    	sc.addObject("Joystick + X-Box Controller", object1);
    	sc.addObject("Joystick", object2);
    	sc.addObject("X-Box Controller", object3);
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
