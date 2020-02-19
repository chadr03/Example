/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.SpinTalonCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.LEDSubsystem;
import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import frc.triggers.LimitSwitchTrigger;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  
  private final LiftSubsystem lift = new LiftSubsystem();
  private final LEDSubsystem led = new LEDSubsystem(/*lift*/);
  private final LauncherSubsystem launcher = new LauncherSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  Joystick driverController = new Joystick(0);

  // A simple auto routine that drives forward a specified distance, and then stops.
  private final Command lightsGreen = new RunCommand(led::green, led);


  // A complex auto routine that drives forward, drops a hatch, and then drives backward.
  private final Command talonOn = new SpinTalonCommand(lift);

  private final Command multi = new WaitCommand(2).andThen(new RunCommand(led::red, led));

  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();





  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    SmartDashboard.putData("Green", new RunCommand(led::green, led));
    SmartDashboard.putData("Blue", new RunCommand(led::blue, led));
    SmartDashboard.putData("Red", new RunCommand(led::red, led));
    SmartDashboard.putData("Blue Pulse", new RunCommand(led::bluePulse, led));
    SmartDashboard.putData("Blue Streak", new RunCommand(led::blueStreak, led));
    led.rainbow();
    SmartDashboard.putData("Motion Magic", new RunCommand(lift::motionMagicLift, lift));
    SmartDashboard.putData("10000", new InstantCommand(lift::liftSet10000,lift));
    SmartDashboard.putData("0", new InstantCommand(lift::liftSet0, lift));
    SmartDashboard.putData("Launch Closed Loop", new RunCommand(launcher::velocityClosedLoopLaunch, launcher));
    // Assign default commands
    //led.setDefaultCommand(
    //  new RunCommand(led::rainbow, led));


    lift.setDefaultCommand(
    
       new RunCommand(() -> lift
  
    //    // A split-stick arcade command, with forward/backward controlled by the left
    //     // hand, and turning controlled by the right.
          .manualLift(-driverController.getRawAxis(Constants.GP_LEFT_Y_AXIS)), lift));   
    //   .teleopDrive(-driverController.getRawAxis(Constants.GP_LEFT_Y_AXIS),
    //                driverController.getRawAxis(Constants.GP_RIGHT_X_AXIS)), drive));

    launcher.setDefaultCommand(
    
      new RunCommand(() -> launcher
 
   //    // A split-stick arcade command, with forward/backward controlled by the left
   //     // hand, and turning controlled by the right.
         .manualLanuch(-driverController.getRawAxis(Constants.GP_RIGHT_Y_AXIS)), launcher));  

    
    
         // Configure the button bindings
    configureButtonBindings();


        // Add commands to the autonomous command chooser
        m_chooser.addOption("Run Talon", talonOn);
        m_chooser.addOption("Green Lights", lightsGreen);
        m_chooser.addOption("Multi", multi);
    
        // Put the chooser on the dashboard
        Shuffleboard.getTab("Autonomous").add(m_chooser);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Put Some buttons on the SmartDashboard
    // Grab the hatch when the 'A' button is pressed.
    new JoystickButton(driverController, Constants.GP_A_BUTTON)
        .whileHeld(() -> lift.manualMotionMagicLift(driverController.getRawAxis(Constants.GP_LEFT_X_AXIS)), lift);

    //(() -> lift.manualMotionMagicLift(driverController.getRawAxis(Constants.GP_LEFT_X_AXIS)), lift);

    new POVButton(driverController, 0)
        .whenPressed(new RunCommand(lift::pov0, lift))
        .whenPressed(new RunCommand(led::blue, led));

    new POVButton(driverController, 90)
        .whenPressed(new RunCommand(lift::pov90, lift))
        .whenPressed(new RunCommand(led::rainbow, led));

    new POVButton(driverController, 180)
        .whenPressed(new RunCommand(lift::pov180, lift))
        .whenPressed(new RunCommand(led::bluePulse, led));

    new POVButton(driverController, 270)
        .whenPressed(new RunCommand(lift::pov270, lift))
        .whenPressed(new RunCommand(led:: red, led));

    
    new LimitSwitchTrigger(lift).whenPressed(new RunCommand(led::green, led));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_chooser.getSelected();
  }
}
