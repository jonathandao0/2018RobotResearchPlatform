/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4201.robot;

import org.usfirst.frc.team4201.robot.commands.AutoRoutineScriptWrapper;
import org.usfirst.frc.team4201.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static DriveTrain driveTrain = new DriveTrain();
	public static OI oi;
	
	public static Command teleOpDrive;
	SendableChooser<Command> driveMode = new SendableChooser<>();
	
	Command m_autonomousCommand;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	private static final String[] autoScripts = {
		"SimpleTest",
		"ClassCallTest",
		"FunctionReturn",
		"FMSReadTest",
		"InvalidCallTest"
	};
	String gameData;
	

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		
		m_chooser.addObject("Simple JS Test", autoScripts[0]);
		m_chooser.addObject("Class Call Test", autoScripts[1]);
		m_chooser.addObject("Function Return Test", autoScripts[2]);
		m_chooser.addObject("FMS Read Test", autoScripts[3]);
		m_chooser.addObject("Invalid Call Test", autoScripts[4]);
		SmartDashboard.putData("Auto choices", m_chooser);
	}
	@Override
	public void disabledInit() {
		Scheduler.getInstance().removeAll();
		
	}
	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	
	}
	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		String scriptName = m_chooser.getSelected() + ".js";
		
		m_autonomousCommand = new AutoRoutineScriptWrapper(scriptName);
		
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
	}
	
	@Override
	public void teleopInit() {
		Scheduler.getInstance().removeAll();
		
		teleOpDrive = driveMode.getSelected();
		
		if (teleOpDrive != null) {
			teleOpDrive.start();
			Robot.driveTrain.setDefaultCommand(teleOpDrive);			// To prevent KillAll() from switching drive modes mid-match
		}
	}
	
	
	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
