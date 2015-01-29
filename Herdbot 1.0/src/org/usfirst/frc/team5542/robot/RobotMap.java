package org.usfirst.frc.team5542.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static final int flMotor = 3;//PWM front left motor
    public static final int frMotor = 1;//etc.
    public static final int blMotor = 2;//
    public static final int brMotor = 0;//
    public static final int aMotor = 4;//CAN id for arm motor
    public static final int tiltMotor = 5;//PWM camera up down motor
    public static final int panMotor = 6;//PWM camera left right motor
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
