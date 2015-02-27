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
    	//heading = gyro.getXangle();
    }

    //private double heading;
    //private double prevTurn;
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Joystick controller;
    	double move;
    	double turn;
    	controller = Robot.oi.getController();
    	move = -controller.getRawAxis(OI.lyAxis);
    	turn = controller.getRawAxis(OI.rxAxis);
    	if(drivetrain.isLow()){
    		move = move / 2;
    		turn = turn / 2;
    	}
    	if (move >= 0)
    		move = Math.pow(move, OI.sensitivity);
    	else
    		move = -(Math.pow(-move, OI.sensitivity));

    	if (turn >= 0)
    		turn = Math.pow(turn, OI.sensitivity);
    	else
    		turn = -(Math.pow(-turn, OI.sensitivity));
    	
    	if (move > -.05 && move < .05)
    		move = 0.0;

    	if (turn > -.05 && turn < .05)
    		turn = 0.0;
    	
    	/*if (turn != 0 || move == 0)
    		heading = gyro.getZangle();
    	else{
    		if (gyro.getZangle() < heading){
    			prevTurn = prevTurn + .02;
    			if (prevTurn > 1)
    				prevTurn = 1;
    			turn = prevTurn;
    		}
    		if (gyro.getZangle() > heading){
    			prevTurn = prevTurn - .02;
    			if (prevTurn < 1)
    				prevTurn = 1;
    			turn = prevTurn;
    		}
    	}*/
    	
    	drivetrain.fprDrive(move, turn);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.fprDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
