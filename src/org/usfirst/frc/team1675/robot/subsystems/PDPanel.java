package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PDPanel extends Subsystem {
	
	private PowerDistributionPanel pdp;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public PDPanel(){
		pdp = new PowerDistributionPanel(RobotMap.CANDeviceIDs.PD_PANEL);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public double getLeftFrontDriveCurrent(){
    	return RobotMap.PDChannels.LEFT_FRONT_DRIVE;
    }
    
    public double getLeftMidDriveCurrent(){
    	return RobotMap.PDChannels.LEFT_MID_DRIVE;
    }
    
    public double getLeftBackDriveCurrent(){
    	return RobotMap.PDChannels.LEFT_BACK_DRIVE;
    }
    
    public double getRightFrontDriveCurrent(){
    	return RobotMap.PDChannels.RIGHT_FRONT_DRIVE;
    }
    
    public double getRightMidDriveCurrent(){
    	return RobotMap.PDChannels.RIGHT_MID_DRIVE;
    }
    
    public double getRightBackDriveCurrent(){
    	return RobotMap.PDChannels.RIGHT_BACK_DRIVE;
    }
    
    public double getClawArmCurrent(){
    	return RobotMap.PDChannels.CLAW_ARM;
    }
    
    public double getClawRollerTopCurrent(){
    	return RobotMap.PDChannels.CLAW_ROLLER_TOP;
    }
    
    public double getClawRollerBottomCurrent(){
    	return RobotMap.PDChannels.CLAW_ROLLER_BOTTOM;
    }
    
    public double getLifterCurrent(){
    	return RobotMap.PDChannels.LIFTER;
    }
}

