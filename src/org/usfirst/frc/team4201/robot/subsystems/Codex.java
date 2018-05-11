package org.usfirst.frc.team4201.robot.subsystems;

import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.usfirst.frc.team4201.robot.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Codex extends Subsystem {

	public static ScriptEngineManager manager;
	public ScriptEngine engine;
	
	private static final String[] autoScripts = {
		"SimpleTest",
		"ClassCallTest",
		//"FunctionReturn",
		"FMSReadTest",
		//"InvalidCallTest"
	};
	
	public Codex() {
		super("ScriptEngine");
		
		manager = new ScriptEngineManager();
		engine = manager.getEngineByName("nashorn");
	}
	
	public void initAutoScripts() {
		for (int i = 0; i < autoScripts.length; i++) {
			try {
				String filePath = "/media/sda1/4201RobotFiles/AutoRoutines/" + autoScripts[i] + ".js";
				engine.eval(new FileReader(filePath));
				Invocable invocable = (Invocable) engine;
				Robot.m_chooser.addDefault(autoScripts[i], invocable);
			} catch (Exception e){
				System.out.println("4201 Error: Could not initialize " + autoScripts[i] + ".js");
			}
		}
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}