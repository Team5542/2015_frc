package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;
import org.usfirst.frc.team5542.robot.commands.UserArm;



//import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
//import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
//import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *arm motor stuff and arm micro
 */
public class Arm extends Subsystem {
	//private static final double minHight = 0, maxHight = 0;//sets the base auto height and max auto height
    private CANTalon leftMotor;
    private CANTalon rightMotor;
    //private AnalogPotentiometer pot = new AnalogPotentiometer(RobotMap.potentiometer, maxHight - minHight, minHight);
	//private DigitalInput armMicro1 = new DigitalInput(RobotMap.armMicro1);
	//private DigitalInput armMicro2 = new DigitalInput(RobotMap.armMicro2);
	//private DigitalInput infrared;
	private RobotDrive myDrive;
	//private Counter leftHall = new Counter(RobotMap.leftHall);
	//private Counter rightHall = new Counter(RobotMap.rightHall);
	//sets up motors and potentiometer
	
//	private static final double toteHeight = 12.1;//sets the height for totes in inches
//	private static final double canHeight = 29.5;//sets the height for cans in inches
//    private static double liftComp = 3;//inches
//	private int totes = 1;
//	private static final int maxTotes = 3;
//	private static double kp = 1, ki = .5, kd = 0;
//	private static double dpp = 1;
//	
	// Initialize your subsystem here
//    public Arm() {
//    	 super(kp, ki, kd);
//    	 //leftHall.setDistancePerPulse(dpp);
//    	 //rightHall.setDistancePerPulse(dpp);
//    	// Use these to get going:
//        // setSetpoint() -  Sets where the PID controller should move the system
//        //                  to
//        // enable() - Enables the PID controller.
//    	setSetpoint(toteHeight);
//    	enable();
//    }
	
	private Arm(){
		rightMotor = new CANTalon(RobotMap.armMotorRight);
		leftMotor = new CANTalon(RobotMap.armMotorLeft);
		myDrive= new RobotDrive(leftMotor, rightMotor);
		//infrared = new DigitalInput(RobotMap.infrared);
	}
   
	

    public static Arm instance;
    	
    public static Arm getInstance(){
    	if (instance == null)
    		instance = new Arm();
    	return instance;
    }
    /*public void potSD() {
    	SmartDashboard.putNumber("Potentiometer", pot.get()); //sends potentiometer data to the smart dash
    }*/
    
    /*public boolean isInRange(){
    	return infrared.get();
    }*/
    
    public boolean isTouching(){
    	//return (armMicro1.get() && armMicro2.get());
    	return false;
    }
    
    /*public double compareHalls(){
    	//return leftHall.getDistance() - rightHall.getDistance();
    	return 0;
    }*/
    
    /*protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	//return (leftHall.getDistance() + rightHall.getDistance()) / 2;
    	return 0;
    }*/
    
   /* private double motorComp;
    protected void usePIDOutput(double output) {
    	if (compareHalls() < 0)
   		motorComp += .01;
    	if (compareHalls() > 0);
    		motorComp -= .01;
    	if (output + motorComp < 0)
    		leftHall.setReverseDirection(true);
    	else
    		leftHall.setReverseDirection(false);
    	if (output - motorComp < 0)
    		rightHall.setReverseDirection(true);
    	else
    		rightHall.setReverseDirection(false);
    	leftMotor.set(output + motorComp);
    	rightMotor.set(output - motorComp);
    	
    }*/
    
    public void arcadeControls(double move, double turn){
    	myDrive.arcadeDrive(move, 0);
    }
    
//    public void up(){
//    	leftMotor.set(.1);
//    	rightMotor.set(.1);
    	//if (totes != maxTotes)
    		//totes++;
    	//if (can)
    		//setSetpoint(totes * toteHeight + canHeight + lift());
    	//else
    		//setSetpoint(totes * toteHeight + lift());
//    }
//    public void down(){
//    	leftMotor.set(-.1);
//    	rightMotor.set(-.1);
    	//if (totes != 1)
    		//totes--;
    	//else if (can)
    		//setSetpoint(canHeight);
    	//else
    		//setSetpoint(toteHeight);
    	//if (can)
    		//setSetpoint(totes * toteHeight + canHeight + lift());
    	//else
    		//setSetpoint(totes * toteHeight + lift());
    
    
    /*public double lift(){
    	if (isTouching())
    		return liftComp;
    	else
    		return 0;
    }*/
    
    /*private boolean can = false;
    public void switchCan(){
    	can = !can;
    	if (can)
    		setSetpoint(totes * toteHeight + canHeight);
    	else
    		setSetpoint(totes * toteHeight);
    }*/
    
    public void initDefaultCommand() {
        setDefaultCommand(new UserArm());
    }
}
