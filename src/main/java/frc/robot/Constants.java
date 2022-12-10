// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
import edu.wpi.first.math.util.Units;

public final class Constants {

    public static final class PhotonVisionConstants{

        public static final double CENTER_X = 1280/2;
        public static final double CENTER_Y = 720/2;
        public static final String CAMERA_NAME = "camera";
        public static final double kP = 0.0;
        public static final double kI = 0.0;
        public static final double kD = 0.0;
    
    }

    public static final class DriveTrainConstants {

        public static final int LEFT_PARENT_ID = 11;
        public static final int RIGHT_PARENT_ID = 12;
        public static final int LEFT_CHILD_ID = 21;
        public static final int RIGHT_CHILD_ID = 22;
    
        public static final double DRIVE_MAX_VOLTAGE = 12.0;
        public static final double RAMP_RATE = 0.1;
        public static final double DEADBAND = 0.1;
    
        public static final double CONVERSTIONRATETEST =
            1 / 2048 / 11.5 * Units.inchesToMeters(6.5) * Math.PI;
    
        public static final double CONVERSION_RATE_VELOCITY =
            Units.inchesToMeters(6.5) * Math.PI / 2048 / 10 / 11.5;
    
        public static final double CONVERSION_RATE_POSITION =
            Units.inchesToMeters(6.5) * Math.PI / 2048 / 11.5;
        public static final double rightResistanceAdjustment = 1;
    
        public static final double driveTrainRampDown = 0.7;
      }

}
