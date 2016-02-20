package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.CheeseDrive;
import org.usfirst.frc.team1675.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *The Drive base for the 2016 robot
 *
 */
public class DriveBase extends Subsystem {
    
	private SpeedController leftFront;
	private CANTalon leftMid;
	private SpeedController leftBack;
	private SpeedController rightFront;
	private CANTalon rightMid;
	private SpeedController rightBack;
	
	private Gyro gyro;
	
	public DriveBase(){
		leftFront = new VictorSP(RobotMap.PWMChannels.LEFT_FRONT_MOTOR);
		leftMid = new CANTalon(RobotMap.CANDeviceIDs.LEFT_MOTOR);
		leftBack = new VictorSP(RobotMap.PWMChannels.LEFT_BACK_MOTOR);
		rightFront = new VictorSP(RobotMap.PWMChannels.RIGHT_FRONT_MOTOR);
		rightMid = new CANTalon(RobotMap.CANDeviceIDs.RIGHT_MOTOR);
		rightBack = new VictorSP(RobotMap.PWMChannels.RIGHT_BACK_MOTOR);
		
		gyro = new AnalogGyro(RobotMap.AnalogInChannels.EMPTY_PORT_ZERO);
	}
		
	//sets all of the motor powers on the left side
	public void setLeftMotorPower(double speed){
		setLeftFrontMotorPower(speed);
		setLeftMidMotorPower(speed);
		setLeftBackMotorPower(speed);
		
	}
	
	//sets all of the motor powers on the right side
	public void setRightMotorPower(double speed){
		setRightFrontMotorPower(speed);
		setRightMidMotorPower(speed);
		setRightBackMotorPower(speed);
	}
	
	/**
	 * 
	 * @param speed
	 */
	public void setLeftFrontMotorPower(double speed){
		leftFront.set(speed);
	}
	
	public void setLeftMidMotorPower(double speed){
		leftMid.set(speed);
	}
	
	public void setLeftBackMotorPower(double speed){
		leftBack.set(speed);
	}
	
	public void setRightFrontMotorPower(double speed){
		rightFront.set(-speed);
	}
	
	public void setRightMidMotorPower(double speed){
		rightMid.set(-speed);
	}
	
	public void setRightBackMotorPower(double speed){
		rightBack.set(-speed);
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CheeseDrive());
    }
}

