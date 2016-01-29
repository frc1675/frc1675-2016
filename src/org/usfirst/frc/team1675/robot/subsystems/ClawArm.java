package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.MoveWithController;
import org.usfirst.frc.team1675.robot.commands.SetArmPosition;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ClawArm extends PIDSubsystem {

	private SpeedController armMotor;
	// Visibility (private) Type (SpeedController) Name (armMotor)
	private Encoder armSensor;

	public ClawArm() {
		super(RobotMap.ArmConstants.P, RobotMap.ArmConstants.I,
				RobotMap.ArmConstants.D);

		armMotor = new TalonSRX(RobotMap.PWMChannels.ARM_MOTOR);
		armSensor = new Encoder(RobotMap.DIOChannels.ARM_ENCODER_CHANNEL_A,
				RobotMap.DIOChannels.ARM_ENCODER_CHANNEL_B);
		// tells which port the talon is connecting to

	}

	public void moveArm(double speed) {

		double angle = armSensor.get();

		if (angle >= RobotMap.ArmConstants.MINIMUM
				|| angle <= RobotMap.ArmConstants.MAXIMUM) {
			armMotor.set(speed);
			// if the angle is less or equal to 90 OR if angle is greater or
			// equal
			// to 200, armMotor moves x speed

		} else {
			armMotor.set(0);
			// if not then the robot stops
		}

	}

	public void setPosition(double position) {
		this.setSetpoint(position);
		this.enable();

	}

	protected double returnPIDInput() {

		// SmartDashboard.putNumber("EncoderPosition", armSensor.get());
		return armSensor.get();
	}

	protected void usePIDOutput(double output) {
		// SmartDashboard.putNumber("MotorPower", output);
		armMotor.set(output);
	}

	public void initDefaultCommand() {

		setDefaultCommand(new MoveWithController());

	}

	public void stopAndDisable() {

		this.disable();
		armMotor.set(0);
	}
}