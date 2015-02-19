package org.usfirst.frc.team5542.robot.commands.autonomous;

import org.usfirst.frc.team5542.robot.commands.CommandBase;

/**
 *
 */
public class JustMove extends CommandBase {

	boolean backwards = false;
	boolean armDone = false;
	public JustMove() {
		requires(drivetrain);
		requires(arm);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (drivetrain.getDistance() < 4 && ! backwards) {
			drivetrain.fprDrive(.5, 0);
		}
		if (drivetrain.getDistance() == 4 && ! armDone){
			for (int counter =0; counter >= 100; counter++){
				arm.arcadeControls(-.4, 0);
			}
			armDone = true;
			backwards=true;
		}
		else {
			drivetrain.fprDrive(-.5,0);    		
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (drivetrain.getDistance() > -70);
	}

	// Called once after isFinished returns true
	protected void end() {
		drivetrain.fprDrive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
