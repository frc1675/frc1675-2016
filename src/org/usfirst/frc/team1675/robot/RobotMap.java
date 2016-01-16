package org.usfirst.frc.team1675.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
	
	public final static int ENCODER_LEFT_A_CHANNEL = 1;
	public final static int ENCODER_LEFT_B_CHANNEL = 2;
	
	public final static int ENCODER_RIGHT_A_CHANNEL = 3;
	public final static int ENCODER_RIGHT_B_CHANNEL = 4;
	
	public final static int GYRO_PORT = 8;
	
	public class DriveConstants{
		public final static int FRONT_LEFT_MOTOR_PORT = 1;
		public final static int BACK_LEFT_MOTOR_PORT = 5;
		public final static int MID_LEFT_MOTOR_PORT = 3;
		public final static int FRONT_RIGHT_MOTOR_PORT = 2;
		public final static int MID_RIGHT_MOTOR_PORT = 4;
		public final static int BACK_RIGHT_MOTOR_PORT = 6;
	}
	

}
