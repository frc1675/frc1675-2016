
package org.usfirst.frc.team1675.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team1675.robot.subsystems.DriveBase;
import org.usfirst.frc.team1675.robot.subsystems.Vision;
import org.usfirst.frc.team1675.robot.subsystems.ClawSubSystem;
import org.usfirst.frc.team1675.robot.commands.drivebase.TurnWithGyro;
import org.usfirst.frc.team1675.robot.subsystems.ClawArm;
import org.usfirst.frc.team1675.robot.subsystems.ClawSubSystem;
import org.usfirst.frc.team1675.robot.commands.auto.LowBarScore;
import org.usfirst.frc.team1675.robot.commands.drivebase.DriveForDistance;
import org.usfirst.frc.team1675.robot.subsystems.DriveBase;
import org.usfirst.frc.team1675.robot.subsystems.LiftArm;
import org.usfirst.frc.team1675.robot.subsystems.PDPanel;
import org.usfirst.frc.team1675.robot.utils.Zamboni;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static DriveBase driveBase;
	public static ClawSubSystem clawSub;
	public static ClawArm clawArm;
	public static LiftArm liftArm;
	public static Vision vision;
	public static PDPanel pdPanel;

	static{
		try{
			driveBase = new DriveBase();
			clawSub = new ClawSubSystem();
			clawArm = new ClawArm();
			liftArm = new LiftArm();
			vision = new Vision();
			pdPanel = new PDPanel();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
		
	public static OI oi;

    Command autonomousCommand;
    SendableChooser chooser;   

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();	
        chooser = new SendableChooser();
//        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    	Zamboni.clear();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
	  public void autonomousInit() {
        //autonomousCommand = (Command) chooser.getSelected();
    	//autonomousCommand = new TurnWithGyro(60.0);
		//autonomousCommand = new DriveForDistance(204.0);
    	autonomousCommand = new LowBarScore();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	System.out.println("start auto");

    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
