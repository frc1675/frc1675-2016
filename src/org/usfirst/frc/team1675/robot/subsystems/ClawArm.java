package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.clawarm.MoveWithController;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ClawArm extends Subsystem {

	private CANTalon armMotor;
	private DigitalInput upLimitSwitch;
	private DigitalInput downLimitSwitch;

	// Visibility (private) Type (SpeedController) Name (armMotor)

	public ClawArm() {
		armMotor = new CANTalon(RobotMap.CANDeviceIDs.CLAW_ARM_MOTOR);
		armMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		armMotor.setPID(RobotMap.ArmConstants.P, RobotMap.ArmConstants.I,
				RobotMap.ArmConstants.D);

		armMotor.changeControlMode(TalonControlMode.PercentVbus);
		armMotor.setInverted(true);
		upLimitSwitch = new DigitalInput(RobotMap.DIOChannels.ARM_UP_LIMIT_SWITCH);
		downLimitSwitch = new DigitalInput(RobotMap.DIOChannels.ARM_DOWN_LIMIT_SWITCH);
	}

	public boolean getLimitValueUp() {
		return upLimitSwitch.get();

	}

	public boolean getLimitValueDown() {
		return downLimitSwitch.get();
	}

	public void moveArm(double speed) {

		SmartDashboard.putBoolean("Top Claw Arm Limit Switch", getLimitValueUp());
		SmartDashboard.putBoolean("Bottom Claw Arm Limit Switch", getLimitValueDown());
		SmartDashboard.putNumber("Lift Arm Power", speed);
		
		
		double angle = armMotor.getPosition();

		armMotor.changeControlMode(TalonControlMode.PercentVbus);

		if (angle >= RobotMap.ArmConstants.MINIMUM
				&& angle <= RobotMap.ArmConstants.MAXIMUM) {
			if (getLimitValueUp() == true) {
				if (speed < 0) {

					armMotor.set(speed);
				} else {
					armMotor.set(0);
				}
			} else if (getLimitValueDown() == true) {
				if (speed > 0) {
					armMotor.set(speed);
				} else {
					armMotor.set(0);
				}

			} else {
				armMotor.set(speed);
			}
		}
	}

	public void setPosition(double position) {

		armMotor.changeControlMode(TalonControlMode.Position);
		armMotor.set(position);

	}

	public void moveWithoutEncoder(double power) {
		SmartDashboard.putNumber("Motor power sent to motor", power);		
		SmartDashboard.putBoolean("Top Claw Arm Limit Switch", getLimitValueUp());
		SmartDashboard.putBoolean("Bottom Claw Arm Limit Switch", getLimitValueDown());				
		if (getLimitValueUp() == true) {
			if (power < 0) {
				armMotor.set(power);
			} else {
				armMotor.set(0);
			}
		} else if (getLimitValueDown() == true) {
			if (power > 0) {
				armMotor.set(power);
			} else {
				armMotor.set(0);
			}

		} else {
			armMotor.set(power);
		}
		SmartDashboard.putNumber("Motor power received by motor", armMotor.get());
	}

	public void initDefaultCommand() {

		setDefaultCommand(new MoveWithController());

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