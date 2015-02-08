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

	public PDP(){
		PowerDistributionPanel PDP;
		PDP = new PowerDistributionPanel();
	}
	//currently use PDP channels 0 2 3 12 13 15
	Sendable pdp0;
	Sendable pdp2;
	Sendable pdp3;
	Sendable pdp12;
	Sendable pdp13;
	Sendable pdp14;
	Sendable null1;
	
		pdp0 = PDP.getCurrent(0);
		pdp2 = PDP.getCurrent(2);
		pdp3 = PDP.getCurrent(3);
		pdp12 = PDP.getCurrent(12);
		pdp13 = PDP.getCurrent(13);
		pdp15 = PDP.getCurrent(15);
	  
	
		
	    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


