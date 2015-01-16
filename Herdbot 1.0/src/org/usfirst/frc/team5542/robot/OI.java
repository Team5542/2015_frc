package org.usfirst.frc.team5542.robot;

import org.usfirst.frc.team5542.robot.commands.FprDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //Controller layout
	Joystick controller = new Joystick(0);
	Button aButton = new JoystickButton(controller, 1);
	Button bButton = new JoystickButton(controller, 2);
	Button xButton = new JoystickButton(controller, 3);
	Button yButton = new JoystickButton(controller, 4);
	Button lBumper = new JoystickButton(controller, 5);
	Button rBumper = new JoystickButton(controller, 6);
	Button select = new JoystickButton(controller, 7);
	Button start = new JoystickButton(controller, 8);
	Button lStick = new JoystickButton(controller, 9);
	Button rStick = new JoystickButton(controller, 10);

	//axis map
	public static final int lxAxis = 0;
	public static final int lyAxis = 5;
	public static final int rxAxis = 4;
	public static final int ryAxis = 1;
	public static final int rTrigger = 2;
	public static final int lTrigger = 3;
	public static final int dPad = 6;
	
	//stick sensitivity curve
	public static final double sensitivity = 1.5;
	
	//accessor for controller
	public Joystick getController(){
		return controller;
	}
	
	//constructor
	public OI(){
		start.toggleWhenPressed(new FprDrive());
	}
	
	//// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

