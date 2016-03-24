package org.usfirst.frc.team1675.robot.commands.auto;

import org.usfirst.frc.team1675.robot.commands.claw.ClawOutputForTime;
import org.usfirst.frc.team1675.robot.commands.drivebase.DriveForDistance;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveWhileSpit extends CommandGroup {
    
    public  DriveWhileSpit(double inches, double timeout) {
    	//uses same logic from DriveThenDriveWhileShootingAuto branch
        addSequential(new DriveForDistance(inches, timeout));
        addParallel(new ClawOutputForTime(timeout));
    }
}
