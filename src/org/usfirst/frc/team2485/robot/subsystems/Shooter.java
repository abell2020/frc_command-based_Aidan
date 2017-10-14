package org.usfirst.frc.team2485.robot.subsystems;

import java.util.Timer;
import java.util.TimerTask;

import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.util.SpeedControllerWrapper;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem{

	public static enum HoodPosition {
		LOW_ANGLE, HIGH_ANGLE, STOWED
	};
	
	public static double RPS_LONG_SHOT = 95, 
			RPS_BATTER_SHOT = 80;
	
	private static final HoodPosition DEFAULT_HOOD_POSITION = HoodPosition.HIGH_ANGLE;
	private SpeedControllerWrapper shooterMotors; //Go through SpeedControllerWrapper
	private HoodPosition currHoodPosition;
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public Shooter() {
		
		shooterMotors = new SpeedControllerWrapper(new SpeedController[] { RobotMap.leftShooterMotor, 
				RobotMap.rightShooterMotor }, new int[] { 0, 0 });
		currHoodPosition = DEFAULT_HOOD_POSITION;
		
		//disableShooter();
	}
	
	public void setHoodPosition(HoodPosition newHoodPosition) {
		if (newHoodPosition == HoodPosition.LOW_ANGLE) {
			if (currHoodPosition == HoodPosition.HIGH_ANGLE) {
				RobotMap.upperSolenoid.set(true); // This should extend the upper piston
			} else if (currHoodPosition == HoodPosition.STOWED) {
				RobotMap.lowerSolenoid.set(false); // Retracting the lower piston pulls open the shooter
//				new Timer().schedule(new TimerTask() {
////timer?
//					@Override
//					public void run() {
//						RobotMap.upperSolenoid.set(true);
//					}
//				}, 250);
		}
		}
		else if (newHoodPosition == HoodPosition.HIGH_ANGLE) {
			if (currHoodPosition == HoodPosition.LOW_ANGLE) {
				RobotMap.upperSolenoid.set(false);

			} else if (currHoodPosition == HoodPosition.STOWED) {
				RobotMap.lowerSolenoid.set(false);
			}
		}
			
			else { // setting to stowed

				if (currHoodPosition == HoodPosition.LOW_ANGLE) {

					RobotMap.upperSolenoid.set(false);

//					new Timer().schedule(new TimerTask() {
//
//						@Override
//						public void run() {
//							RobotMap.lowerSolenoid.set(true);
//						}
//					}, 250);

				} else if (currHoodPosition == HoodPosition.HIGH_ANGLE) {
					RobotMap.lowerSolenoid.set(true);
				}
			}
				
		currHoodPosition = newHoodPosition;
	}
	
	
	public void resetHood() {
		currHoodPosition = DEFAULT_HOOD_POSITION;
	}
	
	public HoodPosition getHoodPosition() {
		return currHoodPosition;
	}
	
	public double getCurrentPower() {

		return shooterMotors.get();
		
	}
	
	public void setShooter(double pwm) {
		
		shooterMotors.set(pwm);
	}
}
