package org.usfirst.frc.team1675.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class ClawArm extends Subsystem {

	private SpeedController armMotor;
	// Visibility (private) Type (SpeedController) Name (armMotor)
	private Potentiometer armSensor;

	private final int ARM_SENSOR_PORT = 5;
	private final int ARM_MOTOR_PORT = 1;

	public ClawArm() {
		armMotor = new TalonSRX(ARM_MOTOR_PORT);
		armSensor = new AnalogPotentiometer(ARM_SENSOR_PORT);
		// tells which port the talon is connecting to
	}

	public void moveArm(double speed) {
		double angle = armSensor.get();
		int min = 90;
		int max = 200;

		if (angle <= min || angle >= max) {
			armMotor.set(speed);
			// if angle is less or equal to 90 OR if angle is greater or equal
			// to 200, armMotor moves x speed

		} else {
			armMotor.set(0);
			// if angle is greater or equal to 90 OR if angle is less or equal
			// to 200, arm stops
		}

	}

	public void initDefaultCommand() {

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
