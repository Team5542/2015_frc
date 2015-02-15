package org.usfirst.frc.team5542.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import org.usfirst.frc.team5542.robot.commands.PullMotor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {
    
	private Victor pullMotor;
	private Victor openMotor;
	
	
	private Grabber(){
		
	}
	
	public static Grabber instance;
	
	public static Grabber getInstance(){
		if (instance==null)
			instance= new Grabber();
		return instance;		
	}
	
	public void pullMotor (double speed){
		pullMotor.set(speed);
	}
	
	public void openMotor (double speed){
		openMotor.set(speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
}

