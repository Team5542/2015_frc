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
	private DigitalInput armMicro1;
	private DigitalInput armMicro2;
	
    private Arm(){
    	armMotor = new CANTalon(RobotMap.armMotor);
    	armMicro1 = new DigitalInput(RobotMap.armMicro1);
    	armMicro2 = new DigitalInput(RobotMap.armMicro2);
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
    	return (armMicro1.get() && armMicro2.get());
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new UserArm());
    }

}

