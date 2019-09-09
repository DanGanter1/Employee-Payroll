package edu.umsl;

import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author danny
 */


public class Hourly extends Employee
{
   float overtime;
//   float otsalary;
  
   
   public Hourly(String Name, float hrs, float rate)
   {
       this.Name = Name;
       this.hours = hrs;
       this.rate = rate;
       
       if (hrs >= 40)
       {
           this.overtime = hrs-40;
           this.hours = 40;
       }
       
   }
   
   @Override
   public float computeGross()
   {
      float otsalary = overtime*(rate*1.5f);
      float grossreg = hours*rate; 
      this.gross = grossreg + otsalary;
     
      JOptionPane.showMessageDialog(null, "<html>Regular: $"+grossreg+ ". <br>Overtime: $"+otsalary+". <br>Gross: $"+gross+".");

//      JOptionPane.showMessageDialog(null, "Overtime: " + otsalary);
//      JOptionPane.showMessageDialog(null, "Gross Pay: $" + gross); 
      return gross;
   }
   
    
}
