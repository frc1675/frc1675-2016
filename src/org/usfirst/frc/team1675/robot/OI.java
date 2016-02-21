package org.usfirst.frc.team1675.robot;

import org.usfirst.frc.team1675.robot.commands.liftarm.MoveLiftArmToDown;
import org.usfirst.frc.team1675.robot.commands.liftarm.MoveLiftArmToHome;
import org.usfirst.frc.team1675.robot.utils.DPadButton;
import org.usfirst.frc.team1675.robot.utils.TriggerButton;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

	private Joystick driverController = new Joystick(XBoxControllerMap.driverControllerPort);
	private JoystickButton driverAButton = new JoystickButton(driverController, XBoxControllerMap.driverControllerPort);
	private JoystickButton driverBButton = new JoystickButton(driverController, XBoxControllerMap.driverControllerPort);
	private JoystickButton driverYButton = new JoystickButton(driverController, XBoxControllerMap.driverControllerPort);
	private JoystickButton driverXButton = new JoystickButton(driverController, XBoxControllerMap.driverControllerPort);
	private DPadButton driverDPadRight = new DPadButton(driverController, DPadButton.Direction.RIGHT);
	private DPadButton driverDPadLeft = new DPadButton(driverController, DPadButton.Direction.LEFT);
	private DPadButton driverDPadUp = new DPadButton(driverController, DPadButton.Direction.UP);
	private DPadButton driverDPadDown = new DPadButton(driverController, DPadButton.Direction.DOWN);
	private JoystickButton driverRightBumper = new JoystickButton(driverController, XBoxControllerMap.driverControllerPort);
	private JoystickButton driverLeftBumper = new JoystickButton(driverController, XBoxControllerMap.driverControllerPort);
	

	private TriggerButton driverRightTrigger = new TriggerButton(driverController, true, RobotMap.DriverConstants.TRIGGER_DEAD_ZONE);
	private TriggerButton driverrLeftTrigger = new TriggerButton(driverController, false, RobotMap.DriverConstants.TRIGGER_DEAD_ZONE);

	
	
	private Joystick operatorController = new Joystick(XBoxControllerMap.operatorControllerPort);
	private JoystickButton operatorAButton = new JoystickButton(operatorController, XBoxControllerMap.operatorControllerPort);
	private JoystickButton operatorBButton = new JoystickButton(operatorController, XBoxControllerMap.operatorControllerPort);
	private JoystickButton operatorYButton = new JoystickButton(operatorController, XBoxControllerMap.operatorControllerPort);
	private JoystickButton operatorXButton = new JoystickButton(operatorController, XBoxControllerMap.operatorControllerPort);
	private DPadButton operatorDPadRight = new DPadButton(operatorController, DPadButton.Direction.RIGHT);
	private DPadButton operatorDPadLeft = new DPadButton(operatorController, DPadButton.Direction.LEFT);
	private DPadButton operatorDPadUp = new DPadButton(operatorController, DPadButton.Direction.UP);
	private DPadButton operatorDPadDown = new DPadButton(operatorController, DPadButton.Direction.DOWN);
	
	private JoystickButton operatorRightBumper = new JoystickButton(operatorController, XBoxControllerMap.operatorControllerPort);
	private JoystickButton operatorLeftBumper = new JoystickButton(operatorController, XBoxControllerMap.operatorControllerPort);

	private TriggerButton operatorRightTrigger = new TriggerButton(operatorController, true, RobotMap.DriverConstants.TRIGGER_DEAD_ZONE);
	private TriggerButton operatorLeftTrigger = new TriggerButton(operatorController, false, RobotMap.DriverConstants.TRIGGER_DEAD_ZONE);

	public OI(){
		operatorAButton.whenPressed(new MoveLiftArmToHome());
		operatorBButton.whenPressed(new MoveLiftArmToDown());
		

	}
	
	
	
	public double getDriverLeftXAxis() {
		double leftXControllerValue = driverController.getRawAxis(XBoxControllerMap.LEFT_X_AXIS);
		return checkForDeadzone(leftXControllerValue);

	}
	
	public double getDriverLeftXAxisWODeadzone(){
		double leftXControllerValue = driverController.getRawAxis(XBoxControllerMap.LEFT_X_AXIS);
		return leftXControllerValue;
	}
	public double getDriverLeftYAxis() {
		double leftYControllerValue = driverController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
		return checkForDeadzone(leftYControllerValue);
	}
	
	public double getDriverLeftYAxisWODeadzone() {
		double leftYControllerValue = driverController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
		return leftYControllerValue;
	}
	public double getDriverRightXAxis() {
		double rightXControllerValue = driverController.getRawAxis(XBoxControllerMap.RIGHT_X_AXIS);
		return checkForDeadzone(rightXControllerValue);
	}
	
	public double getDriverRightXAxisWODeadzone() {
		double rightXControllerValue = driverController.getRawAxis(XBoxControllerMap.RIGHT_X_AXIS);
		return rightXControllerValue;
	}
	
	public double getDriverRightYAxis() {
		double rightYControllerValue = driverController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);
		return checkForDeadzone(rightYControllerValue);
	}
	
	public double getDriverRightYAxisWODeadzone() {
		double rightYControllerValue = driverController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);
		return rightYControllerValue;
	}
	

	public double getDriverLeftTrigger(double scaleValue){
		double leftTriggerValue = driverController.getRawAxis(XBoxControllerMap.LEFT_TRIGGER_AXIS);
		leftTriggerValue = checkForDeadzone(leftTriggerValue);
		return (-leftTriggerValue * scaleValue);
	}


	public double getDriverRightTrigger(double scaleValue){
		double rightTriggerValue = driverController.getRawAxis(XBoxControllerMap.RIGHT_TRIGGER_AXIS);
		rightTriggerValue = checkForDeadzone(rightTriggerValue);
		return (rightTriggerValue * scaleValue);
	}
	
	public double getOperatorLeftYAxis(double scaleValue){
		double leftYControllerValue = operatorController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
		leftYControllerValue = checkForDeadzone(leftYControllerValue);
		return (leftYControllerValue * scaleValue);
	}
	public double getOperatorLeftXAxis(double scaleValue){
		double leftXControllerValue = operatorController.getRawAxis(XBoxControllerMap.LEFT_X_AXIS);
		leftXControllerValue = checkForDeadzone(leftXControllerValue);
		return (leftXControllerValue * scaleValue);
	}
	
	public double getOperatorRightYAxis(double scaleValue){
		double rightYControllerValue = operatorController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);
		double deadzonedValue = checkForDeadzone(rightYControllerValue);
		double scaledDeadzonedValue = deadzonedValue*scaleValue;
		return scaledDeadzonedValue;
	}
	
	public double getOperatorRightXAxis(double scaleValue){
		double rightXControllerValue = operatorController.getRawAxis(XBoxControllerMap.RIGHT_X_AXIS);
		return checkForDeadzone(rightXControllerValue * scaleValue);
	}
	
	public double checkForDeadzone(double input) {
		if (Math.abs(input) <= RobotMap.DriverConstants.DEAD_ZONE_TOLERANCE) {
			return 0.0;
		} else {
			return deadzone( input);
		}
	}

	public double deadzone(double input){
		if(Math.abs(input) <= RobotMap.DriverConstants.DEAD_ZONE_TOLERANCE){
			return 0;		
		}
		return input;
	}
}