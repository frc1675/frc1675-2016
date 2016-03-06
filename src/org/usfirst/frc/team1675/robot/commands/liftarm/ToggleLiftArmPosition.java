package org.usfirst.frc.team1675.robot.commands.liftarm;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleLiftArmPosition extends Command {
	
	int value = 0;

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.liftArm.getLimitValueUp() == true){
    		Robot.liftArm.moveArm(-1);
    		value = -1;
    	}
    	else if (Robot.liftArm.getLimitValueDown() == true){
    		Robot.liftArm.moveArm(1);
    		value = 1;
    	}
    	else if(Robot.liftArm.getLimitValueUp() == false && Robot.liftArm.getLimitValueDown() == false){
    		Robot.liftArm.moveArm(value);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if((Robot.liftArm.getLimitValueUp() == true && value == 1) || (Robot.liftArm.getLimitValueDown() && value == -1)){
    		return true;
    	} else {
        return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.liftArm.moveArm(0);
    	value = 0;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
