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
		SmartDashboard.putNumber("Current", PDP.getCurrent(14));
		
		
	}

}


