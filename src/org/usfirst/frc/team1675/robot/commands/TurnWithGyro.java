package org.usfirst.frc.team1675.robot.commands;

import java.security.spec.DSAGenParameterSpec;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnWithGyro extends PIDCommand {

	
	private static final double kP = 0.012;
	private static final double kI = 0;
	private static final double kD = 0;
	
	private static final double TOLERANCE = 5.0;
	
	double degreesSetpoint;
	
    public TurnWithGyro(double degreesSetpoint) {
    	super(kP, kI, kD);
        requires(Robot.driveBase);
        Robot.driveBase.resetGyro();
        this.degreesSetpoint = degreesSetpoint;
        this.getPIDController().setInputRange(0.0, 360.0);
        this.getPIDController().setOutputRange(-1.0, 1.0);
        this.getPIDController().setAbsoluteTolerance(5.0);
        this.getPIDController().setContinuous(true);
        
    	this.getPIDController().setSetpoint(degreesSetpoint);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveBase.setTalonsToVoltageMode();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println("error: " + this.getPIDController().getError());
    	System.out.println("on target? " + this.getPIDController().onTarget());
    	
    	boolean returnVal = false;
    	
    	if(Math.abs(this.getPIDController().getError()) < TOLERANCE){
    		returnVal = true;
    	}
    	
        return returnVal;
    }

    // Called once after isFinished returns true
    protected void end() {
    	this.getPIDController().disable();
    	Robot.driveBase.setLeftMotorPower(0.0);
		Robot.driveBase.setRightMotorPower(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

	@Override
	protected double returnPIDInput() {
		return Robot.driveBase.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		SmartDashboard.putNumber("Gyro Turn PIDOut", output);
		SmartDashboard.putNumber("Gyro Angle", Robot.driveBase.getAngle());
		Robot.driveBase.setLeftMotorPower(output);
		Robot.driveBase.setRightMotorPower(-output);
		
	}
}
