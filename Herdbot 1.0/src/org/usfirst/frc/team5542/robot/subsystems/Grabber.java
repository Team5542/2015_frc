package org.usfirst.frc.team5542.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;

import org.usfirst.frc.team5542.robot.RobotMap;
import org.usfirst.frc.team5542.robot.commands.PullMotor;
import org.usfirst.frc.team5542.robot.commands.OpenMotor;

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
		pullMotorL.set(.5);
		pullMotorR.set(-.5);
	}
	
	public void spit(){
		pullMotorL.set(.5);
		pullMotorR.set(-.5);
	}
	
	public void left(){
		pullMotorL.set(-.5);
		pullMotorR.set(-.5);
	}
	
	public void right(){
		pullMotorL.set(.5);
		pullMotorR.set(.5);
	}
	
	public void stop(){
		pullMotorL.set(0);
		pullMotorR.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
}

