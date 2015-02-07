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
	Sendable pdp0;
	public PDP(){
		PowerDistributionPanel PDP;
		PDP = new PowerDistributionPanel();
	}
		pdp0 = PDP.getCurrent(0);
	  
	
		
	    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

