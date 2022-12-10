// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final DriveTrain drivetrain = new DriveTrain();
  private final PhotonVision photonVision = new PhotonVision();

  // Goofy OI
  private Joystick leftDriveJoystick = new Joystick(0); // should be in port 0
  private Joystick rightDriveJoystick = new Joystick(1); // should be in port 1
  public XboxController xboxController = new XboxController(2); // should be in port 2
  public JoystickButton aButton = new JoystickButton(xboxController, 1);
  public JoystickButton bButton = new JoystickButton(xboxController, 2);
  public JoystickButton xButton = new JoystickButton(xboxController, 3);
  public JoystickButton yButton = new JoystickButton(xboxController, 4);
  public JoystickButton lbButton = new JoystickButton(xboxController, 5);
  public JoystickButton rbButton = new JoystickButton(xboxController, 6);
  public JoystickButton startButton = new JoystickButton(xboxController, 8);
  public JoystickButton backButton = new JoystickButton(xboxController, 7);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    aButton.whenPressed(new CenterOnTarget(drivetrain, photonVision));
    
  }

  public void teleInit(){
    photonVision.register();
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
