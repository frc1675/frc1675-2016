package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftArm extends Subsystem {
    
	private SpeedController armMotor;
	private DigitalInput upLimitSwitch;
	private DigitalInput downLimitSwitch;

	public LiftArm(){
		armMotor = new VictorSP(RobotMap.PMWChannels.EMPTY_PORT_ZERO);
		upLimitSwitch = new DigitalInput(RobotMap.DIOChannels.EMPTY_PORT_ZERO);
		downLimitSwitch = new DigitalInput(RobotMap.DIOChannels.EMPTY_PORT_ZERO); 
	}
	
	public boolean getLimitValueUp(){
		return upLimitSwitch.get();
	}
	
	public boolean getLimitValueDown(){
		return downLimitSwitch.get();
	}
	
	public void moveArm(double power){
		armMotor.set(power);
	}
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

