package edu.umsl;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo
 */


public class Salary extends Employee
{    
float salary;
boolean exec;
String type;
    public Salary(String Name, int Salary, boolean exec) 
    {
       this.Name = Name;
       this.salary = Salary;
       this.exec = exec;
       
    }
    
    public String EmployeeType()
    {
        if(this.exec = false)
        {
            this.type= "Staff";
            
        }
        else
        {
            this.type = "Executive";
        }
        
        return type;
    }

     @Override
     public float computeGross()
        {
            this.gross = (int) salary;
            JOptionPane.showMessageDialog(null, "Gross Pay: $" + gross);
            return gross;
          
        }
}

   
  

