package frc.robot.commands;


import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import static frc.robot.Constants.PhotonVisionConstants.*; 
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.PhotonVision;

public class CenterOnTarget extends PIDCommand {
  private PhotonVision photonVision;

  public CenterOnTarget(DriveTrain driveTrain, PhotonVision photonVision) {
    super(
        new PIDController(kP, kI, kD),
        photonVision::getTx,
        0.0,
        output -> driveTrain.tankDrive(-output, -output),
        driveTrain);
    getController().setTolerance(1);
    this.photonVision = photonVision;
  }

  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}