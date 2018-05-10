/*------------------------------------------------------------oubl----------------*/
	/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4201.robot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.ini4j.Wini;
import org.usfirst.frc.team4201.robot.subsystems.*;

/**
 * GlobalVariables contains constants that can sometimes change based on tuning values.
 * We place these variables here instead of in RobotMap because they change more often than not
 * based on various reasons (e.g. recalibrating sensors, disabling PIDControllers for testing, etc.)
 */

public class ConfigValues {
	
	static Wini config;
	
	public static void readIniFile() {
		try {
			config = new Wini(new File("/media/sda1/4201RobotFiles/4201config.ini"));
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
		try {
			Wrist.kP = config.get("Wrist", "kP", double.class);
			System.out.println(Wrist.kP);
			//Wrist.kI = (double) wrist.getLine("kI").getRawValue();
			//Wrist.kD = (double) wrist.getLine("kD").getRawValue();
			//Wrist.kF = (double) wrist.getLine("kF").getRawValue();
			//Wrist.period = (double) wrist.getLine("period").getRawValue();
			//
			//Wrist.angleLowerLimit = (double) wrist.getLine("angleLowerLimit").getRawValue();
			//Wrist.angleUpperLimit = (double) wrist.getLine("angleUpperLimit").getRawValue();
			//Wrist.sensorLowerLimit = (double) wrist.getLine("sensorLowerLimit").getRawValue();
			//Wrist.sensorUpperLimit = (double) wrist.getLine("sensorUpperLimit").getRawValue();
			//Wrist.sensorOffset = (double) wrist.getLine("sensorOffset").getRawValue();
			//
			//Wrist.armLimiterLowerBound = (double) wrist.getLine("armLimiterLowerBound").getRawValue();
			//Wrist.armLimiterUpperBound = (double) wrist.getLine("armLimiterUpperBound").getRawValue();
			//
			//Wrist.wristRetractedAngle = (double) wrist.getLine("wristRetractedAngle").getRawValue();
			//Wrist.wristNeutralScaleAngle = (double) wrist.getLine("wristNeutralScaleAngle").getRawValue();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("4201 Error: Error reading Wrist section from config file");
			e.printStackTrace();
		}
	}
	
	public static void getArmConstantsFromFile(){
//		ConfigSection arm;
//		
//		try {
//			arm = config.getSection("Arm");
//
//			//Arm.kP = (double) arm.getLine("kP").getRawValue();
//			//Arm.kI = (double) arm.getLine("kI").getRawValue();
//			//Arm.kD = (double) arm.getLine("kD").getRawValue();
//			//Arm.kF = (double) arm.getLine("kF").getRawValue();
//			//Arm.period = (double) arm.getLine("period").getRawValue();
//			//
//			//Arm.angleLowerLimit = (double) arm.getLine("angleLowerLimit").getRawValue();
//			//Arm.angleUpperLimit = (double) arm.getLine("angleUpperLimit").getRawValue();
//			//Arm.sensorLowerLimit = (double) arm.getLine("sensorLowerLimit").getRawValue();
//			//Arm.sensorUpperLimit = (double) arm.getLine("sensorUpperLimit").getRawValue();
//			//Arm.sensorOffset = (double) arm.getLine("sensorOffset").getRawValue();
//			//
//			//Arm.armHomeAngle = (double) arm.getLine("armHomeAngle").getRawValue();
//			//Arm.armSwitchAngle = (double) arm.getLine("armSwitchAngle").getRawValue();
//			//Arm.armScaleAngle = (double) arm.getLine("armScaleAngle").getRawValue();
//			
//		} catch (NotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("4201 Error: Error reading Arm section from config file");
//			//e.printStackTrace();
//		}
	}
	
	public static void getElevatorConstantsFromFile(){
//		ConfigSection elevator;
//		try {
//			elevator = config.getSection("Elevator");
//			
//			//Elevator.kP = (double) elevator.getLine("kP").getRawValue();
//			//Elevator.kI = (double) elevator.getLine("kI").getRawValue();
//			//Elevator.kD = (double) elevator.getLine("kD").getRawValue();
//			//Elevator.kF = (double) elevator.getLine("kF").getRawValue();
//			//Elevator.period = (double) elevator.getLine("period").getRawValue();
//            //
//			//Elevator.kPHighUp = (double) elevator.getLine("kPHighUp").getRawValue();
//			//Elevator.kIHighUp = (double) elevator.getLine("kIHighUp").getRawValue();
//			//Elevator.kDHighUp = (double) elevator.getLine("kDHighUp").getRawValue();
//			//
//			//Elevator.hieghtLowerLimit = (double) elevator.getLine("hieghtLowerLimit").getRawValue();
//			//Elevator.hieghtUpperLimit = (double) elevator.getLine("hieghtUpperLimit").getRawValue();
//			//Elevator.sensorLowerLimit = (double) elevator.getLine("sensorLowerLimit").getRawValue();
//			//Elevator.sensorUpperLimit = (double) elevator.getLine("sensorUpperLimit").getRawValue();
//			//Elevator.sensorOffset = (double) elevator.getLine("sensorOffset").getRawValue();
//			//
//			//Elevator.elevatorHomePosition = (double) elevator.getLine("elevatorHomePosition").getRawValue();
//			//Elevator.elevatorSwitchPosition = (double) elevator.getLine("elevatorSwitchPosition").getRawValue();
//			//Elevator.elevatorScaleLowPosition = (double) elevator.getLine("elevatorScaleLowPosition").getRawValue();
//			//Elevator.elevatorScaleHighPosition = (double) elevator.getLine("elevatorScaleHighPosition").getRawValue();
//			//Elevator.elevatorScaleVeryHighPosition = (double) elevator.getLine("elevatorScaleVeryHighPosition").getRawValue();
//			
//		} catch (NotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("4201 Error:Error reading Elevator section from config file");
//			//e.printStackTrace();
//		}
	}
}
