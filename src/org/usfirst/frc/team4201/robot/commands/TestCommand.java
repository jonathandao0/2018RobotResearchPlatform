package org.usfirst.frc.team4201.robot.commands;

import edu.wpi.first.wpilibj.command.BBCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TestCommand extends BBCommand {
	public static int count = 0;
	
    public TestCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putNumber("Test Command Executions", ++count);
    }

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
	
    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

}
