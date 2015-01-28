package org.usfirst.frc.team5542.robot.subsystems;


import org.usfirst.frc.team5542.robot.RobotMap;
import org.usfirst.frc.team5542.robot.commands.UserArm;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.hal.CanTalonSRX;

/**
 *base for the arm
 */
public class Arm extends Subsystem {
	
	private CanTalonSRX aMotor;
	
    private Arm(){
    	aMotor = new CanTalonSRX(RobotMap.aMotor);
    }

    	public void move(double input){
        	if (input > 1.0 || input < -1.0)
        		throw new IllegalArgumentException();
        	aMotor.Set(input);
    }
    	public static Arm instance;
    	
    	public static Arm getInstance(){
    		if (instance == null)
    			instance = new Arm();
    		return instance;
    	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new UserArm());
    }

}

