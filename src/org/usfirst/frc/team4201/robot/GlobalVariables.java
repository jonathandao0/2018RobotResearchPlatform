/*----------------------------------------------------------------------------*/
	/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4201.robot;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team1699.utils.inireader.ConfigFile;
import org.usfirst.frc.team1699.utils.inireader.ConfigSection;
import org.usfirst.frc.team1699.utils.inireader.exception.NotFoundException;

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
		try {
			ConfigFile config = new ConfigFile("/media/sda1/4201RobotFiles/4201config.ini");
			ConfigSection wrist;
			try {
				wrist = config.getSection("Wrist");
				
				double value = wrist.getLineValue("WristRetracted", double.class);
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getArmConstantsFromFile(){
		
	}
	
	public void getElevatorConstantsFromFile(){
		
	}
}
