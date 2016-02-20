
package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MoveWithController extends Command {

	public MoveWithController() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.clawArm);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double motorPower = Robot.oi.getOperatorLeftYAxis(RobotMap.ArmConstants.SCALING_VALUE);
		
		System.out.println("Motor power from controller: " + motorPower);
		
//		Robot.clawArm.moveArm(motorPower);
		Robot.clawArm.moveWithoutEncoder(motorPower);
//		SmartDashboard.putNumber("Encoder Position of Arm", Robot.clawArm.getPosition());
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
