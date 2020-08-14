package frc.robot;
import harkerrobolib.wrappers.HSGamepad;
class Singleton 
{ 
    private static Singleton single_instance ; 
  
    private HSGamepad driverGamepad;
    private HSGamepad operatorGamepad;
  
    private Singleton() 
    { driverGamepad = new XboxGamepad(port);
        operatorGamepad = new ;

    } 
  
    public static Singleton getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new Singleton(); 
  
        return single_instance; 
    } 
} 