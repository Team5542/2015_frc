package org.usfirst.frc.team5542.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *PDP(power distribution panel) code
 */

public class PDP extends Subsystem {

	PowerDistributionPanel PDP = new PowerDistributionPanel();
	
	protected void initDefaultCommand() {
		SmartDashboard.putNumber("Current", PDP.getCurrent(0));
		SmartDashboard.putNumber("Current", PDP.getCurrent(1));
		SmartDashboard.putNumber("Current", PDP.getCurrent(2));
		SmartDashboard.putNumber("Current", PDP.getCurrent(3));
		SmartDashboard.putNumber("Current", PDP.getCurrent(4));
		SmartDashboard.putNumber("Current", PDP.getCurrent(5));
		SmartDashboard.putNumber("Current", PDP.getCurrent(6));
		SmartDashboard.putNumber("Current", PDP.getCurrent(7));
		SmartDashboard.putNumber("Current", PDP.getCurrent(8));
		SmartDashboard.putNumber("Current", PDP.getCurrent(9));
		SmartDashboard.putNumber("Current", PDP.getCurrent(10));
		SmartDashboard.putNumber("Current", PDP.getCurrent(11));
		SmartDashboard.putNumber("Current", PDP.getCurrent(12));
		SmartDashboard.putNumber("Current", PDP.getCurrent(13));
		SmartDashboard.putNumber("Current", PDP.getCurrent(14));
		SmartDashboard.putNumber("Current", PDP.getCurrent(15));
	}

}


