package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.Drivetrain;
import com.ctre.phoenix.motorcontrol.ControlMode;
import java.lang.Math;
public class DriveToPosition extends CommandBase {
    public static int desiredPosition;
    public static int ALLOWABLE_ERROR;

    public DriveToPosition(int positionInitializer){
        desiredPosition = positionInitializer;
        addRequirements(Drivetrain.getInstance());
        Drivetrain.getInstance().configPositionPIDConstants();
        Drivetrain.getInstance().getLeftMaster().setSelectedSensorPosition(0);
        Drivetrain.getInstance().getRightMaster().setSelectedSensorPosition(0);

    }
    public void execute(){
        Drivetrain.getInstance().getLeftMaster().set(ControlMode.Position, desiredPosition);
        Drivetrain.getInstance().getRightMaster().set(ControlMode.Position, desiredPosition);
    }
    public boolean isFinished(){
        if(Math.abs(Drivetrain.getInstance().getLeftMaster().getSelectedSensorPosition() - desiredPosition) < ALLOWABLE_ERROR && 
            Math.abs(Drivetrain.getInstance().getRightMaster().getSelectedSensorPosition() - desiredPosition) < ALLOWABLE_ERROR){
            return true; 
        }
        else{
            return false;
        }
        
        
        
    }
    public void end(boolean interrupted){
        Drivetrain.getInstance().getRightMaster().set(ControlMode.Disabled, 0);
        Drivetrain.getInstance().getLeftMaster().set(ControlMode.Disabled, 0);

        
    }
}