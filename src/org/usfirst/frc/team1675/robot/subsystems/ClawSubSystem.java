package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawSubSystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private SpeedController rollerTop;
	private SpeedController rollerBottom;

	public ClawSubSystem() {
		rollerTop = new VictorSP(RobotMap.PMWChannels.EMPTY_PORT_SEVEN);
		rollerBottom = new VictorSP(RobotMap.PMWChannels.EMPTY_PORT_EIGHT);
	}

	public void setRollerInPower(double value) {
		rollerTop.set(value);
		rollerBottom.set(-value);
	}

	public void setRollerOutPower(double value) {
		rollerTop.set(value);
		rollerBottom.set(-value);

	}

	public boolean hasBall() {
		
//		if (buttonA.isPressed) { // buttonA is filler until we have controller
//									// map
//			return true;
//		} else
		return false;
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
