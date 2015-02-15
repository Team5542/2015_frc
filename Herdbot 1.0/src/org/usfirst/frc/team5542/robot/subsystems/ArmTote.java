package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmTote extends Subsystem {
	
	private RobotDrive myArm;
	private Solenoid myHook;
	private Victor pullMotor;//Temporary motor controller is temporary
	private Victor openMotor;//again temporary
	
	private ArmTote() {
		pullMotor = new Victor(RobotMap.pullMotor);
		openMotor = new Victor(RobotMap.openMotor);
		myArm = new RobotDrive(pullMotor, openMotor);
		myHook = new Solenoid(RobotMap.releaseSolenoid1, RobotMap.releaseSolenoid2);
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

