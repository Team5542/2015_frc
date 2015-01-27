package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {

	private Servo cudMotor;
	private Servo clrMotor;
	
	private Camera(){
		cudMotor = new Servo(RobotMap.cudMotor);
		clrMotor = new Servo(RobotMap.clrMotor);
	}
    	public void updown(double input){
        	if (input > 1.0 || input < 0)
        		throw new IllegalArgumentException();
        	cudMotor.set(input);
	}
    	public void leftright(double input){
        	if (input > 1.0 || input < 0)
        		throw new IllegalArgumentException();
        	clrMotor.set(input);
    	}
    	public static Camera instance;
    	
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

