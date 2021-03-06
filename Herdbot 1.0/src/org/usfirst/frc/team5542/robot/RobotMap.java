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
    public static final int cMotor1 = 7;
    public static final int cMotor2 = 8;
    public static final int armMotorLeft = 1;//CAN id for arm motor
    public static final int armMotorRight = 2;
    public static final int potLow = 1;//analog for pot
    public static final int potHigh = 2;
    public static final int sonar = 0;
    public static final int tiltMotor = 6;//PWM camera up down motor
    public static final int panMotor = 5;//PWM camera left right motor
    public static final int infrared = 6;
    public static final int encoder1p1 = 1;//first encoder first port
    public static final int encoder1p2 = 2;//first encoder second port
    public static final int encoder2p1 = 3;//second encoder first port
    public static final int encoder2p2 = 4;//second encoder second port
    public static final int pullMotorL = 7;
    public static final int pullMotorR = 9;
    public static final int closeClaw = 2;
    public static final int openClaw = 3;
    public static final int openArm = 0;
    public static final int closeArm = 1;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
