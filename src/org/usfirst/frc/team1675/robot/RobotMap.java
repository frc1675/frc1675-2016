package org.usfirst.frc.team1675.robot;

public class RobotMap {

	public static class PWMChannels {
		public static final int EMPTY_PORT_ZERO = 0;
		public static final int RIGHT_BACK_MOTOR = 1;
		public static final int RIGHT_FRONT_MOTOR = 2;
		public static final int LEFT_FRONT_MOTOR = 3;
		public static final int EMPTY_PORT_FOUR = 4;
		public static final int EMPTY_PORT_FIVE = 5;
		public static final int EMPTY_PORT_SIX = 6;
		public static final int EMPTY_PORT_SEVEN = 7;
		public static final int EMPTY_PORT_EIGHT = 8;
		public static final int LEFT_BACK_MOTOR = 9;

	}
	public static class CANDeviceIDs{
		public static final int PD_PANEL = 0;
		public static final int CLAW_ARM_MOTOR = 1;
		public static final int LEFT_MOTOR = 3;
		public static final int RIGHT_MOTOR = 2;
		
	}

	public static class PDChannels {
		public static final int EMPTY_PORT_ZERO = 0;
		public static final int EMPTY_PORT_ONE = 1;
		public static final int EMPTY_PORT_TWO = 2;
		public static final int EMPTY_PORT_THREE = 3;
		public static final int EMPTY_PORT_FOUR = 4;
		public static final int EMPTY_PORT_FIVE = 5;
		public static final int EMPTY_PORT_SIX = 6;
		public static final int EMPTY_PORT_SEVEN = 7;
		public static final int EMPTY_PORT_EIGHT = 8;
		public static final int EMPTY_PORT_NINE = 9;
		public static final int EMPTY_PORT_TEN = 10;
		public static final int EMPTY_PORT_ELEVEN = 11;
		public static final int EMPTY_PORT_TWELVE = 12;
		public static final int EMPTY_PORT_THIRTEEN = 13;
		public static final int EMPTY_PORT_FOURTEEN = 14;
		public static final int EMPTY_PORT_FIFTEEN = 15;

	}

	public static class DIOChannels {
		public static final int EMPTY_PORT_ZERO = 0;
		public static final int EMPTY_PORT_ONE = 1;
		public static final int EMPTY_PORT_TWO = 2;
		public static final int EMPTY_PORT_THREE = 3;
		public static final int EMPTY_PORT_FOUR = 4;
		public static final int EMPTY_PORT_FIVE = 5;
		public static final int ARM_DOWN_LIMIT_SWITCH = 6;
		public static final int ARM_UP_LIMIT_SWITCH = 7;
		public static final int EMPTY_PORT_EIGHT = 8;
		public static final int EMPTY_PORT_NINE = 9;

	}

	public static class AnalogInChannels {
		public static final int EMPTY_PORT_ZERO = 0;
		public static final int EMPTY_PORT_ONE = 1;
		public static final int EMPTY_PORT_TWO = 2;
		public static final int EMPTY_PORT_THREE = 3;

	}

	public static class RelayChannels {
		public static final int EMPTY_PORT_ZERO = 0;
		public static final int EMPTY_PORT_ONE = 1;
		public static final int EMPTY_PORT_TWO = 2;
		public static final int EMPTY_PORT_THREE = 3;
	}

	public static class ArmConstants {
		public static final double HOME_POSITION = 0;
		public static final double SCORE_POSITION = 1;
		public static final int MINIMUM = 90;
		public static final int MAXIMUM = 200;
		public static final double SCALING_VALUE = 0.75;

		public static final double P = 0.01;
		public static final double I = 0;
		public static final double D = 0;

	}

	public static class DriverConstants {
		public static final double DEAD_ZONE_TOLERANCE = .1675;
		public static final double TRIGGER_DEAD_ZONE = .5;
	}
	
	public static class LiftArmConstants{
		public static final double LIFT_ARM_UP_SPEED = 0.5;
		public static final double LIFT_ARM_DOWN_SPEED = -0.5;
	}
	
	public static class DriveBaseConstants{
		public static final double DRIVE_BASE_MOTOR_DEAD_ZONE = .1675;
	}
	
	public static class PDPanelConstants{
		public static final boolean ALL_MOTORS = true;
		public static final boolean DRIVE_MOTORS = true;
		public static final boolean CLAW_MOTORS = true;
		public static final boolean LIFTER_MOTOR = true;
		
	}

}
