package org.usfirst.frc.team5542.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gyro extends Subsystem {
    private static final int address = 0b1101011;
	private I2C gyro;
	public Gyro(){
		gyro = new I2C(I2C.Port.kOnboard, address);
		gyro.write(0b0100011, 0b00010000);
	}
	
	private static final double sensitivity = .01750;
	
	public static int twoComp(int input){
		if ((input & (256*256)) == 256*256)
			return -((~input) + 1);
		else
			return input;
	}
	
	private byte[] data;
	public double[] getRates(){
		gyro.read(0b0101000, 6, data);
		int[] stuff = new int[3];
		stuff[0] = twoComp(data[0] | (data[1] << 8));
		stuff[1] = twoComp(data[2] | (data[3] << 8));
		stuff[2] = twoComp(data[4] | (data[5] << 8));
		data = null;
		double[] rates = new double[3];
		for(int i = 0; i < 3; i++){
			rates[i] = stuff[i] * sensitivity;
		}
		return rates;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

