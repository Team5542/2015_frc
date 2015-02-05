package org.usfirst.frc.team5542.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static final int flMotor = 3;//PWM front left motor
    public static final int blMotor = 2;//etc.
    public static final int frMotor = 1;//
    public static final int brMotor = 0;//
    public static final int armMotor = 4;//CAN id for arm motor
    public static final int tiltMotor = 6;//PWM camera up down motor
    public static final int panMotor = 5;//PWM camera left right motor
    public static final int armMicro1 = 0;//DIO port for microswitch
    public static final int armMicro2 = 1;
    public static final int sonar = 0;//analog channel for sonar
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
