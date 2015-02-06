package org.usfirst.frc.team5542.robot.subsystems;

import edu.wpi.first.wpilibj.NamedSendable;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PDP extends Subsystem {
   public int pdp0;
		//Sendable pdp0;
		//Sendable pdp1;
		//PowerDistributionPanel PDP = new PowerDistributionPanel();
		pdp0 = PowerDistributionPanel.getCurrent(0);
		
	  
	
		
	    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

