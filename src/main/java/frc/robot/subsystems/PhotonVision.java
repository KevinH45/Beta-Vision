// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
// DOCS: https://docs.photonvision.org/en/latest/docs/programming/photonlib/getting-target-data.html#getting-apriltag-data-from-a-target

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;
import org.photonvision.targeting.TargetCorner;

import java.util.List;
import java.util.ArrayList;
import static frc.robot.Constants.PhotonVisionConstants.*; 

public class PhotonVision extends SubsystemBase {

  private final PhotonCamera camera = new PhotonCamera(CAMERA_NAME);
  private List<PhotonTrackedTarget> targets = new ArrayList<>();
  private PhotonTrackedTarget bestTarget;

  /** Creates a new PhotonVision. */
  public PhotonVision() {

  }

  public void updateBestTarget(PhotonPipelineResult result){
    if (!result.hasTargets()){
      bestTarget = null;
      return;
    }
    bestTarget = result.getBestTarget();
  }

  public void updateTargets(PhotonPipelineResult result){
    if (!result.hasTargets()){
      targets.clear();
      return;
    }
    targets = result.getTargets();
  }

  public PhotonTrackedTarget getBestTarget(){
    return bestTarget;
  }

  public double getTargetYaw(PhotonTrackedTarget target){
    return target.getYaw();
  }

  public double getTargetPitch(PhotonTrackedTarget target){
    return target.getPitch();
  }

  public double getTargetArea(PhotonTrackedTarget target){
    return target.getArea();
  }

  public int getId(PhotonTrackedTarget target){
    return target.getFiducialId();
  }

  /**
   * Acts as the PhotonVision equivalent of Limelight::getTx()
  @return Amount of pixels between center of "screen" and center of bounding box horizontally.
  */
  public double getTx(){
      PhotonTrackedTarget target = getBestTarget();
      List<TargetCorner> corners = target.getCorners();
      double leftCorner = corners.get(0).x;
      double rightCorner = corners.get(3).x;
      
      return (leftCorner-rightCorner)/2 - CENTER_X;
  }
  /**
   * Acts as the PhotonVision equivalent of Limelight::getTy()
  @return Amount of pixels between center of "screen" and center of bounding box vertically.
  */
  public double getTy(){

    PhotonTrackedTarget target = getBestTarget();
    List<TargetCorner> corners = target.getCorners();
      
    double leftCorner = corners.get(0).y;
    double rightCorner = corners.get(3).y;

    return (leftCorner-rightCorner)/2 - CENTER_Y;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    var result = camera.getLatestResult();
    updateBestTarget(result);
    updateTargets(result);
  }
}
