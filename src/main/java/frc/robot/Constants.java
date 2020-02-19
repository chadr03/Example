/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {


//CAN ID's
public static final int LEFT_DRIVE_MOTOR_LEAD_PORT = 1;
public static final int LEFT_DRIVE_MOTOR_FOLLOW_PORT = 5;
public static final int RIGHT_DRIVE_MOTOR_LEAD_PORT = 3;
public static final int RIGHT_DRIVE_MOTOR_FOLLOW_PORT = 4;
public static final int LAUNCHER_MOTOR_LEAD_PORT = 5;
public static final int LAUNCHER_MOTOR_FOLLOW_PORT = 6;

public static final int LIFT_MOTOR_LEAD_PORT = 2;
public static final int LIFT_MOTOR_FOLLOW_PORT = 6;

public static final int SPARK_MAX_PORT = 9;

//PWM PORTS
public static final int INTAKE_MOTOR_PORT = 0;
public static final int CONVEYOR_TOP_MOTOR_PORT = 1;
public static final int CONVEYOR_BOTTOM_MOTOR_PORT = 2;

public static final int LED_PORT = 9;


//PCM PORTS
public static final int INTAKE_PCM_PORT = 0;
public static final int HANGER_OPEN_PCM_PORT = 1;
public static final int HANGER_CLOSED_PCM_PORT = 2;
public static final int LIFT_BRAKE_PCM_PORT = 3;


//DIO Ports
public static final int INTAKE_SENSOR = 0;
public static final int LAUNCHER_SENSOR = 1;


//Joystick Ports
public static final int DRIVE_JOYSTICK_PORT = 0;
public static final int MANIPULATE_JOYSTICK_PORT = 1;


//Gamepad Buttons and Axis

public static final int GP_LEFT_X_AXIS = 0;
public static final int GP_LEFT_Y_AXIS = 1;
public static final int GP_RIGHT_X_AXIS = 4;
public static final int GP_RIGHT_Y_AXIS = 5;
public static final int GP_LEFT_TRIGGER = 2;
public static final int GP_RIGHT_TRIGGER = 3;

public static final int GP_A_BUTTON = 1;
public static final int GP_B_BUTTON = 2;
public static final int GP_X_BUTTON = 3;
public static final int GP_Y_BUTTON = 4;
public static final int GP_LEFT_BUMPER = 5;
public static final int GP_RIGHT_BUMPER = 6;
public static final int GP_BACK_BUTTON = 7;
public static final int GP_START_BUTTON = 8;
public static final int GP_LEFT_JOYSTICK_BUTTON = 9;
public static final int GP_RIGHT_JOYSTICK_BUTTON = 10;


//Mechanism Constants
public static final double CONVEYOR_SPEED = 0.6;
public static final double LAUNCHER_SPEED = 5000;
public static final int SPARK_MAX_CURRENT_LIMIT = 60;
public static final int TALON_SRX_PEAK_CURRENT_LIMIT = 60;
public static final int TALON_SRX_CONT_CURRENT_LIMIT = 40;
public static final int TALON_SRX_PEAK_CURRENT_DURATION = 100;

//Lift Motion Magic
public static final double LIFT_KP = 0.2;
public static final double LIFT_KI = 0.0;
public static final double LIFT_KD = 0.0;
public static final double LIFT_KF = 0.2;
public static final double LIFT_KIZONE = 0.0;
public static final double LIFT_KPEAK_OUTPUT = 1.0;
public static final int LIFT_CRUISE_VELOCITY = 15000;
public static final int LIFT_ACCELERATION = 6000;









/**
 * Which PID slot to pull gains from. Starting 2018, you can choose from
 * 0,1,2 or 3. Only the first two (0,1) are visible in web-based
 * configuration.
 */
public static final int kSlotIdx = 0;
public static final int kPIDLoopIdx = 0;
public static final int kTimeoutMs = 30;


}



