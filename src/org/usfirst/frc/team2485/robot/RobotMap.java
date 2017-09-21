package org.usfirst.frc.team2485.robot;

import org.usfirst.frc.team2485.robot.subsystems.DriveTrain;


import com.ctre.CANTalon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static CANTalon driveMotorL1,driveMotorL2,driveMotorL3,driveMotorR1,driveMotorR2,driveMotorR3;
	public static DriveTrain driveTrain;
	public static void init() {
		//construct hardware
		driveMotorL1 = new CANTalon(1);
		driveMotorL2= new CANTalon(2);
		driveMotorL3 = new CANTalon(3);
		driveMotorR1 = new CANTalon(4);
		driveMotorR2 = new CANTalon(5);
		driveMotorR3 = new CANTalon(6);
		
		//configure hardware
		driveMotorR1.setInverted(true);
		driveMotorR2.setInverted(true);
		driveMotorR3.setInverted(true);
		
		//construct subsystems
		driveTrain = new DriveTrain();
	}
	

	
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
