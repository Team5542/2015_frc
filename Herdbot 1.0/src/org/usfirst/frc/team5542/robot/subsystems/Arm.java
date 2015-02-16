package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;
import org.usfirst.frc.team5542.robot.commands.UserArm;






import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *arm motor stuff and arm micro
 */
public class Arm extends PIDSubsystem {
    private CANTalon leftMotor ;
    private CANTalon rightMotor;
    private Solenoid solenoid1 = new Solenoid (RobotMap.graspSolenoid1);
    private Solenoid solenoid2 = new Solenoid (RobotMap.graspSolenoid2);
	private DigitalInput infrared = new DigitalInput(RobotMap.infrared);
	private AnalogPotentiometer potLow = new AnalogPotentiometer(RobotMap.potLow, 40);
	private AnalogPotentiometer potHigh = new AnalogPotentiometer(RobotMap.potHigh, 40, 40);
	//sets up motors and potentiometer
	
	private static double base = 0, lift = 30, place = 60;//constants for each possible
	
	private static final double kp = 1, ki = 0, kd = 0;
    public Arm() {
    	super(kp, ki, kd);
    	// Use these to get going:
    	// setSetpoint() -  Sets where the PID controller should move the system to
    	// enable() - Enables the PID controller.
    	setSetpoint(base);
    	enable();
    }
   
	

    public static Arm instance;
    	
    public static Arm getInstance(){
    	if (instance == null)
    		instance = new Arm();
    	return instance;
    }
    
    /*public boolean isInRange(){
    	return infrared.get();
    }*/
    
    
    protected double returnPIDInput() {
    	if (potLow.get() < 40)
    		return potLow.get();
    	else
    		return potHigh.get();
    }
    
    protected void usePIDOutput(double output) {
    	leftMotor.set(output);
    	rightMotor.set(output);
    }
    
    public void toggle(){
    	solenoid1.set( ! solenoid1.get());
    	solenoid2.set( ! solenoid2.get());
    }

    public void setBase(){
    	setSetpoint(base);
    }
    public void setLift(){
    	setSetpoint(lift);
    }
    public void setPlace(){
    	setSetpoint(place);
    }
    
    public boolean isLift(){
    	if (getSetpoint() == lift)
    		return true;
    	else
    		return false;
    }
    public boolean isBase(){
    	if (getSetpoint() == base)
    		return true;
    	else
    		return false;
    }
    public boolean isPlace(){
    	if (getSetpoint() == place)
    		return true;
    	else
    		return false;
    }
    
    public void move(double input){
    	if (input + getSetpoint() > lift)
    		setSetpoint(lift);
    	else if (input + getSetpoint() < base)
    		setSetpoint(base);
    	else
    		setSetpointRelative(input);
    }
    
    
    public void initDefaultCommand() {
        setDefaultCommand(new UserArm());
    }
}
