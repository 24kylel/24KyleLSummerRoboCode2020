package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.Drivetrain;

public class DriveToPosition extends CommandBase {
    int desiredPosition;

    public DriveToPosition(int positionInitializer, Drivetrain subsystem){
        desiredPosition = positionInitializer;
        addRequirements(subsystem);
        configPositionPIDConstants()
        leftMaster.setSelectedSensorPosition(0);
        rightMaster.setSelectedSensorPosition(0);

    }

}