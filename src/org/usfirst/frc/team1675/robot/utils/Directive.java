package org.usfirst.frc.team1675.robot.utils;


public class Directive {
	
	//every directive is an amount to turn then a distance to drive
	
	private double degreesToTurn;
	private double distanceToDrive;

	public Directive(double degreesToTurn, double distanceToDrive){
		this.degreesToTurn = degreesToTurn;
		this.distanceToDrive = distanceToDrive;
	}
	
	public double getDegreesToTurn(){
		return degreesToTurn;
	}
	
	public double getDistanceToDrive(){
		return distanceToDrive;
	}
	
	public String toString(){
		return "Turn " + degreesToTurn + " degrees then drive " + distanceToDrive + " units";
	}
}
