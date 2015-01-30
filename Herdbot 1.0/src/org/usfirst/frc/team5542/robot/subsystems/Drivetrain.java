package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;
import org.usfirst.frc.team5542.robot.commands.FprDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *Drivetrain subsystem. Includes all motors used for driving.
 */
public class Drivetrain extends Subsystem {
    
	private RobotDrive myDrive;
	private Talon flMotor, frMotor, blMotor, brMotor;
	
	private Drivetrain(){
		flMotor = new Talon(RobotMap.flMotor);
		blMotor = new Talon(RobotMap.blMotor);
		frMotor = new Talon(RobotMap.frMotor);
		brMotor = new Talon(RobotMap.brMotor);
		myDrive = new RobotDrive(flMotor, blMotor, frMotor, brMotor);
	}
	
	public static Drivetrain instance;
	
	public static Drivetrain getInstance(){
		if (instance == null)
			instance = new Drivetrain();
		return instance;
	}

    public void tankDrive(double left, double right){
    	myDrive.tankDrive(left, right);
    }
    
    public void fprDrive(double move, double turn){
    	myDrive.arcadeDrive(move, turn);
    }

	
	public void initDefaultCommand() {
        setDefaultCommand(new FprDrive());
    }
}

