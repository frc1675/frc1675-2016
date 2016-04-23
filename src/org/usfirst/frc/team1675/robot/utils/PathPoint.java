package org.usfirst.frc.team1675.robot.utils;

//describes the ending point of a movement
public class PathPoint {

	public enum Heading{
		FORWARDS,
		BACKWARDS
	}
	
	public double x;
	public double y;
	public Heading heading;
	
	public PathPoint(double x, double y, Heading heading){
		this.x = x;
		this.y = y;
		this.heading = heading;
	}
	
	public String toString(){
		return "Position: " + x + ", " + y + " | Heading: " + heading;
	}
}
