package org.usfirst.frc.team1675.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	
	
	
	
	
	
	private Joystick driveStick;
	
	private JoystickButton driverRightBumperButton;
	private JoystickButton driverLeftBumperButton;
	
	public OI(){
		
		driveStick = new Joystick(XBoxControllerMap.DRIVER_PORT);
		
		driverRightBumperButton = new JoystickButton(driveStick, XBoxControllerMap.RIGHT_BUMPER_BUTTON);
		driverLeftBumperButton = new JoystickButton(driveStick, XBoxControllerMap.LEFT_BUMPER_BUTTON);
		
		
	}
	
	public double getLeftYAxis(){
		double leftYAxisValue = driveStick.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
		leftYAxisValue = check4DeadZone(leftYAxisValue);
		return leftYAxisValue;
		
	}
	public double getRightXAxis(){
		double rightXAxisValue = driveStick.getRawAxis(XBoxControllerMap.RIGHT_X_AXIS);
		rightXAxisValue = check4DeadZone(rightXAxisValue);
		return rightXAxisValue;
		
	}
	
	public double getRightYAxis(){
		double rightYAxisValue = driveStick.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);
		rightYAxisValue = check4DeadZone(rightYAxisValue);
		return rightYAxisValue;
	}
	public double getLeftXAxis(){
		double LeftXAxisValue = driveStick.getRawAxis(XBoxControllerMap.LEFT_X_AXIS);
		LeftXAxisValue = check4DeadZone(LeftXAxisValue);
		return LeftXAxisValue;
	}
	
	public double check4DeadZone(double value){
		if(Math.abs(value)<XBoxControllerMap.DEAD_ZONE){
			return 0;
		}
		else{
			return value;
		}
		
	}
   
	public boolean isRightBumperPressed(){
		return driverRightBumperButton.get();
	}
}

