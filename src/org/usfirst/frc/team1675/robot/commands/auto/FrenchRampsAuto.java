package org.usfirst.frc.team1675.robot.commands.auto;

import org.usfirst.frc.team1675.robot.commands.Wait;
import org.usfirst.frc.team1675.robot.commands.clawarm.ClawArmMoveForXSeconds;
import org.usfirst.frc.team1675.robot.commands.drivebase.DriveForDistance;
import org.usfirst.frc.team1675.robot.commands.drivebase.DriveStraightForTime;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FrenchRampsAuto extends CommandGroup {
    
    public  FrenchRampsAuto() {
    	addSequential(new DriveForDistance(45));
    	addSequential(new ClawArmMoveForXSeconds(0.4, -0.3));//Lower claw arm here will go
    	addSequential(new Wait(1.5));
    	addSequential(new DriveStraightForTime(1, 0.5));

       
    }
}
