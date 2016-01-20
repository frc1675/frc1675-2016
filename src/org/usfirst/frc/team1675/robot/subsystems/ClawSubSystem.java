package org.usfirst.frc.team1675.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawSubSystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private SpeedController rollerIn;
	private SpeedController rollerOut;
	
	private DigitalInput limitSwitch;
	
	private final int ROLLER_IN_PORT = 0; //Set to 0 and 1 as filler
	private final int ROLLER_OUT_PORT = 1; //Find actual numbers needed
	
	public ClawSubSystem(){
		rollerIn = new TalonSRX(ROLLER_IN_PORT);
		rollerOut = new TalonSRX(ROLLER_OUT_PORT);
		limitSwitch = new DigitalInput(1); //1 is a filler. Find actual number later
	}
	
	public void setRollerInPower(double value){
		rollerIn.set(value);
	}
	
	public void setRollerOutPower(double value){
		rollerOut.set(value);
	}
	
	public boolean hasBall(){
		if(limitSwitch.get() == true){ //Change if no limit switch
			return true;
		} 
		return false;
//		else if(buttonA.isPressed){ //buttonA is filler until we have controller map
//			return true;
//		} else{
//			return false;
//		}
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
