package org.usfirst.frc.team2485.robot;

import org.usfirst.frc.team2485.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2485.robot.subsystems.Shooter;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//ports
	public static final int kLeftShooterCAN = 3, kRightShooterCAN = 2;
	
	//motors
	public static CANTalon leftShooterMotor, rightShooterMotor;
	public static CANTalon driveMotorL1,driveMotorL2,driveMotorL3,driveMotorR1,driveMotorR2,driveMotorR3;
	
	//solenoids
	public static Solenoid lowerSolenoid, upperSolenoid;
	
	//subsystems
	public static DriveTrain driveTrain;
	public static Shooter shooter;
	
	
	public static void init() {
		//construct hardware
		//drive train
		driveMotorL1 = new CANTalon(1);
		driveMotorL2= new CANTalon(2);
		driveMotorL3 = new CANTalon(3);
		driveMotorR1 = new CANTalon(4);
		driveMotorR2 = new CANTalon(5);
		driveMotorR3 = new CANTalon(6);
		//shooter
		leftShooterMotor = new CANTalon(kLeftShooterCAN);
		rightShooterMotor = new CANTalon(kRightShooterCAN);
		
		//configure hardware
		//drive train
		driveMotorR1.setInverted(true);
		driveMotorR2.setInverted(true);
		driveMotorR3.setInverted(true);
		//shooter
		leftShooterMotor.setInverted(true);
		rightShooterMotor.setInverted(false);
		rightShooterMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		leftShooterMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		lowerSolenoid = new Solenoid(4);
		upperSolenoid = new Solenoid(5);
		//do it the right way
		
		//construct subsystems
		driveTrain = new DriveTrain();
		shooter = new Shooter();

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
