package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;
import org.usfirst.frc.team5542.robot.commands.FprDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;

/**
 *Drivetrain subsystem. Includes all motors used for driving.
 */
public class Drivetrain extends Subsystem {
    
	private RobotDrive myDrive;
	private Talon flMotor, frMotor, blMotor, brMotor;
	private Victor cMotor1;
	private Encoder lEncoder, rEncoder;
	private static final double rate = .02;
	private static final double dpp = 18.84;//distance per pulse (inches)
	
	public double circ = 69.115; // in (22*pi)
	
	private Drivetrain(){
		flMotor = new Talon(RobotMap.flMotor);
		blMotor = new Talon(RobotMap.blMotor);
		frMotor = new Talon(RobotMap.frMotor);
		brMotor = new Talon(RobotMap.brMotor);
		cMotor1 = new Victor(RobotMap.cMotor1);
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
	
	private static double prevMove, prevStrafe, prevTurn;
    
    private boolean lowGear = false;
    public boolean isLow(){
    	return lowGear;
    }
    public void switchGear(){
    	lowGear = !lowGear;
    }
    public void fprDrive(double move, double strafe, double turn){
    	if (prevMove - rate > move)
    		move = prevMove - rate;
    	if (prevMove + rate < move)
    		move = prevMove + rate;
    	if (prevStrafe - rate > turn)
    		turn = prevStrafe - rate;
    	if (prevStrafe + rate < turn)
    		turn = prevStrafe + rate;
    	if (prevTurn - rate > turn)
    		turn = prevTurn - rate;
    	if (prevTurn + rate < turn)
    		turn = prevTurn + rate;
    	myDrive.arcadeDrive(move, turn);
    	cMotor1.set(strafe);
    	prevMove = move;
    	prevStrafe = strafe;
    	prevStrafe = turn;
    }


	public void initDefaultCommand() {
        setDefaultCommand(new FprDrive());
    }
}

