/*----------------------------------------------------------------------------*/
	/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4201.robot;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.usfirst.frc.team1699.utils.inireader.ConfigFile;
import org.usfirst.frc.team1699.utils.inireader.ConfigSection;
import org.usfirst.frc.team1699.utils.inireader.exception.NotFoundException;
import org.usfirst.frc.team4201.robot.subsystems.*;

/**
 * GlobalVariables contains constants that can sometimes change based on tuning values.
 * We place these variables here instead of in RobotMap because they change more often than not
 * based on various reasons (e.g. recalibrating sensors, disabling PIDControllers for testing, etc.)
 */

public class ConfigValues {
	
	static ConfigFile config;
	
	public static void readIniFile() {
		try {
			config = new ConfigFile("/media/sda1/4201RobotFiles/4201config.ini");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("4201 Error: ini FileNotFound");
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("4201 Error: I/O Error (USB not connected?)");
			//e.printStackTrace();
		}
	}
	
	public static void getWristConstantsFromFile(){
		ConfigSection wrist;
		
		try {
			wrist = config.getSection("Wrist");

			Wrist.kP = wrist.getLineValue("kP", double.class);
			Wrist.kI = wrist.getLineValue("kI", double.class);
			Wrist.kD = wrist.getLineValue("kD", double.class);
			Wrist.kF = wrist.getLineValue("kF", double.class);
			Wrist.period = wrist.getLineValue("period", double.class);
			
			Wrist.angleLowerLimit = wrist.getLineValue("angleLowerLimit", double.class);
			Wrist.angleUpperLimit = wrist.getLineValue("angleUpperLimit", double.class);
			Wrist.sensorLowerLimit = wrist.getLineValue("sensorLowerLimit", double.class);
			Wrist.sensorUpperLimit = wrist.getLineValue("sensorUpperLimit", double.class);
			Wrist.sensorOffset = wrist.getLineValue("sensorOffset", double.class);
			
			Wrist.armLimiterLowerBound = wrist.getLineValue("armLimiterLowerBound", double.class);
			Wrist.armLimiterUpperBound = wrist.getLineValue("armLimiterUpperBound", double.class);
			
			Wrist.wristRetractedAngle = wrist.getLineValue("wristRetractedAngle", double.class);
			Wrist.wristNeutralScaleAngle = wrist.getLineValue("wristNeutralScaleAngle", double.class);
			
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("4201 Error: Error reading Wrist section from config file");
			//e.printStackTrace();
		}
	}
	
	public static void getArmConstantsFromFile(){
		ConfigSection arm;
		
		try {
			arm = config.getSection("Arm");

			Arm.kP = arm.getLineValue("kP", double.class);
			Arm.kI = arm.getLineValue("kI", double.class);
			Arm.kD = arm.getLineValue("kD", double.class);
			Arm.kF = arm.getLineValue("kF", double.class);
			Arm.period = arm.getLineValue("period", double.class);
			
			Arm.angleLowerLimit = arm.getLineValue("angleLowerLimit", double.class);
			Arm.angleUpperLimit = arm.getLineValue("angleUpperLimit", double.class);
			Arm.sensorLowerLimit = arm.getLineValue("sensorLowerLimit", double.class);
			Arm.sensorUpperLimit = arm.getLineValue("sensorUpperLimit", double.class);
			Arm.sensorOffset = arm.getLineValue("sensorOffset", double.class);
			
			Arm.armHomeAngle = arm.getLineValue("armHomeAngle", double.class);
			Arm.armSwitchAngle = arm.getLineValue("armSwitchAngle", double.class);
			Arm.armScaleAngle = arm.getLineValue("armScaleAngle", double.class);
			
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("4201 Error: Error reading Arm section from config file");
			//e.printStackTrace();
		}
	}
	
	public static void getElevatorConstantsFromFile(){
		ConfigSection elevator;
		try {
			elevator = config.getSection("Elevator");
			
			Elevator.kP = elevator.getLineValue("kP", double.class);
			Elevator.kI = elevator.getLineValue("kI", double.class);
			Elevator.kD = elevator.getLineValue("kD", double.class);
			Elevator.kF = elevator.getLineValue("kF", double.class);
			Elevator.period = elevator.getLineValue("period", double.class);

			Elevator.kPHighUp = elevator.getLineValue("kPHighUp", double.class);
			Elevator.kIHighUp = elevator.getLineValue("kIHighUp", double.class);
			Elevator.kDHighUp = elevator.getLineValue("kDHighUp", double.class);
			
			Elevator.hieghtLowerLimit = elevator.getLineValue("hieghtLowerLimit", double.class);
			Elevator.hieghtUpperLimit = elevator.getLineValue("hieghtUpperLimit", double.class);
			Elevator.sensorLowerLimit = elevator.getLineValue("sensorLowerLimit", double.class);
			Elevator.sensorUpperLimit = elevator.getLineValue("sensorUpperLimit", double.class);
			Elevator.sensorOffset = elevator.getLineValue("sensorOffset", double.class);
			
			Elevator.elevatorHomePosition = elevator.getLineValue("elevatorHomePosition", double.class);
			Elevator.elevatorSwitchPosition = elevator.getLineValue("elevatorSwitchPosition", double.class);
			Elevator.elevatorScaleLowPosition = elevator.getLineValue("elevatorScaleLowPosition", double.class);
			Elevator.elevatorScaleHighPosition = elevator.getLineValue("elevatorScaleHighPosition", double.class);
			Elevator.elevatorScaleVeryHighPosition = elevator.getLineValue("elevatorScaleVeryHighPosition", double.class);
			
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("4201 Error:Error reading Elevator section from config file");
			//e.printStackTrace();
		}
	}
}
