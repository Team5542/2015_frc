package org.usfirst.frc.team5542.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *arm motor stuff and arm micro
 */
public class Arm extends PIDSubsystem {

   
    private CANTalon armMotor;
    private CANTalon armMotor2;
	private DigitalInput armMicro1;
	private DigitalInput armMicro2;
	
	// Initialize your subsystem here
    public Arm() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
   
	
    public void move(double input){
        	if (input > 1.0 || input < -1.0)
        		throw new IllegalArgumentException();
        	armMotor.set(input);
        	armMotor2.set(input);
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

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return 0.0;
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
