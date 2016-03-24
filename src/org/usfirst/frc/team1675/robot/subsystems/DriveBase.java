package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.drivebase.CheeseDrive;
import org.usfirst.frc.team1675.robot.commands.drivebase.TankDrive;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The Drive base for the 2016 robot
 *
 */
public class DriveBase extends Subsystem {

	private SpeedController leftFront;
	private CANTalon leftMid;
	private SpeedController leftBack;
	private SpeedController rightFront;
	private CANTalon rightMid;
	private SpeedController rightBack;

	private AHRS ahrs;
	
	private boolean inCheeseDrive;

	public DriveBase() {
		leftFront = new VictorSP(RobotMap.PWMChannels.LEFT_FRONT_MOTOR);
		leftMid = new CANTalon(RobotMap.CANDeviceIDs.LEFT_MOTOR);
		leftBack = new VictorSP(RobotMap.PWMChannels.LEFT_BACK_MOTOR);
		rightFront = new VictorSP(RobotMap.PWMChannels.RIGHT_FRONT_MOTOR);
		rightMid = new CANTalon(RobotMap.CANDeviceIDs.RIGHT_MOTOR);
		rightBack = new VictorSP(RobotMap.PWMChannels.RIGHT_BACK_MOTOR);

		ahrs = new AHRS(SerialPort.Port.kMXP);
		
		inCheeseDrive = true;
	}

	// sets all of the motor powers on the left side
	public void setLeftMotorPower(double speed) {
		speed = advancedMotorDeadzone(speed);
		setLeftFrontMotorPower(speed);
		setLeftMidMotorPower(speed);
		setLeftBackMotorPower(speed);
	}

	// sets all of the motor powers on the right side
	public void setRightMotorPower(double speed) {
		speed = advancedMotorDeadzone(speed);
		setRightFrontMotorPower(speed);
		setRightMidMotorPower(speed);
		setRightBackMotorPower(speed);
	}

	/**
	 * 
	 * @param speed
	 */
	public void setLeftFrontMotorPower(double speed) {
		leftFront.set(speed);
	}

	public void setLeftMidMotorPower(double speed) {
		leftMid.set(speed);
	}

	public void setLeftBackMotorPower(double speed) {
		leftBack.set(speed);
	}

	public void setRightFrontMotorPower(double speed) {
		rightFront.set(-speed);
	}

	public void setRightMidMotorPower(double speed) {
		rightMid.set(-speed);
	}

	public void setRightBackMotorPower(double speed) {
		rightBack.set(-speed);
	}

	public void setTalonsToVoltageMode() {
		leftMid.changeControlMode(TalonControlMode.PercentVbus);
		rightMid.changeControlMode(TalonControlMode.PercentVbus);
	}

	public double getAngle() {
		return ahrs.getAngle();
	}

	public void resetGyro() {
		ahrs.reset();
	}

	private double advancedMotorDeadzone(double vector) {
		double power = (vector / Math.abs(vector))
				* ((1 - RobotMap.DriveBaseConstants.DRIVE_BASE_MOTOR_DEAD_ZONE) * (Math
						.abs(vector) + RobotMap.DriveBaseConstants.DRIVE_BASE_MOTOR_DEAD_ZONE));
		return power;

	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
//		setDefaultCommand(new TankDrive());
		setDefaultCommand(new CheeseDrive());
	}

	public int getEncPosition() {
		// On practice bot only right side encoder works.
		return rightMid.getEncPosition();
	}
	
	public void changeDriveMode(){
		if(inCheeseDrive){
			inCheeseDrive = false;
			setDefaultCommand(new TankDrive());
			new TankDrive().start();
		}else{
			inCheeseDrive = true;
			setDefaultCommand(new CheeseDrive());
			new CheeseDrive().start();
		}
	}
}
