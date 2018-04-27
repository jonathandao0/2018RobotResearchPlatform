package org.usfirst.frc.team4201.robot.commands;

import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRoutineScriptWrapper extends CommandGroup {
	String gameData;
	
	ScriptEngineManager factory;
	ScriptEngine engine;
	
    public AutoRoutineScriptWrapper(String scriptName) {
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		factory = new ScriptEngineManager();
		engine = factory.getEngineByName("JavaScript");
		
		try {
			if (scriptName != null) {
				engine.eval(new FileReader(scriptName));
				Invocable invokable = (Invocable) engine;
				invokable.invokeFunction("autoRoutine"); // Need case structure for different commands requiring different arguments
				//boolean test = (boolean) invokable.invokeFunction("autoRoutine"); // Need case structure for different commands requiring different arguments
			}
		} catch(Exception e){
			DriverStation.reportError("4201 Error: Auto script could not be evalulated", true);
		}
    }
}
