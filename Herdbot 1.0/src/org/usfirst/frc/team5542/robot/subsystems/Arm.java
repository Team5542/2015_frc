package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *arm motor stuff and arm micro
 */
public class Arm extends PIDSubsystem {
	private static final double minHight = 0, maxHight = 3;
   
    private CANTalon armMotor1 = new CANTalon(RobotMap.armMotor1);
    private CANTalon armMotor2 = new CANTalon(RobotMap.armMotor2);
    private AnalogPotentiometer pot = new AnalogPotentiometer(RobotMap.potentiometer, maxHight - minHight, minHight);
	private DigitalInput armMicro1 = new DigitalInput(RobotMap.armMicro1);
	private DigitalInput armMicro2 = new DigitalInput(RobotMap.armMicro2);
	
	private static final double toteHight = 12.1;//inches
	private static final double canHight = 29.5;//inches
	private int totes = 1;
	private static final int maxTotes = 3;
	private static double kp = 1, ki = 0, kd = 0;
	
	// Initialize your subsystem here
    public Arm() {
    	 super(kp, ki, kd);
    	// Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	setSetpoint(toteHight);
    	enable();
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
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	double hight = pot.get();
    	
    	return 0.0;
    }
    
    protected void usePIDOutput(double output) {
    	armMotor1.set(output);
    	armMotor2.set(output);
    }
    
    public void up(){
    	if (totes != maxTotes)
    		totes++;
    	if (can)
    		setSetpoint(totes * toteHight + canHight);
    	else
    		setSetpoint(totes * toteHight);
    }
    public void down(){
    	if (totes != 1)
    		totes--;
    	if (can)
    		setSetpoint(totes * toteHight + canHight);
    	else
    		setSetpoint(totes * toteHight);
    }
    
    private boolean can = false;
    public void switchCan(){
    	can = !can;
    	if (can)
    		setSetpoint(totes * toteHight + canHight);
    	else
    		setSetpoint(totes * toteHight);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
