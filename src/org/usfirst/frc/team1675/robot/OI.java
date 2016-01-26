package org.usfirst.frc.team1675.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team1675.robot.commands.ExampleCommand;
import org.usfirst.frc.team1675.robot.commands.MoveWithController;
import org.usfirst.frc.team1675.robot.commands.SetArmPosition;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public static final int OPERATOR_LEFT_Y_AXIS = 1;
	public Joystick operatorstick;
	public JoystickButton operatorButtonA;
	public JoystickButton operatorButtonB;
	
	//home position
	//scoring position

	public OI() {
		operatorstick = new Joystick(0);
		operatorButtonB = new JoystickButton(operatorstick, XBoxControllerMap.A_BUTTON);
		operatorButtonA = new JoystickButton(operatorstick, XBoxControllerMap.B_BUTTON);
		
		operatorButtonA.whenPressed(new SetArmPosition(RobotMap.ArmConstants.HOME_POSITION));//Home Position of Arm
		operatorButtonB.whenPressed(new SetArmPosition(RobotMap.ArmConstants.SCORE_POSITION));//Scoring Position of Arm.
	}

	public double getRawLeftYAxis() {

		double leftYAxisValue = operatorstick.getRawAxis(OPERATOR_LEFT_Y_AXIS);
		leftYAxisValue = checkForDeadzone(leftYAxisValue);
		return leftYAxisValue;

	}

	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	private double checkForDeadzone(double leftYAxisValue) {
		if (leftYAxisValue < 0.1675) {
			return 0;
		} else {
			return leftYAxisValue;
		}
	}

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
};
