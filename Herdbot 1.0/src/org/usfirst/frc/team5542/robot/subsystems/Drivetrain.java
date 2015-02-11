package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;
import org.usfirst.frc.team5542.robot.commands.FprDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;

/**
 *Drivetrain subsystem. Includes all motors used for driving.
 */
public class Drivetrain extends Subsystem {
    
	private RobotDrive myDrive;
	private Talon flMotor, frMotor, blMotor, brMotor;
	private Encoder encoder1, encoder2;
	private static final double rate = .02;
	private static final double dpp = 18.84;//distance per pulse
	private double distance1;
	private double distance2;
	
	private Drivetrain(){
		flMotor = new Talon(RobotMap.flMotor);
		blMotor = new Talon(RobotMap.blMotor);
		frMotor = new Talon(RobotMap.frMotor);
		brMotor = new Talon(RobotMap.brMotor);
		myDrive = new RobotDrive(flMotor, blMotor, frMotor, brMotor);
		encoder1 = new Encoder(RobotMap.encoder1p1, RobotMap.encoder1p2);
		encoder2 = new Encoder(RobotMap.encoder2p1, RobotMap.encoder2p2);
		encoder1.setDistancePerPulse(dpp);
		encoder2.setDistancePerPulse(dpp);
	}
	
	public static Drivetrain instance;
	
	public static Drivetrain getInstance(){
		if (instance == null)
			instance = new Drivetrain();
		return instance;
	}
	public double distance1() {
		distance1 = encoder1.getDistance();
		return distance1;
	}
	public double distance2() {
		distance2 = encoder2.getDistance();
		return distance2;
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

