/*----------------------------------------------------------------------------*/
	/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4201.robot;

/**
 * GlobalVariables contains constants that can sometimes change based on tuning values.
 * We place these variables here instead of in RobotMap because they change more often than not
 * based on various reasons (e.g. recalibrating sensors, disabling PIDControllers for testing, etc.)
 */

public class GlobalVariables {
	public static int WristState = 0;
	public static int ArmState = 0;
	public static int ElevatorState = 0;
	
	public static double wristRetractedAngle = 120;
	public static double armHomeAngle = -60;
	public static double elevatorHomePosition = 3.8;
	
	public void getWristConstantsFromFile(){
		
	}
	
	public void getArmConstantsFromFile(){
		
	}
	
	public void getElevatorConstantsFromFile(){
		
	}
}
