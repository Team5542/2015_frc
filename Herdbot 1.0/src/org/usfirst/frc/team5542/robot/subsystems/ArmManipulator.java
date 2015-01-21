package org.usfirst.frc.team5542.robot.subsystems;


import org.usfirst.frc.team5542.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmManipulator extends Subsystem {
	
	private Victor aMotor;
	
    private ArmManipulator(){
    	aMotor = new Victor(RobotMap.aMotor);
    }

    	public void arm(double input){
        	if (input > 1.0 || input < -1.0)
        		throw new IllegalArgumentException();
        	aMotor.set(input);
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

}

