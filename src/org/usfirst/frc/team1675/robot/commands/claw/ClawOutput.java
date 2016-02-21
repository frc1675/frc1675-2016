package org.usfirst.frc.team1675.robot.commands.claw;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClawOutput extends Command {

    public ClawOutput() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.clawSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.clawSub.setRollerOutPower(-1); //Set actual value later. -1 is a filler (opposite of intake)
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.clawSub.hasBall() == false){//Improve by adding something like "button.pressed() &&..."
    		return false;
    	} else{
    		return true;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.clawSub.setRollerOutPower(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
