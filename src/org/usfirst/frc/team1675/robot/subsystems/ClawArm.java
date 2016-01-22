package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.MoveWithController;

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

	public static final int minimum = 90;
	public static final int maximum = 200;

	public ClawArm() {
		armMotor = new TalonSRX(RobotMap.PMWChannels.EMPTY_PORT_FIVE);
		armSensor = new AnalogPotentiometer(
				RobotMap.DIOChannels.EMPTY_PORT_SEVEN);
		// tells which port the talon is connecting to
	}

	public void moveArm(double speed) {
		double angle = armSensor.get();
		

		if (angle <= minimum  || angle >= maximum) {
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

		setDefaultCommand(new MoveWithController());
	}
}
