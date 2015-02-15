package org.usfirst.frc.team5542.robot;

import org.usfirst.frc.team5542.robot.commands.*;

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
	public static final int lyAxis = 1;
	public static final int rxAxis = 4;
	public static final int ryAxis = 5;
	public static final int rTrigger = 3;
	public static final int lTrigger = 2;
	public static final int dPad = 0;
	
	
	//Joystick layout
	Joystick stick = new Joystick(1);
	Button trigger = new JoystickButton(stick, 1);
	Button thumb = new JoystickButton(stick, 2);
	Button b3 = new JoystickButton(stick, 3);
	Button b4 = new JoystickButton(stick, 4);
	Button b5 = new JoystickButton(stick, 5);
	Button b6 = new JoystickButton(stick, 6);
	Button b7 = new JoystickButton(stick, 7);
	Button b8 = new JoystickButton(stick, 8);
	Button b9 = new JoystickButton(stick, 9);
	Button b10 = new JoystickButton(stick, 10);
	Button b11 = new JoystickButton(stick, 11);
	Button b12 = new JoystickButton(stick, 12);
	
	
	//Joystick axis map
	public static final int stickX = 0;
	public static final int stickY = 1;
	public static final int stickZ = 2;
	public static final int slider = 3;
	public static final int pov = 0;
	
	
	//stick sensitivity curve (creates a graph with y=x^(sensitivity) where x = controller input y = motor output)
	public static final double sensitivity = 1.5;
	
	//accessor for controller
	public Joystick getController(){
		return controller;
	}
	public Joystick getJoystick(){
		return stick;
	}
	
	private static boolean xBox;
	public static void switchController(){
		xBox = !xBox;
	}
	public static boolean getxBox(){
		return xBox;
	}
	
	//constructor
	public OI(){
		xBox = true;
		//start.whenPressed(new ToggleDrive());
		select.whenPressed(new SwitchController());
		b12.whenPressed(new SwitchController());
		{
			bButton.whenPressed(new CenterCamera());
			aButton.whileHeld(new OpenMotor());
			//rBumper.whenPressed(new ArmUp());
			//lBumper.whenPressed(new ArmDown());
			//aButton.whenPressed(new SwitchCan());
		}
		{
			b4.whenPressed(new CenterCamera());
			//trigger.whenPressed(new ArmUp());
			//thumb.whenPressed(new ArmDown());
			//b3.whenPressed(new SwitchCan());
		}
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
