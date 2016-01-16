package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.CheeseDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *The Drive base for the 2016 robot
 *
 */
public class DriveBase extends Subsystem {
    
	private SpeedController leftFront;
	private SpeedController leftMid;
	private SpeedController leftBack;
	private SpeedController rightFront;
	private SpeedController rightMid;
	private SpeedController rightBack;
	
	private Encoder leftEncoder;
	private Encoder rightEncoder; 
	
	private Gyro gyro;
	
/*********************************************************************************CONSTRUCTOR************************************************************************************************/
	public DriveBase(){
		leftFront = new TalonSRX(RobotMap.DriveConstants.FRONT_LEFT_MOTOR_PORT);
		leftMid = new TalonSRX(RobotMap.DriveConstants.MID_LEFT_MOTOR_PORT);
		leftBack = new TalonSRX(RobotMap.DriveConstants.BACK_LEFT_MOTOR_PORT);
		rightFront = new TalonSRX(RobotMap.DriveConstants.FRONT_RIGHT_MOTOR_PORT);
		rightMid = new TalonSRX(RobotMap.DriveConstants.MID_RIGHT_MOTOR_PORT);
		rightBack = new TalonSRX(RobotMap.DriveConstants.BACK_RIGHT_MOTOR_PORT);
		
		leftEncoder = new Encoder(RobotMap.ENCODER_LEFT_A_CHANNEL, RobotMap.ENCODER_LEFT_B_CHANNEL);
		rightEncoder = new Encoder(RobotMap.ENCODER_RIGHT_A_CHANNEL, RobotMap.ENCODER_RIGHT_B_CHANNEL);
		
		gyro = new Gyro(RobotMap.GYRO_PORT);
	}
	
/******************************************************************************MOTOR POWER METHODS**********************************************************************************************/	
	
	
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
	
	
	//*****************************************************INDIVIDUAL MOTOR SETTERS***************************************************************/
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
		rightFront.set(speed);
	}
	
	public void setRightMidMotorPower(double speed){
		rightMid.set(speed);
	}
	
	public void setRightBackMotorPower(double speed){
		rightBack.set(speed);
	}
	
	
/**********************************************************************INITCOMMAND****************************************************************************************************/
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CheeseDrive());
    }
}

