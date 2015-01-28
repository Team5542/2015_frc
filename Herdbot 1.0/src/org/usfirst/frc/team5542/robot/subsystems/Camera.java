package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {

	private Servo tiltMotor;
	private Servo panMotor;
	
	private Camera(){
		tiltMotor = new Servo(RobotMap.tiltMotor);
		panMotor = new Servo(RobotMap.panMotor);
	}
    	public void tilt(double input){
        	if (input > 1.0 || input < 0)
        		throw new IllegalArgumentException();
        	tiltMotor.set(input);
	}
    	public void pan(double input){
        	if (input > 1.0 || input < 0)
        		throw new IllegalArgumentException();
        	panMotor.set(input);
    	}
    	private static Camera instance;
    	
    	public static Camera getInstance(){
    		if (instance == null)
    			instance = new Camera();
    		return instance;
    	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

