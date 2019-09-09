package edu.umsl;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public abstract class Employee implements Serializable
{
    /*********************
	     Attributes
	*********************/
	float rate=30.0f;
	float taxrate=0.2f;
	float hours=45f;
	float gross=0.0f;
	float tax=0.0f;
	float net=0.0f;
	float net_percent=0.0f;
        String Name;
//        public static int counter;
       
        public Employee()
        {
            
        }
        public void menu()
        {
           String[] Menu = {"Calculate Gross Pay", "Calculate Tax", "Calculate Net Pay", "Calculate Net Percent", "Display Employee", "Exit"};
           String input = (String)JOptionPane.showInputDialog(null, "Select One...", "UMSL INC.", JOptionPane.PLAIN_MESSAGE, null,Menu,Menu[0]);
        
           switch (input)
           {
//               case "Calculate":
//                   computeGross();
//                   computeTax();
//                   computeNet();
//                   computeNetperc();
//                   break;
                   
                case "Calculate Gross Pay":
                    computeGross();
                    break;
                case "Calculate Tax":
                    computeTax();
                    break;
                case "Calculate Net Pay":
                    computeNet();
                    break;
                case "Calculate Net Percent":
                    computeNetperc();
                    break;
                case "Display Employee":
                    displayEmployee();
                    break;
                case "Exit":
                    Payroll.saveEmployee();
                    Payroll.selectEmployee();
                    break;
           }
                menu();
        }
        
        public String getName()
        {
            return Name;
        }
        
     
        public float computeGross()
        {
            gross = (rate*hours);
            JOptionPane.showMessageDialog(null, "Gross pay: " + gross);
            return gross;
        }
               

	protected float computeTax() 
{ 
            tax=gross*taxrate;
            JOptionPane.showMessageDialog(null, "Tax is $" + tax);
            return tax;
	}

	protected float computeNet()
        { 
            net=gross-tax;
            JOptionPane.showMessageDialog(null, "Net Salary is $" + net);
            return net;
        }

	protected float computeNetperc() 
        { 
            net_percent=(net/gross)*100;
            JOptionPane.showMessageDialog(null, "Net Pecent:  " + net_percent);
            return net_percent;
        }
	
	protected void displayEmployee() 
{
    
//		System.out.println("Hours: " + hours);
//		System.out.println("Rate: " + rate);
//		System.out.println("Gross: " + new Float(gross));
//		System.out.println("Net: " + net);
//		System.out.println("Net%: " + net_percent + "%");
                JOptionPane.showMessageDialog(null, "<html>Hours: "+hours+ "hrs. <br>Rate: $"+rate+" /hr. <br>Gross: $"+gross+". <br>Net: $"+net+". <br> Net Percent: "+net_percent+"%");


}

    
} 	

