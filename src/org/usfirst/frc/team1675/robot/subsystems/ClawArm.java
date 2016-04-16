package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.clawarm.MoveWithControllerAcceleration;
import org.usfirst.frc.team1675.robot.utils.AccelerationSpeedController;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class ClawArm extends Subsystem {

	private CANTalon armMotor;
	private AccelerationSpeedController accelerationController;
	private DigitalInput upLimitSwitch;
	private DigitalInput downLimitSwitch;

	// Visibility (private) Type (SpeedController) Name (armMotor)

	public ClawArm(boolean isInverted) {
		armMotor = new CANTalon(RobotMap.CANDeviceIDs.CLAW_ARM_MOTOR);
		accelerationController = new AccelerationSpeedController(armMotor,
				0.10, 160);
		armMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		armMotor.setPID(RobotMap.ArmConstants.P, RobotMap.ArmConstants.I,
				RobotMap.ArmConstants.D);

		armMotor.changeControlMode(TalonControlMode.PercentVbus);
		upLimitSwitch = new DigitalInput(
				RobotMap.DIOChannels.ARM_UP_LIMIT_SWITCH);
		downLimitSwitch = new DigitalInput(
				RobotMap.DIOChannels.ARM_DOWN_LIMIT_SWITCH);
		armMotor.setInverted(isInverted);
	}

	public boolean getLimitValueUp() {
		return upLimitSwitch.get();

	}

	public boolean getLimitValueDown() {
		return downLimitSwitch.get();
	}

	public void moveArm(double speed) {

		
		double angle = armMotor.getPosition();

		armMotor.changeControlMode(TalonControlMode.PercentVbus);

		if (angle >= RobotMap.ArmConstants.MINIMUM
				&& angle <= RobotMap.ArmConstants.MAXIMUM) {
			moveWithinLimitSwitches(armMotor, speed);
		}
	}

	public void setPosition(double position) {

		armMotor.changeControlMode(TalonControlMode.Position);
		armMotor.set(position);

	}

	public void moveWithoutEncoder(double power) {
		
		moveWithinLimitSwitches(armMotor, power);
		
	}

	public void moveWithoutEncoderWithAcceleration(double power) {
		
		moveWithinLimitSwitches(accelerationController, power);
	}

	private void moveWithinLimitSwitches(SpeedController sc, double power) {
		//stuff wired wrong on practice robot fix for competition
		if (getLimitValueUp() == true) {
			if (power < 0) {
				sc.set(power);
			} else {
				sc.set(0);
			}
		} else if (getLimitValueDown() == true) {
			if (power > 0) {
				sc.set(power);
			} else {
				sc.set(0);
			}
		} else {
			sc.set(power);
		}
	}

	public void initDefaultCommand() {

		// setDefaultCommand(new MoveWithController());
		setDefaultCommand(new MoveWithControllerAcceleration());
	}

	public double getPosition() {
		return armMotor.getPosition();

	}
	
	public void clearTheBucket() {
		accelerationController.clearWhileDisabled();
	}

	public void stopAndDisable() {

		armMotor.changeControlMode(TalonControlMode.PercentVbus); // change mode
		// to manual
		armMotor.set(0);
	}
}
