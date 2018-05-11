/*------------------------------------------------------------oubl----------------*/
	/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4201.robot;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import org.usfirst.frc.team4201.robot.subsystems.*;

/**
 * GlobalVariables contains constants that can sometimes change based on tuning values.
 * We place these variables here instead of in RobotMap because they change more often than not
 * based on various reasons (e.g. recalibrating sensors, disabling PIDControllers for testing, etc.)
 */

public class ConfigValues {
	
	static Ini config;
	
	public static void readIniFile() {
		try {
			config = new Ini(new File("/media/sda1/4201RobotFiles/4201config.ini"));
		} catch (InvalidFileFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void getWristConstantsFromFile(){
		try {
			Map<String, String> wrist = config.get("Wrist");
			
			Wrist.kP = Double.valueOf(wrist.get("kP"));
			Wrist.kI = Double.valueOf(wrist.get("kI"));
			Wrist.kD = Double.valueOf(wrist.get("kD"));
			Wrist.kF = Double.valueOf(wrist.get("kF"));
			Wrist.period = Double.valueOf(wrist.get("period"));
			
			Wrist.angleLowerLimit = Double.valueOf(wrist.get("angleLowerLimit"));
			Wrist.angleUpperLimit = Double.valueOf(wrist.get("angleUpperLimit"));
			Wrist.sensorLowerLimit = Double.valueOf(wrist.get("sensorLowerLimit"));
			Wrist.sensorUpperLimit = Double.valueOf(wrist.get("sensorUpperLimit"));
			Wrist.sensorOffset = Double.valueOf(wrist.get("sensorOffset"));
			
			Wrist.armLimiterLowerBound = Double.valueOf(wrist.get("armLimiterLowerBound"));
			Wrist.armLimiterUpperBound = Double.valueOf(wrist.get("armLimiterUpperBound"));
			
			Wrist.wristRetractedAngle = Double.valueOf(wrist.get("wristRetractedAngle"));
			Wrist.wristNeutralScaleAngle = Double.valueOf(wrist.get("wristNeutralScaleAngle"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("4201 Error: Error reading Wrist section from config file");
			e.printStackTrace();
		}
	}
	
	public static void getArmConstantsFromFile(){
		try {
			Map<String, String> arm = config.get("Arm");

			Arm.kP = Double.valueOf(arm.get("kP"));
			Arm.kI = Double.valueOf(arm.get("kI"));
			Arm.kD = Double.valueOf(arm.get("kD"));
			Arm.kF = Double.valueOf(arm.get("kF"));
			Arm.period = Double.valueOf(arm.get("period"));
			
			Arm.angleLowerLimit = Double.valueOf(arm.get("angleLowerLimit"));
			Arm.angleUpperLimit = Double.valueOf(arm.get("angleUpperLimit"));
			Arm.sensorLowerLimit = Double.valueOf(arm.get("sensorLowerLimit"));
			Arm.sensorUpperLimit = Double.valueOf(arm.get("sensorUpperLimit"));
			Arm.sensorOffset = Double.valueOf(arm.get("sensorOffset"));
			
			Arm.armHomeAngle = Double.valueOf(arm.get("armHomeAngle"));
			Arm.armSwitchAngle = Double.valueOf(arm.get("armSwitchAngle"));
			Arm.armScaleAngle = Double.valueOf(arm.get("armScaleAngle"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("4201 Error: Error reading Arm section from config file");
			e.printStackTrace();
		}
	}
	
	public static void getElevatorConstantsFromFile(){
		try {
			Map<String, String> elevator = config.get("Elevator");
			
			Elevator.kP = Double.valueOf(elevator.get("kP"));        
			Elevator.kI = Double.valueOf(elevator.get("kI"));        
			Elevator.kD = Double.valueOf(elevator.get("kD"));        
			Elevator.kF = Double.valueOf(elevator.get("kF"));        
			Elevator.period = Double.valueOf(elevator.get("period"));
            
			Elevator.kPHighUp = Double.valueOf(elevator.get("kPHighUp"));
			Elevator.kIHighUp = Double.valueOf(elevator.get("kIHighUp"));
			Elevator.kDHighUp = Double.valueOf(elevator.get("kDHighUp"));
			
			Elevator.hieghtLowerLimit = Double.valueOf(elevator.get("hieghtLowerLimit"));
			Elevator.hieghtUpperLimit = Double.valueOf(elevator.get("hieghtUpperLimit"));
			Elevator.sensorLowerLimit = Double.valueOf(elevator.get("sensorLowerLimit"));
			Elevator.sensorUpperLimit = Double.valueOf(elevator.get("sensorUpperLimit"));
			Elevator.sensorOffset = Double.valueOf(elevator.get("sensorOffset"));      
			
			Elevator.elevatorHomePosition = Double.valueOf(elevator.get("elevatorHomePosition")); 
			Elevator.elevatorSwitchPosition = Double.valueOf(elevator.get("elevatorSwitchPosition")); 
			Elevator.elevatorScaleLowPosition = Double.valueOf(elevator.get("elevatorScaleLowPosition")); 
			Elevator.elevatorScaleHighPosition = Double.valueOf(elevator.get("elevatorScaleHighPosition")); 
			Elevator.elevatorScaleVeryHighPosition = Double.valueOf(elevator.get("elevatorScaleVeryHighPosition")); 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("4201 Error:Error reading Elevator section from config file");
			//e.printStackTrace();
		}
	}
}
