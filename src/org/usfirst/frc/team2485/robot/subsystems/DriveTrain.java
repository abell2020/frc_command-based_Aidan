package org.usfirst.frc.team2485.robot.subsystems;

import org.usfirst.frc.team2485.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem{

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	public void setLeftRight(double leftOutput, double rightOutput) {
		
		RobotMap.driveMotorL1.set(leftOutput);
		RobotMap.driveMotorL2.set(leftOutput);
		RobotMap.driveMotorL3.set(leftOutput);
		
		RobotMap.driveMotorR1.set(rightOutput);
		RobotMap.driveMotorR2.set(rightOutput);
		RobotMap.driveMotorR3.set(rightOutput);
	}
	public void warlordDrive(double controllerY, double controllerX) {
		
		double leftPower = controllerY*(1+controllerX);
		double rightPower = controllerY*(1-controllerX);
		if(Math.abs(leftPower) > 1) {
			leftPower /= Math.abs(leftPower);
			rightPower /= Math.abs(leftPower);
		}
		if(Math.abs(rightPower) > 1) {
			leftPower /= Math.abs(rightPower);
			rightPower /= Math.abs(rightPower);
		}
		setLeftRight(leftPower,rightPower);
		
	}
}
