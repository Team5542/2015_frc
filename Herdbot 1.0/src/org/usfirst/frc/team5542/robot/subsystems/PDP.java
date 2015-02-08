package org.usfirst.frc.team5542.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PDP extends Subsystem {

	PowerDistributionPanel PDP = new PowerDistributionPanel();
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		SmartDashboard.putNumber("Current", PDP.getCurrent(14));
	}

}


