package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.clawarm.MoveWithController;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ClawArm extends Subsystem {

	private CANTalon armMotor;

	// Visibility (private) Type (SpeedController) Name (armMotor)

	public ClawArm() {
		armMotor = new CANTalon(RobotMap.CANDeviceIDs.CLAW_ARM_MOTOR);
		armMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		armMotor.setPID(RobotMap.ArmConstants.P, RobotMap.ArmConstants.I,
				RobotMap.ArmConstants.D);

		armMotor.changeControlMode(TalonControlMode.PercentVbus);
	}

	public void moveArm(double speed) {

		double angle = armMotor.getPosition();

		armMotor.changeControlMode(TalonControlMode.PercentVbus);

		if (angle >= RobotMap.ArmConstants.MINIMUM
				&& angle <= RobotMap.ArmConstants.MAXIMUM) {
			armMotor.set(speed);

		} else {
			armMotor.set(0);
		}

	}

	public void setPosition(double position) {

		armMotor.changeControlMode(TalonControlMode.Position);
		armMotor.set(position);

	}
	
	public void moveWithoutEncoder(double power){
		byte b = 2;
					
		SmartDashboard.putNumber("Motor power sent to motor", power);
		armMotor.set(power, b);
		SmartDashboard.putNumber("Motor power received by motor", armMotor.get());		
	}
	

	public void initDefaultCommand() {

		setDefaultCommand(new MoveWithController());

	}
	
	public double getPosition(){
		return armMotor.getPosition();
	
	
}
	public void stopAndDisable() {

		armMotor.changeControlMode(TalonControlMode.PercentVbus); // change mode
																	// to manual
		armMotor.set(0);
	}
}