package frc.robot.subsystems;
public class Drivetrain {

    private static Drivetrain drivetrain = new Drivetrain( );
 
    private Drivetrain() { }
 
    public static Drivetrain getInstance( ) {
       return drivetrain;
    }
 
    /* Other methods protected by singleton-ness */
    static void demoMethod( ) {
       System.out.println("demoMethod for singleton");
    }
 }
  class DrivetrainDemo {

    public static void main(String[] args) {
       Drivetrain tmp = Drivetrain.getInstance( );
       tmp.demoMethod( );
    }
 } 