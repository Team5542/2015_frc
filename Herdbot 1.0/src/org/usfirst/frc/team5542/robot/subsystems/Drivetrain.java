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
	private Encoder lEncoder, rEncoder;
	private static final double rate = .02;
	private static final double dpp = 18.84;//distance per pulse (inches)
	
	public double circ = 69.115; // in (22*pi)
	
	private Drivetrain(){
		flMotor = new Talon(RobotMap.flMotor);
		blMotor = new Talon(RobotMap.blMotor);
		frMotor = new Talon(RobotMap.frMotor);
		brMotor = new Talon(RobotMap.brMotor);
		myDrive = new RobotDrive(flMotor, blMotor, frMotor, brMotor);
		lEncoder = new Encoder(RobotMap.encoder1p1, RobotMap.encoder1p2);
		rEncoder = new Encoder(RobotMap.encoder2p1, RobotMap.encoder2p2);
		lEncoder.setDistancePerPulse(dpp);
		rEncoder.setDistancePerPulse(dpp);
	}
	
	public static Drivetrain instance;
	
	public static Drivetrain getInstance(){
		if (instance == null)
			instance = new Drivetrain();
		return instance;
	}
	public double leftDistance() {
		return lEncoder.getDistance();
	}
	public double rightDistance() {
		return rEncoder.getDistance();
	}
	public double getDistance(){
		return ((leftDistance() + rightDistance()) / 2);
	}
	public void reset(){
		lEncoder.reset();
		rEncoder.reset();
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
    
    private boolean lowGear = false;
    public boolean isLow(){
    	return lowGear;
    }
    public void switchGear(){
    	lowGear = !lowGear;
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

