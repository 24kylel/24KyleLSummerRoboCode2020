package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;
public class HatchLatcher extends SubsystemBase{
    private static HatchLatcher singleInstance; 
    private DoubleSolenoid extenderSolenoid;
    private DoubleSolenoid flowerSolenoid;


    private HatchLatcher() { 
       extenderSolenoid = new DoubleSolenoid(RobotMap.FORWARD_CHANNEL_EXTENDER, RobotMap.REVERSE_CHANNEL_EXTENDER);
       flowerSolenoid = new DoubleSolenoid(RobotMap.FORWARD_CHANNEL_FLOWER, RobotMap.REVERSE_CHANNEL_FLOWER);

    } 
    public static DoubleSolenoid.Value invertValue(DoubleSolenoid.Value solenoidValue){
        if(solenoidValue == DoubleSolenoid.Value.kForward){
            return DoubleSolenoid.Value.kReverse;
        }
        else if(solenoidValue == DoubleSolenoid.Value.kReverse){
            return DoubleSolenoid.Value.kForward;
        }
        else{
            return DoubleSolenoid.Value.kForward;
        }
    }
    public DoubleSolenoid getExtenderSolenoid(){
        return extenderSolenoid;
    } 
    public DoubleSolenoid getFlowerSolenoid(){
        return flowerSolenoid;
    } 
    public static HatchLatcher getInstance() 
    { 
        if (singleInstance == null) 
            singleInstance = new HatchLatcher(); 
  
        return singleInstance; 
    }
    
  } 
 

