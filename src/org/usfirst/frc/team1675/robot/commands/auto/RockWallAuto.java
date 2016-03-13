package org.usfirst.frc.team1675.robot.commands.auto;

import org.usfirst.frc.team1675.robot.commands.clawarm.ClawArmMoveForXSeconds;
import org.usfirst.frc.team1675.robot.commands.drivebase.DriveStraightForTime;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RockWallAuto extends CommandGroup {
    
    public  RockWallAuto() {
        addSequential(new DriveStraightForTime(1.0, 2.0));
        addParallel(new DriveStraightForTime(1.0, 2.0));
        addSequential(new ClawArmMoveForXSeconds(0.4, -0.3));
        
    	
    	
    }
}
