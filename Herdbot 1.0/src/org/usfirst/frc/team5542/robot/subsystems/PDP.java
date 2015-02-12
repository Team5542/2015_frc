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
	}
	
	public void getReading() {
		SmartDashboard.putNumber("Current0", PDP.getCurrent(0));
		SmartDashboard.putNumber("Current1", PDP.getCurrent(1));
		SmartDashboard.putNumber("Current2", PDP.getCurrent(2));
		SmartDashboard.putNumber("Current3", PDP.getCurrent(3));
		SmartDashboard.putNumber("Current4", PDP.getCurrent(4));
		SmartDashboard.putNumber("Current5", PDP.getCurrent(5));
		SmartDashboard.putNumber("Current6", PDP.getCurrent(6));
		SmartDashboard.putNumber("Current7", PDP.getCurrent(7));
		SmartDashboard.putNumber("Current8", PDP.getCurrent(8));
		SmartDashboard.putNumber("Current9", PDP.getCurrent(9));
		SmartDashboard.putNumber("Current10", PDP.getCurrent(10));
		SmartDashboard.putNumber("Current11", PDP.getCurrent(11));
		SmartDashboard.putNumber("Current12", PDP.getCurrent(12));
		SmartDashboard.putNumber("Current13", PDP.getCurrent(13));
		SmartDashboard.putNumber("Current14", PDP.getCurrent(14));
		SmartDashboard.putNumber("Current15", PDP.getCurrent(15));
	}
    private static PDP instance;
	
    public static PDP getInstance(){
    	if (instance == null)
    		instance = new PDP();
    	return instance;
    }
}
