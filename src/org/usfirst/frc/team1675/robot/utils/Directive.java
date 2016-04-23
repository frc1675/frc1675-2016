package org.usfirst.frc.team1675.robot.utils;


public class Directive {
	
	//every directive is an amount to turn then a distance to drive
	
	public double degreesToTurn;
	public double distanceToDrive;

	public Directive(double degreesToTurn, double distanceToDrive){
		this.degreesToTurn = degreesToTurn;
		this.distanceToDrive = distanceToDrive;
	}
	
	public String toString(){
		return "Turn " + degreesToTurn + " degrees then drive " + distanceToDrive + " units";
	}
}
