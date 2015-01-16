package org.usfirst.frc.team5542.robot.commands;

import org.usfirst.frc.team5542.robot.OI;
import org.usfirst.frc.team5542.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;



/**
 *Alternate control scheme inspired by FPS controls (stands for First Person Robot)
 */
public class FprDrive extends CommandBase {

    public FprDrive() {
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Joystick controller = Robot.oi.getController();
    	double move = controller.getRawAxis(OI.lyAxis);
    	double strafe = controller.getRawAxis(OI.lxAxis);
    	double turn = controller.getRawAxis(OI.rxAxis);
    	if (move >= 0)
    		move = Math.pow(move, OI.sensitivity);
    	else
    		move = -(Math.pow(-move, OI.sensitivity));
    	if (strafe >= 0)
    		strafe = Math.pow(strafe, OI.sensitivity);
    	else
    		strafe = -(Math.pow(-strafe, OI.sensitivity));
    	if (turn >= 0)
    		turn = Math.pow(turn, OI.sensitivity);
    	else
    		turn = -(Math.pow(-turn, OI.sensitivity));
    	if (move > -.05 && move < .05)
    		move = 0.0;
    	if (strafe > -.05 && strafe < .05)
    		strafe = 0.0;
    	if (turn > -.05 && turn < .05)
    		turn = 0.0;
    	drivetrain.fprDrive(move, strafe, turn);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.fprDrive(0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
