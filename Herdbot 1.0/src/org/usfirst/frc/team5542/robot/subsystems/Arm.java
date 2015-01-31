package org.usfirst.frc.team5542.robot.subsystems;


import org.usfirst.frc.team5542.robot.RobotMap;
import org.usfirst.frc.team5542.robot.commands.UserArm;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *Motors for arm.
 */
public class Arm extends Subsystem {
	
	private CANTalon armMotor;
	private DigitalInput armMicro;
	
    private Arm(){
    	armMotor = new CANTalon(RobotMap.aMotor);
    	armMicro = new DigitalInput(RobotMap.armMicro);
    }

    public void move(double input){
        	if (input > 1.0 || input < -1.0)
        		throw new IllegalArgumentException();
        	armMotor.set(input);
    }
    public static Arm instance;
    	
    public static Arm getInstance(){
    	if (instance == null)
    		instance = new Arm();
    	return instance;
    }
    
    public boolean isTouching(){
    	return armMicro.get();
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new UserArm());
    }

}

