package org.usfirst.frc.team5542.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PDP extends Subsystem {

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		PowerDistributionPanel PDP = new PowerDistributionPanel();
	}


	
	SmartDashboard.putNumber("Current", pdp.getCurrent(14));
	
	    // Put methods for controlling this subsystem
    // here. Call these from Commands.

/*    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    */
}


