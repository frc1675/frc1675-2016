package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.MoveWithController;
import org.usfirst.frc.team1675.robot.commands.SetArmPosition;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ClawArm extends PIDSubsystem {

	private SpeedController armMotor;
	// Visibility (private) Type (SpeedController) Name (armMotor)
	private Encoder armSensor;

	public static final int minimum = 90;
	public static final int maximum = 200;
	
	public static final double p = 0.01;
	public static final double i = 0;
	public static final double d = 0;
	
	public ClawArm() {
		super(p, i, d);

		armMotor = new TalonSRX(RobotMap.PMWChannels.EMPTY_PORT_SIX);
		armSensor = new Encoder(RobotMap.DIOChannels.EMPTY_PORT_ZERO,
				RobotMap.DIOChannels.EMPTY_PORT_ONE);
		// tells which port the talon is connecting to

	}

	public void moveArm(double speed) {

		double angle = armSensor.get();

		if (angle >= minimum || angle <= maximum) {
			armMotor.set(speed);
			// if angle is less or equal to 90 OR if angle is greater or equal
			// to 200, armMotor moves x speed

		} else {
			armMotor.set(0);
			// if angle is greater or equal to 90 OR if angle is less or equal
			// to 200, arm stops
		}

	}

	public void setPosition(double position) {
		this.setSetpoint(position);
		this.enable();

	}

	protected double returnPIDInput() {

		//SmartDashboard.putNumber("EncoderPosition", armSensor.get());
		return armSensor.get();
	}

	protected void usePIDOutput(double output) {
		//SmartDashboard.putNumber("MotorPower", output);
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