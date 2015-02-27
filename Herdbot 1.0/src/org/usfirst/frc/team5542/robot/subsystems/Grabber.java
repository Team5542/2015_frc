package org.usfirst.frc.team5542.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;

import org.usfirst.frc.team5542.robot.RobotMap;
import org.usfirst.frc.team5542.robot.commands.PullMotor;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {
    
	private Victor pullMotorL;
	private Victor pullMotorR;
	
	private Grabber(){		
		pullMotorL = new Victor(RobotMap.pullMotorL);
		pullMotorR = new Victor(RobotMap.pullMotorR);
	}
	
	public static Grabber instance;
	
	public static Grabber getInstance(){
		if (instance==null)
			instance= new Grabber();
		return instance;		
	}
	
	public void feed(){
		pullMotorL.set(.25);
		pullMotorR.set(-.25);
	}
	
	public void spit(){
		pullMotorL.set(-.25);
		pullMotorR.set(.25);
	}
	
	public void left(){
		pullMotorL.set(-.25);
		pullMotorR.set(-.25);
	}
	
	public void right(){
		pullMotorL.set(.25);
		pullMotorR.set(.25);
	}
	
	public void stop(){
		pullMotorL.set(0);
		pullMotorR.set(0);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new PullMotor());
    }
}

