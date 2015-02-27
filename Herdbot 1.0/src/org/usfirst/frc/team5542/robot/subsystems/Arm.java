package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;
import org.usfirst.frc.team5542.robot.commands.UserArm;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *arm motor stuff and arm micro
 */
public class Arm extends Subsystem {
    private CANTalon leftMotor = new CANTalon(RobotMap.armMotorLeft);
    private CANTalon rightMotor = new CANTalon(RobotMap.armMotorRight);
    private Solenoid openArm = new Solenoid (RobotMap.openArm);
    private Solenoid closeArm = new Solenoid (RobotMap.closeArm);
   
	private Arm(){
		
	}

    public static Arm instance;
    	
    public static Arm getInstance(){
    	if (instance == null)
    		instance = new Arm();
    	return instance;
    }
    public void open(){
    	closeArm.set(false);
    	openArm.set(true);
    }
    
    public void close(){
    	openArm.set(false);
    	closeArm.set(true);
    }
    
    public boolean isOpen(){
    	return openArm.get();
    }

    public void move(double input){
    	leftMotor.set(input);
    	rightMotor.set(input);
    }
    
    
    public void initDefaultCommand() {
        setDefaultCommand(new UserArm());
    }
}
