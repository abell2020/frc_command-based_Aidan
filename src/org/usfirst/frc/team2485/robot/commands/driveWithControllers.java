package org.usfirst.frc.team2485.robot.commands;

import org.usfirst.frc.team2485.robot.OI;
import org.usfirst.frc.team2485.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class driveWithControllers extends Command{

	private void init() {
		// TODO Auto-generated method stub

	}

	public driveWithControllers() {
		requires(RobotMap.driveTrain);
		setInterruptible(true);
		
	}
	
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		double steering = OI.driver.getRawAxis(OI.XBOX_RIGHT_X);
		double throttle = -1*(OI.driver.getRawAxis(OI.XBOX_LEFT_Y));
		RobotMap.driveTrain.warlordDrive(throttle, steering);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
