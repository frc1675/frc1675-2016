package org.usfirst.frc.team1675.robot.utils;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team1675.robot.utils.PathPoint.Heading;

public class PathGenerator {

	public static List<Directive> generatePath(List<PathPoint> points){
		//we don't move because of first path point
		List<Directive> returnList = new ArrayList<Directive>();
		
		PathPoint lastPoint = null;
		
		double angleToForward = 0.0;
		
		PathPoint currentPoint = null;
		
		for (int i = 0; i < points.size(); i++){
			if(i == 0){
				lastPoint = points.get(i);
			} else {
				currentPoint = points.get(i);
				
				double changeInX = currentPoint.x - lastPoint.x;
				double changeInY = currentPoint.y - lastPoint.y;
				Heading startHeading = lastPoint.heading;
				Heading endHeading = currentPoint.heading;
				double direction;
				double xSign = Math.signum(changeInX);
				double ySign = Math.signum(changeInY);
				
				double distance = Math.hypot(changeInX, changeInY);
				
				if(startHeading == Heading.BACKWARDS && i == 1){
					angleToForward -= 180;
				}
				
				if(changeInX == 0.0){
					direction = angleToForward - 90 + ySign*90 + (1 - Math.abs(ySign)) * 90;
				}else{
					direction = angleToForward + (90.0 * xSign) - Math.toDegrees(Math.atan(changeInY/changeInX));
				}
				
				if(endHeading == Heading.BACKWARDS){
					direction += 180;
					distance *= -1;
				}
				
				angleToForward -= direction;
				
				direction = putAngleInRange(direction);
				angleToForward = putAngleInRange(angleToForward);

				Directive nextDirective = new Directive(direction, distance);
				returnList.add(nextDirective);
				
				lastPoint = currentPoint;
			}
		}
		return returnList;
	}
	
	public static double putAngleInRange(double angle){
		while(angle <= -180){
			angle += 360;
		}
		while(angle > 180){
			angle -= 360;
		}
		
		return angle;
	}
}
