package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import harkerrobolib.wrappers.HSTalon;
import com.ctre.phoenix.motorcontrol.ControlMode;
public class Drivetrain extends SubsystemBase {

   private static Drivetrain drivetrain;
   
   private HSTalon leftMaster;
   private HSTalon leftFollower;
   private HSTalon rightMaster;
   private HSTalon rightFollower;
   int PLeft = 1;
   int ILeft = 2;
   int DLeft = 3;

   int PRight = 1;
   int IRight = 2;
   int DRight = 3;

   int pSpecificSlot = 1;
   int pSpecificSlot2 = 2;

   private static final boolean RIGHT_MASTER_INVERTED = false;
   private static final boolean RIGHT_FOLLOWER_INVERTED = false;
   private static final boolean LEFT_MASTER_INVERTED = false;
   private static final boolean LEFT_FOLLOWER_INVERTED = false;
   
   private static final boolean RIGHT_MASTER_SENSOR_PHASE = false;
   
   private static final boolean LEFT_MASTER_SENSOR_PHASE = false;
   private Drivetrain() { 
      leftMaster = new HSTalon(RobotMap.LEFT_MASTER_CANID);
      leftFollower = new HSTalon(RobotMap.LEFT_FOLLOWER_CANID);
      rightMaster = new HSTalon(RobotMap.RIGHT_MASTER_CANID);
      rightFollower = new HSTalon(RobotMap.RIGHT_FOLLOWER_CANID);
   }
   
   public void talonInit() {
      leftMaster.configFactoryDefault();
      leftFollower.configFactoryDefault();
      rightMaster.configFactoryDefault();
      rightFollower.configFactoryDefault();

      leftFollower.follow(leftMaster);
      rightFollower.follow(rightMaster);
      
      leftMaster.setInverted(LEFT_MASTER_INVERTED);
      leftFollower.setInverted(LEFT_FOLLOWER_INVERTED);
      rightMaster.setInverted(RIGHT_MASTER_INVERTED);
      rightFollower.setInverted(RIGHT_FOLLOWER_INVERTED);
      
      rightMaster.setSensorPhase(RIGHT_MASTER_SENSOR_PHASE);
      leftMaster.setSensorPhase(LEFT_MASTER_SENSOR_PHASE);
      
   }
   public void configPositionPIDConstants(){
      leftMaster.config_kP(pSpecificSlot, PLeft);
      leftMaster.config_kI(pSpecificSlot, ILeft);
      leftMaster.config_kD(pSpecificSlot, DLeft);
      
      rightMaster.config_kP(pSpecificSlot2, PRight);
      rightMaster.config_kI(pSpecificSlot2, IRight);
      rightMaster.config_kD(pSpecificSlot2, DRight);
      

   }

   public void setPercentOutput(double speed, double turn) {
      leftMaster.set(ControlMode.PercentOutput, speed + turn);
      rightMaster.set(ControlMode.PercentOutput, speed - turn);   
   }

   public static Drivetrain getInstance(){
      if(drivetrain == null){
         drivetrain = new Drivetrain();
      }
      return drivetrain;
   }
}