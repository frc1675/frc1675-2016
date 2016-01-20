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
	
	public DriveBase(){
		leftFront = new TalonSRX(RobotMap.PMWChannels.EMPTY_PORT_ZERO);
		leftMid = new TalonSRX(RobotMap.PMWChannels.EMPTY_PORT_ZERO);
		leftBack = new TalonSRX(RobotMap.PMWChannels.EMPTY_PORT_ZERO);
		rightFront = new TalonSRX(RobotMap.PMWChannels.EMPTY_PORT_ZERO);
		rightMid = new TalonSRX(RobotMap.PMWChannels.EMPTY_PORT_ZERO);
		rightBack = new TalonSRX(RobotMap.PMWChannels.EMPTY_PORT_ZERO);
		
		leftEncoder = new Encoder(RobotMap.PMWChannels.EMPTY_PORT_ZERO, RobotMap.PMWChannels.EMPTY_PORT_ZERO);
		rightEncoder = new Encoder(RobotMap.PMWChannels.EMPTY_PORT_ZERO, RobotMap.PMWChannels.EMPTY_PORT_ZERO);
		
		gyro = new Gyro(RobotMap.PMWChannels.EMPTY_PORT_ZERO);
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
		rightFront.set(speed);
	}
	
	public void setRightMidMotorPower(double speed){
		rightMid.set(speed);
	}
	
	public void setRightBackMotorPower(double speed){
		rightBack.set(speed);
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CheeseDrive());
    }
}

