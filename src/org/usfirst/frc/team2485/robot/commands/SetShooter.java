package org.usfirst.frc.team2485.robot.commands;

import org.usfirst.frc.team2485.robot.RobotMap;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class SetShooter extends InstantCommand{

	public SetShooter() {
		requires(RobotMap.shooter);
		
	}
	
	public void execute() {
		RobotMap.shooter.setShooter(.4);
	}

}
