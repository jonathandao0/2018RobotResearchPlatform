package org.usfirst.frc.team4201.robot.commands;

import org.usfirst.frc.team4201.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.BBCommandGroup;

/**
 *
 */
public class AutoRoutineScriptWrapper extends BBCommandGroup {
	
    public AutoRoutineScriptWrapper() {
    	System.out.println("Running JS Wrapper...");
		
		try {
			Robot.m_chooser.getSelected().invokeFunction("autoRoutine"); // Need case structure for different commands requiring different arguments
		} catch(Exception e){
			DriverStation.reportError("4201 Error: Auto script could not be evalulated", false);
	    	System.out.println(e.getMessage());
		}
    }
}
