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
		armMotor.setInverted(true);
		upLimitSwitch = new DigitalInput(RobotMap.DIOChannels.EMPTY_PORT_NINE);
		downLimitSwitch = new DigitalInput(RobotMap.DIOChannels.EMPTY_PORT_EIGHT);
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
		SmartDashboard.putNumber("Lift Arm Power", power);
			
		
		
		
		if(getLimitValueUp() == true){			
			if(power < 0){
				armMotor.set(power);
			}else{
				armMotor.set(0);
			}			
		}
		else if(getLimitValueDown() == true){			
			if(power > 0){
				armMotor.set(power);
			}else{
				armMotor.set(0);
			}			
		}		
		else{
			armMotor.set(power);			
		}
		
				
		
//		if (getLimitValueUp() == true ){
//			
//			if(power > 0 ){
//				armMotor.set(power);
//			}else{
//				armMotor.set(0);
//			}
//			
//		}else if(getLimitValueDown() == true){
//			
//			if(power < 0){
//				armMotor.set(power);
//			}else{
//				armMotor.set(0);
//			}
//			
//		}		
//		else {
//			armMotor.set(power);
//
//		}

	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {

		setDefaultCommand(new MoveLiftArmManual());

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
