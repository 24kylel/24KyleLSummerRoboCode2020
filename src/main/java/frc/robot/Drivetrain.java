package frc.robot;

class Drivetrain 
{ 
    private static Drivetrain single_instance = null; 
  
    public String s; 
  
    private Drivetrain() 
    { 
        s = "Hello I am a string part of Drivetrain class"; 
    } 
  
    public static Drivetrain getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new Drivetrain(); 
  
        return single_instance; 
    } 
} 