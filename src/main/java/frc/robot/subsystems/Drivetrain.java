package frc.robot.subsystems;
import java.io.*;

public class Drivetrain {

    private static Drivetrain drivetrain;
    private static Drivetrain motor1;
    private static Drivetrain motor2;
    private static Drivetrain motor3;
    private static Drivetrain motor4;
   
    private Drivetrain() { }
 
    public static Drivetrain getInstance( ) {
      if(drivetrain == null){
         drivetrain = new Drivetrain();
      }
      return drivetrain;
    }
//motor speed, direction, rotational speed, distance
    /* Other methods protected by singleton-ness */
    void demoMethod() {
       System.out.println("demoMethod for singleton");
    }
    public static void TalonInit(boolean invert_state){
       if(invert_state == true){
          invert_state = false;
       }
    }
 }