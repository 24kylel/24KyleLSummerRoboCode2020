package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;
import frc.robot.subsystems.HatchLatcher;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class ToggleExtender extends InstantCommand {
    public ToggleExtender(){
        addRequirements(HatchLatcher.getInstance());
    }
    public void initialize(){
        HatchLatcher.getInstance().getFlowerSolenoid().invertValue();
                
    }
    public void isFinished(){
        return true;
    }




}