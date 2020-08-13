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
   public static final int KPLEFT = 1;
   public static final int KILEFT = 2;
   public static final int KDLEFT = 3;

   public static final int KPRIGHT = 1;
   public static final int KIRIGHT = 2;
   public static final int KDRIGHT = 3;

   public static final int PSLOT = 1;

   private static final boolean RIGHT_MASTER_INVERTED = false;
   private static final boolean RIGHT_FOLLOWER_INVERTED = false;
   private static final boolean LEFT_MASTER_INVERTED = false;
   private static final boolean LEFT_FOLLOWER_INVERTED = false;
   
   private static final boolean RIGHT_MASTER_SENSOR_PHASE = false;
   
   private static final boolean LEFT_MASTER_SENSOR_PHASE = false;

   public static int ALLOWABLE_ERROR;

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
      
      leftMaster.configSelectedFeedbackSensor(CTRE_MagEncoder_Relative, RobotMap.LOOP_INDEX_PRIMARY);

   }
   public void configPositionPIDConstants(){
      leftMaster.config_kP(PSLOT, KPLEFT);
      leftMaster.config_kI(PSLOT, KILEFT);
      leftMaster.config_kD(PSLOT, KDLEFT);
      
      rightMaster.config_kP(PSLOT, KPRIGHT);
      rightMaster.config_kI(PSLOT, KIRIGHT);
      rightMaster.config_kD(PSLOT, KDRIGHT);

      leftMaster.selectProfileSlot(PSLOT, RobotMap.LOOP_INDEX_PRIMARY);
      rightMaster.selectProfileSlot(PSLOT, RobotMap.LOOP_INDEX_PRIMARY);
      

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