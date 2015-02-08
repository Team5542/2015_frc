package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;
import org.usfirst.frc.team5542.robot.commands.FprDrive;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *Drivetrain subsystem. Includes all motors used for driving.
 */
public class Drivetrain extends Subsystem {
    
	private RobotDrive myDrive;
	private Talon flMotor, frMotor, blMotor, brMotor;
	private AnalogInput sonar;
	private static final double rate = .02;
	
	private Drivetrain(){
		flMotor = new Talon(RobotMap.flMotor);
		blMotor = new Talon(RobotMap.blMotor);
		frMotor = new Talon(RobotMap.frMotor);
		brMotor = new Talon(RobotMap.brMotor);
		myDrive = new RobotDrive(flMotor, blMotor, frMotor, brMotor);
		sonar = new AnalogInput(RobotMap.sonar);
	}
	
	public static Drivetrain instance;
	
	public static Drivetrain getInstance(){
		if (instance == null)
			instance = new Drivetrain();
		return instance;
	}
	
	
	private static double prev1;
	private static double prev2;
	
    public void tankDrive(double left, double right){
    	if (prev1 - rate > left)
    		left = prev1 - rate;
    	if (prev1 + rate < left)
    		left = prev1 + rate;
    	if (prev2 - rate > right)
    		right = prev2 - rate;
    	if (prev2 + rate < right)
    		right = prev2 + rate;
    	myDrive.tankDrive(left, right);
    	prev1 = left;
    	prev2 = right;
    }
    
    public void fprDrive(double move, double turn){
    	if (prev1 - rate > move)
    		move = prev1 - rate;
    	if (prev1 + rate < move)
    		move = prev1 + rate;
    	if (prev2 - rate > turn)
    		turn = prev2 - rate;
    	if (prev2 + rate < turn)
    		turn = prev2 + rate;
    	myDrive.arcadeDrive(move, turn);
    	prev1 = move;
    	prev2 = turn;
    }


	public void initDefaultCommand() {
        setDefaultCommand(new FprDrive());
    }
}

