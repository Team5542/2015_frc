package org.usfirst.frc.team5542.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import org.usfirst.frc.team5542.robot.commands.PullMotor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {
    
	private Victor pullMotorL;
	private Victor pullMotorR;
	private Victor openMotor;
	
	
	private Grabber(){		
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
	
	public void openMotor (boolean input){
		if (input)
			openMotor.set(.5);
		if (! input)
			openMotor.set(-.5);
		else
			openMotor.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
}

