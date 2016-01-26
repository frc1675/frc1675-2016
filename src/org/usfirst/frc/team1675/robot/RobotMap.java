package org.usfirst.frc.team1675.robot;

public class RobotMap {

	public static class PWMChannels {
		public static final int EMPTY_PORT_ZERO = 0;
		public static final int EMPTY_PORT_ONE = 1;
		public static final int EMPTY_PORT_TWO = 2;
		public static final int EMPTY_PORT_THREE = 3;
		public static final int EMPTY_PORT_FOUR = 4;
		public static final int EMPTY_PORT_FIVE = 5;
		public static final int ARM_MOTOR = 6;
		public static final int EMPTY_PORT_SEVEN = 7;
		public static final int EMPTY_PORT_EIGHT = 8;
		public static final int EMPTY_PORT_NINE = 9;

	}

	public static class PDChannels {
		public static final int EMPTY_PORT_ZERO = 0;
		public static final int EMPTY_PORT_ONE = 1;
		public static final int EMPTY_PORT_TWO = 2;
		public static final int EMPTY_PORT_THREE = 3;
		
	}

	public static class DIOChannels {
		public static final int ARM_ENCODER_CHANNEL_A = 0;
		public static final int ARM_ENCODER_CHANNEL_B = 1;
		public static final int EMPTY_PORT_TWO = 2;
		public static final int EMPTY_PORT_THREE = 3;
		public static final int EMPTY_PORT_FOUR = 4;
		public static final int EMPTY_PORT_FIVE = 5;
		public static final int EMPTY_PORT_SIX = 6;
		public static final int EMPTY_PORT_SEVEN = 7;
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
	
	public static class ArmConstants{
		public static final double HOME_POSITION = 0;
		public static final double SCORE_POSITION = 1;
		public static final int MINIMUM = 90;
		public static final int MAXIMUM = 200;
		
		public static final double P = 0.01;
		public static final double I = 0;
		public static final double D = 0;
		
	}
	

}
