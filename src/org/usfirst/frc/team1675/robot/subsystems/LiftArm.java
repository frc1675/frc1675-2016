package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.liftarm.MoveLiftArmManual;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LiftArm extends Subsystem {

	private SpeedController armMotor;
	private DigitalInput upLimitSwitch;
	private DigitalInput downLimitSwitch;

	public LiftArm() {
		armMotor = new VictorSP(RobotMap.PWMChannels.EMPTY_PORT_ZERO);
		upLimitSwitch = new DigitalInput(RobotMap.DIOChannels.EMPTY_PORT_FOUR);
		downLimitSwitch = new DigitalInput(RobotMap.DIOChannels.EMPTY_PORT_ZERO);
	}

	public boolean getLimitValueUp() {
		return upLimitSwitch.get();
	}

	public boolean getLimitValueDown() {
		return downLimitSwitch.get();
	}

	public void moveArm(double power) { 
		SmartDashboard.putBoolean("Top Limit Switch", getLimitValueUp());
		SmartDashboard.putBoolean("Bottom Limit Switch", getLimitValueDown());
		if (getLimitValueUp() == true || getLimitValueDown() == true) {
			armMotor.set(0);

		} else {
			armMotor.set(power);

		}

	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {

		setDefaultCommand(new MoveLiftArmManual());

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
