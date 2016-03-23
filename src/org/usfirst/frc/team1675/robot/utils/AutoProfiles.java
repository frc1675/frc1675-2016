package org.usfirst.frc.team1675.robot.utils;

import java.util.HashMap;
import java.util.Map;

import org.usfirst.frc.team1675.robot.utils.AutoChooser.AfterCrossDirective;
import org.usfirst.frc.team1675.robot.utils.AutoChooser.Position;

public class AutoProfiles {
	
	public class AutoProfile{
		double x1;
		double x2;
		double x3;
		double angle1;
		double angle2;
		
		public AutoProfile(double x1, double x2, double x3, double angle1, double angle2){
			this.x1 = x1;
			this.x2 = x2;
			this.x3 = x3;
			this.angle1 = angle1;
			this.angle2 = angle2;
		}
	}
	
	private static Map<AutoChooser.Position, Map<AfterCrossDirective, AutoProfile>> profiles;
	
	public AutoProfiles(){
		profiles = new HashMap<AutoChooser.Position, Map<AfterCrossDirective, AutoProfile>>();
		populateMap();
	}

	private void populateMap() {
		//add map for each position
		profiles.put(Position.TWO, new HashMap<AfterCrossDirective, AutoProfile>());
		profiles.put(Position.THREE, new HashMap<AfterCrossDirective, AutoProfile>());
		profiles.put(Position.FOUR, new HashMap<AfterCrossDirective, AutoProfile>());
		profiles.put(Position.FIVE, new HashMap<AfterCrossDirective, AutoProfile>());
		
		//add profiles
		Map<AfterCrossDirective, AutoProfile> twoMap = profiles.get(Position.TWO);
		twoMap.put(AfterCrossDirective.LEFT_FORWARDS, new AutoProfile(24.0, 24.0, 24.0, -90.0, 90.0));
		twoMap.put(AfterCrossDirective.RIGHT_FORWARDS, new AutoProfile(24.0, 24.0, 24.0, 90.0, -90.0));
		twoMap.put(AfterCrossDirective.LEFT_BACKWARDS, new AutoProfile(-24.0, -24.0, 24.0, -90.0, -90.0));
		twoMap.put(AfterCrossDirective.RIGHT_BACKWARDS, new AutoProfile(-24.0, -24.0, 24.0, 90.0, 90.0));
		
		Map<AfterCrossDirective, AutoProfile> threeMap = profiles.get(Position.THREE);
		threeMap.put(AfterCrossDirective.LEFT_FORWARDS, new AutoProfile(24.0, 24.0, 24.0, -90.0, 90.0));
		threeMap.put(AfterCrossDirective.RIGHT_FORWARDS, new AutoProfile(24.0, 24.0, 24.0, 90.0, -90.0));
		threeMap.put(AfterCrossDirective.LEFT_BACKWARDS, new AutoProfile(-24.0, -24.0, 24.0, -90.0, -90.0));
		threeMap.put(AfterCrossDirective.RIGHT_BACKWARDS, new AutoProfile(-24.0, -24.0, 24.0, 90.0, 90.0));
		
		Map<AfterCrossDirective, AutoProfile> fourMap = profiles.get(Position.FOUR);
		fourMap.put(AfterCrossDirective.LEFT_FORWARDS, new AutoProfile(24.0, 24.0, 24.0, -90.0, 90.0));
		fourMap.put(AfterCrossDirective.RIGHT_FORWARDS, new AutoProfile(24.0, 24.0, 24.0, 90.0, -90.0));
		fourMap.put(AfterCrossDirective.LEFT_BACKWARDS, new AutoProfile(-24.0, -24.0, 24.0, -90.0, -90.0));
		fourMap.put(AfterCrossDirective.RIGHT_BACKWARDS, new AutoProfile(-24.0, -24.0, 24.0, 90.0, 90.0));
		
		Map<AfterCrossDirective, AutoProfile> fiveMap = profiles.get(Position.FIVE);
		fiveMap.put(AfterCrossDirective.LEFT_FORWARDS, new AutoProfile(24.0, 24.0, 24.0, -90.0, 90.0));
		fiveMap.put(AfterCrossDirective.RIGHT_FORWARDS, new AutoProfile(24.0, 24.0, 24.0, 90.0, -90.0));
		fiveMap.put(AfterCrossDirective.LEFT_BACKWARDS, new AutoProfile(-24.0, -24.0, 24.0, -90.0, -90.0));
		fiveMap.put(AfterCrossDirective.RIGHT_BACKWARDS, new AutoProfile(-24.0, -24.0, 24.0, 90.0, 90.0));
	}
	
	public AutoProfile getProfile(Position position, AfterCrossDirective acd){
		return profiles.get(position).get(acd);
	}

}
