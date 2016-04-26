package org.usfirst.frc.team1675.robot.utils;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team1675.robot.commands.auto.AfterCrossProfile;
import org.usfirst.frc.team1675.robot.commands.auto.DriveWhileSpit;
import org.usfirst.frc.team1675.robot.commands.auto.FrenchRampsAuto;
import org.usfirst.frc.team1675.robot.commands.auto.LowBarCross;
import org.usfirst.frc.team1675.robot.commands.auto.LowBarScore;
import org.usfirst.frc.team1675.robot.commands.auto.PortcullisAuto;
import org.usfirst.frc.team1675.robot.commands.auto.RockWallAuto;
import org.usfirst.frc.team1675.robot.commands.auto.RoughTerrainAuto;
import org.usfirst.frc.team1675.robot.commands.drivebase.DriveForDistance;
import org.usfirst.frc.team1675.robot.commands.drivebase.TurnWithGyro;
import org.usfirst.frc.team1675.robot.utils.PathPoint.Heading;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoChooser {
	
	private SendableChooser defenseChooser;
	private SendableChooser positionChooser;
	private SendableChooser afterCrossChooser;
	private SendableChooser afterScoreChooser;
	
	private List<PathPoint> pointList;
	private List<Directive> directives;
	
	public enum Defense {
		LOW_BAR_STOP,
		CDF,
		PORTCULLIS,
		ROCK_WALL,
		ROUGH_TERRAIN,
		LOW_BAR_SCORE
	}
	
	public enum Position {
		TWO,
		THREE,
		FOUR,
		FIVE
	}
	
	public enum AfterCrossChoice {
		NOTHING,
		SCORE_LEFT,
		SCORE_RIGHT,
		DRIVE_LEFT,
		DRIVE_RIGHT
	}
	
	public enum AfterCrossDirective {
		LEFT_FORWARDS,
		RIGHT_FORWARDS,
		LEFT_BACKWARDS,
		RIGHT_BACKWARDS
	}
	
	public enum AfterScore {
		NOTHING,
		SPIT_SUCK,
		DRIVE_TO_1,
		DRIVE_TO_2,
		DRIVE_TO_3,
		DRIVE_TO_4,
		DRIVE_TO_5
	}
	
	public AutoChooser(){
		//make and fill in choosers with enums
		
		//put choosers on smart dashboard
		defenseChooser = new SendableChooser();
		positionChooser = new SendableChooser();
		afterCrossChooser = new SendableChooser();
//		afterScoreChooser = new SendableChooser();
		pointList = new ArrayList<PathPoint>();
		
		defenseChooser.addObject("Low Bar and Stop", Defense.LOW_BAR_STOP);
		defenseChooser.addObject("Shovel Fries", Defense.CDF);
		defenseChooser.addObject("Portcullis", Defense.PORTCULLIS);
		defenseChooser.addObject("Rock Wall", Defense.ROCK_WALL);
		defenseChooser.addObject("Rough Terrain", Defense.ROUGH_TERRAIN);
		defenseChooser.addObject("$$!Low Bar Score!$$", Defense.LOW_BAR_SCORE);
		
		positionChooser.addObject("2", Position.TWO);
		positionChooser.addObject("3", Position.THREE);
		positionChooser.addObject("4", Position.FOUR);
		positionChooser.addObject("5", Position.FIVE);
		
		afterCrossChooser.addObject("Nothing", AfterCrossChoice.NOTHING);
		afterCrossChooser.addObject("Score Left", AfterCrossChoice.SCORE_LEFT);
		afterCrossChooser.addObject("Score Right", AfterCrossChoice.SCORE_RIGHT);
		afterCrossChooser.addObject("Drive Left", AfterCrossChoice.DRIVE_LEFT);
		afterCrossChooser.addObject("Drive Right", AfterCrossChoice.DRIVE_RIGHT);
		
//		afterScoreChooser.addObject("Nothing", AfterScore.NOTHING);
//		afterScoreChooser.addObject("Spit Suck", AfterScore.SPIT_SUCK);
//		afterScoreChooser.addObject("Drive To 1", AfterScore.DRIVE_TO_1);
//		afterScoreChooser.addObject("Drive To 2", AfterScore.DRIVE_TO_2);
//		afterScoreChooser.addObject("Drive To 3", AfterScore.DRIVE_TO_3);
//		afterScoreChooser.addObject("Drive To 4", AfterScore.DRIVE_TO_4);
//		afterScoreChooser.addObject("Drive To 5", AfterScore.DRIVE_TO_5);
		
		SmartDashboard.putData("Defense", defenseChooser);
		SmartDashboard.putData("Position", positionChooser);
		SmartDashboard.putData("After Cross", afterCrossChooser);
//		SmartDashboard.putData("After Score", afterScoreChooser);
	}
	
	public CommandGroup generateAuto(){
		CommandGroup auto = new CommandGroup();
		
		Defense selectedDefense = (Defense) defenseChooser.getSelected();
		Position selectedPosition = (Position) positionChooser.getSelected();
		AfterCrossChoice selectedAfterCross = (AfterCrossChoice) afterCrossChooser.getSelected();
		
		Heading robotHeading;
		double defenseXDisplacement;
		double defenseYDisplacement;
		boolean scoreAfterMove;
		
		//EARLY EXIT - IF WE CHOOSE LOW BAR SCORE JUST DO THE OLDIE
		if(selectedDefense == Defense.LOW_BAR_SCORE){
			auto = new LowBarScore();
			return auto;
		}
		
		switch(selectedDefense){
		case LOW_BAR_STOP:
			robotHeading = Heading.FORWARDS;
			defenseXDisplacement = -21.9375;
			defenseYDisplacement = 0;
			break;
		case CDF:
			robotHeading = Heading.FORWARDS;
			defenseXDisplacement = 6.25;
			defenseYDisplacement = 22;
			auto.addSequential(new FrenchRampsAuto());
			break;
		case PORTCULLIS:
			robotHeading = Heading.BACKWARDS;
			defenseXDisplacement = 0;
			//Y displacement is placeholder
			defenseYDisplacement = 22;
			auto.addSequential(new PortcullisAuto());
			break;
		case ROCK_WALL:
			robotHeading = Heading.FORWARDS;
			defenseXDisplacement = 0;
			//Y displacement is placeholder
			defenseYDisplacement = 48;
			auto.addSequential(new RockWallAuto());
			break;
		case ROUGH_TERRAIN:
			robotHeading = Heading.BACKWARDS;
			defenseXDisplacement = 0;
			defenseYDisplacement = 48;
			auto.addSequential(new RoughTerrainAuto());
			break;
		default:
			//shouldnt be possible, do nothing
			return auto;
		}
		
		switch(selectedPosition){
		case TWO:
			pointList.add(new PathPoint(-78.8125 + defenseXDisplacement, defenseYDisplacement, robotHeading));
			break;
		case THREE:
			pointList.add(new PathPoint(-28.4375 + defenseXDisplacement, defenseYDisplacement, robotHeading));
			break;
		case FOUR:
			pointList.add(new PathPoint(21.9375 + defenseXDisplacement, defenseYDisplacement, robotHeading));
			break;
		case FIVE:
			pointList.add(new PathPoint(72.3125 + defenseXDisplacement, defenseYDisplacement, robotHeading));
			break;
		default:
			return auto;
		}
		
		scoreAfterMove = true;
		
		switch(selectedAfterCross){
		case DRIVE_LEFT:
			scoreAfterMove = false;
		case SCORE_LEFT:
			pointList.add(new PathPoint(24, 12, robotHeading));
			pointList.add(new PathPoint(36, 12, Heading.FORWARDS));
			pointList.add(new PathPoint(0, 0, Heading.BACKWARDS));
			pointList.add(new PathPoint(0, 0, Heading.BACKWARDS));
			break;
		case DRIVE_RIGHT:
			scoreAfterMove = false;
		case SCORE_RIGHT:
			pointList.add(new PathPoint(-36, 12, robotHeading));
			pointList.add(new PathPoint(-36, 24, Heading.BACKWARDS));
			pointList.add(new PathPoint(-12, 0, Heading.FORWARDS));
			
			break;
		case NOTHING:
			scoreAfterMove = false;
			//don't make a profile
		}
		
		directives = PathGenerator.generatePath(pointList);
		for(int i = 0; i < directives.size(); i++){
			auto.addSequential(new TurnWithGyro(directives.get(i).degreesToTurn));
			auto.addSequential(new DriveForDistance(directives.get(i).distanceToDrive));
		}

		
		//only add a score if we moved anyway
		if(scoreAfterMove){
			auto.addSequential(new DriveWhileSpit(24.0, 2.0));
		}
		
		return auto;
	}

}
