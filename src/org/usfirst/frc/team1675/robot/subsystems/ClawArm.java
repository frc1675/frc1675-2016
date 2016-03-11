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

	public ClawArm() {
		armMotor = new CANTalon(RobotMap.CANDeviceIDs.CLAW_ARM_MOTOR);
		accelerationController = new AccelerationSpeedController(armMotor,
				0.10, 160);
		armMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		armMotor.setPID(RobotMap.ArmConstants.P, RobotMap.ArmConstants.I,
				RobotMap.ArmConstants.D);

		armMotor.changeControlMode(TalonControlMode.PercentVbus);
		armMotor.setInverted(false);
		upLimitSwitch = new DigitalInput(
				RobotMap.DIOChannels.ARM_UP_LIMIT_SWITCH);
		downLimitSwitch = new DigitalInput(
				RobotMap.DIOChannels.ARM_DOWN_LIMIT_SWITCH);
	}

	public boolean getLimitValueUp() {
		return upLimitSwitch.get();

	}

	public boolean getLimitValueDown() {
		return downLimitSwitch.get();
	}

	public void moveArm(double speed) {

		SmartDashboard.putBoolean("Top Claw Arm Limit Switch",
				getLimitValueUp());
		SmartDashboard.putBoolean("Bottom Claw Arm Limit Switch",
				getLimitValueDown());
		SmartDashboard.putNumber("Lift Arm Power", speed);

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
		SmartDashboard.putNumber("Motor power sent to motor", power);
		SmartDashboard.putBoolean("Top Claw Arm Limit Switch",
				getLimitValueUp());
		SmartDashboard.putBoolean("Bottom Claw Arm Limit Switch",
				getLimitValueDown());
		moveWithinLimitSwitches(armMotor, power);
		SmartDashboard.putNumber("Motor power received by motor",
				armMotor.get());
	}

	public void moveWithoutEncoderWithAcceleration(double power) {
		SmartDashboard.putNumber("Motor power sent to motor", power);
		SmartDashboard.putBoolean("Top Claw Arm Limit Switch",
				getLimitValueUp());
		SmartDashboard.putBoolean("Bottom Claw Arm Limit Switch",
				getLimitValueDown());
		SmartDashboard.putNumber("Encoder Value", armMotor.getPosition());
		moveWithinLimitSwitches(accelerationController, power);
		SmartDashboard.putNumber("Motor power received by motor",
				accelerationController.get());
	}

	private void moveWithinLimitSwitches(SpeedController sc, double power) {
		if (getLimitValueUp() == true) {
			if (power > 0) {
				sc.set(power);
			} else {
				sc.set(0);
			}
		} else if (getLimitValueDown() == true) {
			if (power < 0) {
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

	public void stopAndDisable() {

		armMotor.changeControlMode(TalonControlMode.PercentVbus); // change mode
		// to manual
		armMotor.set(0);
	}
}