package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.Drivetrain;
import com.ctre.phoenix.motorcontrol.ControlMode;
import java.lang.Math;
public class DriveToPosition extends CommandBase {
    public static int desiredPosition;
    public static int ALLOWABLE_ERROR;

    public DriveToPosition(int positionInitializer, Drivetrain subsystem){
        desiredPosition = positionInitializer;
        addRequirements(subsystem);
        Drivetrain.getInstance().configPositionPIDConstants();
        Drivetrain.getInstance().getLeftMaster().setSelectedSensorPosition(0);
        Drivetrain.getInstance().getRightMaster().setSelectedSensorPosition(0);

    }
    public static void DriveToPositionExec(){
        Drivetrain.getInstance().getLeftMaster().set(ControlMode.Position, desiredPosition);
        Drivetrain.getInstance().getRightMaster().set(ControlMode.Position, desiredPosition);
    }
    public boolean isFinished(){
        boolean a;
        boolean b;
        boolean c = false;
        if(Math.abs(Drivetrain.getInstance().getLeftMaster().getSelectedSensorPosition() - desiredPosition) < ALLOWABLE_ERROR){
            a = true;  
        }
        else{
            return false;
        }
        if(Math.abs(Drivetrain.getInstance().getRightMaster().getSelectedSensorPosition() - desiredPosition) < ALLOWABLE_ERROR){
             b = true;
        }
        else{
            return false;
        }
        if(a == true && b == true){
            c = true;
        }
        return c;
    }
    public void END(){
        if (isFinished() == true){
            Drivetrain.getInstance().getRightMaster().set(ControlMode.Disabled, 0);
            Drivetrain.getInstance().getLeftMaster().set(ControlMode.Disabled, 0);

        }
    }
}