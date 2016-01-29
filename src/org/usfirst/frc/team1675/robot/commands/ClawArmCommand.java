package org.usfirst.frc.team1675.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ClawArmCommand extends CommandGroup {

	public ClawArmCommand() {
		// Add Commands here:

		addSequential(new SetArmPosition(90));
		addSequential(new SetArmPosition(123));
		addSequential(new SetArmPosition(189));
		addSequential(new SetArmPosition(157));
		addSequential(new SetArmPosition(146));
		addSequential(new SetArmPosition(200));
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
	}
}
