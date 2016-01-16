package org.usfirst.frc.team1675.robot.subsystems;



import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class ClawArm extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private SpeedController armMotor;
	//visibility type name
	private Potentiometer armSensor;

	private final int ARM_SENSOR_PORT = 5;
	private final int ARM_MOTOR_PORT = 1;

	public ClawArm() {
		armMotor = new TalonSRX(ARM_MOTOR_PORT);
		armSensor = new AnalogPotentiometer ( ARM_SENSOR_PORT);
		//tells which port the talon is connecting to
	}
	public void moveArm( double speed){
		double angle = armSensor.get();
		int min = 90;
		int max = 200;
		
		if(angle >= min && angle <= max){
			armMotor.set(speed);
			
		}else
		{
			armMotor.set(0);
		}
				
		
	}

	public void initDefaultCommand() {
		
		
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}