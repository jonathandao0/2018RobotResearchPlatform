package org.usfirst.frc.team4201.robot.subsystems;

import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.usfirst.frc.team4201.robot.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Scribe extends Subsystem {

	public static ScriptEngineManager manager;
	public ScriptEngine engine;
	
	private static final String[] autoScripts = {
		"SimpleTest",
		"ClassCallTest",
		"FunctionReturn",
		"FMSReadTest",
		"InvalidCallTest"
	};
	
	public Scribe() {
		super("ScriptEngine");
		
		manager = new ScriptEngineManager();
		engine = manager.getEngineByName("nashorn");
	}
	
	public void initAutoScripts() {
		for (int i = 1; i < autoScripts.length; i++) {
			String filePath = "/media/sda1/4201RobotFiles/AutoRoutines/" + autoScripts[i] + ".js";
			engine.eval(new FileReader(filePath));
			Invocable invocable = (Invocable) engine;
			Robot.m_chooser.addDefault(autoScripts[i], invocable);
		}
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
