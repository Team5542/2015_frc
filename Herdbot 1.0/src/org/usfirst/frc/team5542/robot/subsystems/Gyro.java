package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.commands.GyroUpdate;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gyro extends Subsystem {
    private static final SPI.Port port = SPI.Port.kOnboardCS0;
	private SPI gyro;
	public Gyro(){
		gyro = new SPI(port);
		gyro.setClockActiveLow();
		byte[] startup = {0b00100000, 0b00001111};
		gyro.write(startup, 2);
		byte[] resolution = {0b00100011, 0b00010000};
		gyro.write(resolution, 2);
	}
	
	private static Gyro instance;
	
	public static Gyro getInstance(){
		if(instance == null)
			instance = new Gyro();
		return instance;
	}
	
	
	private static final double sensitivity = .01750;
	
	public static int twoComp(int input){
		if ((input & (256*256)) == 256*256)
			return -((~input) + 1);
		else
			return input;
	}
	
	public byte[] gyroData = new byte[6];
	private double[] rates = new double[3];
	public void getRates(){
		gyro.read(true, gyroData, 6);
		int[] stuff = new int[3];
		stuff[0] = twoComp(gyroData[0] | (gyroData[1] << 8));
		stuff[1] = twoComp(gyroData[2] | (gyroData[3] << 8));
		stuff[2] = twoComp(gyroData[4] | (gyroData[5] << 8));
		gyroData = null;
		for(int i = 0; i < 3; i++){
			rates[i] = stuff[i] * sensitivity;
		}
	}

	private double[] angles = new double[3];
	private long lastTime;
	
	public void updateAngles(){
		long currentTime = System.currentTimeMillis();
		int difference = (int)(currentTime - lastTime);
		lastTime = currentTime;
		for(int i = 0; i < 3; i++){
			angles[i] += rates[i] * difference;
		}
	}
	
	public double getXangle(){
		return angles[0];
	}
	public double getYangle(){
		return angles[1];
	}
	public double getZangle(){
		return angles[2];
	}
	public double getXrate(){
		return rates[0];
	}
	public double getYrate(){
		return rates[1];
	}
	public double getZrate(){
		return rates[2];
	}
	
    public void initDefaultCommand() {
    	//setDefaultCommand(new GyroUpdate());
    }
}

