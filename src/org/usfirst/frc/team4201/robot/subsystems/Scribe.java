package org.usfirst.frc.team4201.robot.subsystems;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Scribe extends Subsystem{

	public static ScriptEngineManager factory;
	public ScriptEngine engine;
	
	public Scribe() {
		super("ScriptEngine");
		
		factory = new ScriptEngineManager();
		engine = factory.getEngineByName("JavaScript");
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
