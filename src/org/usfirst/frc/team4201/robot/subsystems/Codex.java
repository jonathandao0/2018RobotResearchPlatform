package org.usfirst.frc.team4201.robot.subsystems;

import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.usfirst.frc.team4201.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Codex extends Subsystem {

	public static ScriptEngineManager manager;
	public ScriptEngine engine;
	public Invocable invoker = null;
	
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
				Invocable invokable  = (Invocable) engine;
				invokable.invokeFunction("initScript"); 
				Robot.m_chooser.addDefault(autoScripts[i], invokable);
			} catch (Exception e){
				System.out.println("4201 Error: Could not initialize " + autoScripts[i] + ".js");
			}
		}
	}
	
	public void loadScript() {
//		try {
//			Robot.m_chooser.getSelected().invokeFunction("initScript");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		};
		if(invoker != Robot.m_chooser.getSelected()) {
			invoker = Robot.m_chooser.getSelected();
			try {
				Robot.codex.invoker.invokeFunction("initScript"); // Need case structure for different commands requiring different arguments
			} catch(Exception e){
				DriverStation.reportError("4201 Error: Script could not be initialized", false);
		    	System.out.println(e.getMessage());
			}
		}
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
