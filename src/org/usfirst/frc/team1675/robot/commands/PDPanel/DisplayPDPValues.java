package org.usfirst.frc.team1675.robot.commands.PDPanel;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DisplayPDPValues extends Command {

    public DisplayPDPValues() {
    	requires(Robot.pdPanel);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(RobotMap.PDPanelConstants.ALL_MOTORS){
    		SmartDashboard.putNumber("LF Drive Current", Robot.pdPanel.getLeftFrontDriveCurrent());
    		SmartDashboard.putNumber("LM Drive Current", Robot.pdPanel.getLeftMidDriveCurrent());
    		SmartDashboard.putNumber("LB Drive Current", Robot.pdPanel.getLeftBackDriveCurrent());
    		SmartDashboard.putNumber("RF Drive Current", Robot.pdPanel.getRightFrontDriveCurrent());
    		SmartDashboard.putNumber("RM Drive Current", Robot.pdPanel.getRightMidDriveCurrent());
    		SmartDashboard.putNumber("RB Drive Current", Robot.pdPanel.getRightBackDriveCurrent());
    		SmartDashboard.putNumber("Claw Arm Current", Robot.pdPanel.getClawArmCurrent());
    		SmartDashboard.putNumber("Top Roller Drive Current", Robot.pdPanel.getClawRollerTopCurrent());
    		SmartDashboard.putNumber("Bottom Roller Current", Robot.pdPanel.getClawRollerBottomCurrent());
    		SmartDashboard.putNumber("Lifter Current", Robot.pdPanel.getLifterCurrent());
    	}else{
    		if(RobotMap.PDPanelConstants.DRIVE_MOTORS){
    			SmartDashboard.putNumber("LF Drive Current", Robot.pdPanel.getLeftFrontDriveCurrent());
        		SmartDashboard.putNumber("LM Drive Current", Robot.pdPanel.getLeftMidDriveCurrent());
        		SmartDashboard.putNumber("LB Drive Current", Robot.pdPanel.getLeftBackDriveCurrent());
        		SmartDashboard.putNumber("RF Drive Current", Robot.pdPanel.getRightFrontDriveCurrent());
        		SmartDashboard.putNumber("RM Drive Current", Robot.pdPanel.getRightMidDriveCurrent());
        		SmartDashboard.putNumber("RB Drive Current", Robot.pdPanel.getRightBackDriveCurrent());
    		}
    		
    		if(RobotMap.PDPanelConstants.CLAW_MOTORS){
    			SmartDashboard.putNumber("Claw Arm Current", Robot.pdPanel.getClawArmCurrent());
        		SmartDashboard.putNumber("Top Roller Drive Current", Robot.pdPanel.getClawRollerTopCurrent());
        		SmartDashboard.putNumber("Bottom Roller Current", Robot.pdPanel.getClawRollerBottomCurrent());
    		}
    		
    		if(RobotMap.PDPanelConstants.LIFTER_MOTOR){
    			SmartDashboard.putNumber("Lifter Current", Robot.pdPanel.getLifterCurrent());
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
