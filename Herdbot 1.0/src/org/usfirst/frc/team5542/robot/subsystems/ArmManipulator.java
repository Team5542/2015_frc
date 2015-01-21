package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.OI;
import org.usfirst.frc.team5542.robot.Robot;
import org.usfirst.frc.team5542.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmManipulator extends Subsystem {
	
	private Talon aMotor;
	
    private ArmManipulator(){
    	aMotor = new Talon(RobotMap.aMotor);
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

