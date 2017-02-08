package org.usfirst.frc.team1675.robot.utils;

import java.util.ArrayList;
import java.util.List;

//describes the ending point of a movement
public class PathPoint {

	public enum Heading {
		FORWARDS, BACKWARDS
	}

	private double x;
	private double y;
	private Heading heading;

	public PathPoint(double x, double y, Heading heading) {
		this.x = x;
		this.y = y;
		this.heading = heading;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Heading getHeading() {
		return heading;
	}

	public String toString() {
		return "Position: " + x + ", " + y + " | Heading: " + heading;
	}

	public static List<Directive> generatePath(List<PathPoint> points) {
		// we don't move because of first path point
		List<Directive> returnList = new ArrayList<Directive>();

		PathPoint lastPoint = null;

		double angleToForward = 0.0;

		PathPoint currentPoint = null;

		for (int i = 0; i < points.size(); i++) {
			if (i == 0) {
				lastPoint = points.get(i);
				if (lastPoint.getHeading() == Heading.BACKWARDS) {
					angleToForward -= 180;
				}
			} else {
				currentPoint = points.get(i);

				double changeInX = currentPoint.getX() - lastPoint.getX();
				double changeInY = currentPoint.getY() - lastPoint.getY();
				Heading endHeading = currentPoint.getHeading();
				double direction;
				double xSign = Math.signum(changeInX);
				double ySign = Math.signum(changeInY);

				double distance = Math.hypot(changeInX, changeInY);

				if (changeInX == 0.0) {
					direction = angleToForward + 90 * (ySign - Math.abs(ySign));
				} else {
					direction = angleToForward + (90.0 * xSign)
							- Math.toDegrees(Math.atan(changeInY / changeInX));
				}

				if (endHeading == Heading.BACKWARDS) {
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

	public static double putAngleInRange(double angle) {
		while (angle <= -180) {
			angle += 360;
		}
		while (angle > 180) {
			angle -= 360;
		}

		return angle;
	}
}
