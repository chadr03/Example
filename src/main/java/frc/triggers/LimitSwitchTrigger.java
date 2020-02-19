/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.triggers;

import edu.wpi.first.wpilibj2.command.button.Button;

import frc.robot.subsystems.LiftSubsystem;

/**
 * Add your docs here.
 */
public class LimitSwitchTrigger extends Button {
  public LiftSubsystem m_lift = new LiftSubsystem();

  public LimitSwitchTrigger(LiftSubsystem lift){
    m_lift = lift;

  }
	public boolean get() {
		return m_lift.isSensorTrue();
	}
}