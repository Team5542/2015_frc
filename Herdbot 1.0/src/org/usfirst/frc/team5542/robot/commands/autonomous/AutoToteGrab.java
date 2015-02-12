package org.usfirst.frc.team5542.robot.commands.autonomous;

import org.usfirst.frc.team5542.robot.commands.CommandBase;

/**
 *Robot will drive forward until both micros are activated, then lift the tote.
 *Requires something approximating good starting alignment.
 */
public class AutoToteGrab extends CommandBase {

    public AutoToteGrab() {
        requires(arm);
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.fprDrive(.1, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return arm.isTouching();
    }

    // Called once after isFinished returns true
    protected void end() {
    	arm.up();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
