package edu.umsl;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import javax.swing.JOptionPane;



public class Payroll 
    {
    static Employee[] alemp = new Employee[3];
//    int size = alemp.lenght;

    
    
    public static void main (String[] args)
    {
        Payroll pr = new Payroll();
//        pr.Payroll();
//        pr.saveEmployee();
       

        String[] choices = { "Populate Employee", "Select Employee", "Save Employee", "Load Employee","Write File", "Exit"};
//            Payroll em = new Payroll();
            
            
        String Menuinput = (String)JOptionPane.showInputDialog(null, "Select One...", "UMSL INC.", JOptionPane.PLAIN_MESSAGE, null,choices,choices[0]);
               switch (Menuinput)
       
            {
               case "Populate Employee":
                pr.populateEmployee();
                pr.saveEmployee();
//                pr.writeFile();

               break;

               case "Select Employee":
                   if (alemp[0] == null)
                   {
                       JOptionPane.showMessageDialog(null,"No Employees on Record");
                       Payroll.main(args);
                   }
                   else
                   {
                        pr.selectEmployee();
                   }
               break;

               case "Save Employee":
                 pr.saveEmployee();
                   
               break;
               
              case "Load Employee":
                 pr.loadEmployee();
                   
               break;
              case "Write File":
                  pr.writeFile();
                  break;

               case "Exit":
                   System.exit(0);          
            }
        
    }        
    
    
    
    public void populateEmployee()
    {
//            Scanner sc = new Scanner(System.in);    
           for (int i=0; i<alemp.length; i++)
        {
            String[] choices = { "Hourly", "Comission", "Salary", "Exit"};
//            Payroll em = new Payroll();            
            
            String empchoice = (String)JOptionPane.showInputDialog(null, "Select Employee Type...", "UMSL INC.", JOptionPane.PLAIN_MESSAGE, null,choices,choices[0]);
                   switch (empchoice)
       
            {
               case "Hourly":
                   String firstName = JOptionPane.showInputDialog(null,"Enter First Name: ", "First Name");
                   String lastName = JOptionPane.showInputDialog(null,"Enter Last Name: ", "Last Name");
                   String Name = firstName + " " + lastName;
                   
                   float rate = Float.parseFloat(JOptionPane.showInputDialog(null,"Please enter rate: ", "$" ));
                   
                   float hrs = Float.parseFloat(JOptionPane.showInputDialog(null,"Please enter hours worked: ", "hours" ));
                  
                   
                   alemp[i] = new Hourly(Name, hrs, rate);                

               break;

               case "Comission":
                   firstName = JOptionPane.showInputDialog(null,"Enter First Name: ", "First Name");
                   

                   lastName = JOptionPane.showInputDialog(null,"Enter Last Name: ", "Last Name");
                   

                   Name = firstName + " " + lastName;
                   
                   int itemNum = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter number of items sold: "));
                   int itemCost = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter price of items sold: "));
                   

                   alemp[i] = new Comish(Name, itemNum, itemCost);
                 
                
               break;

               case "Salary":
                 
                 firstName = JOptionPane.showInputDialog(null,"Enter First Name: ", "First Name");
                   
                 lastName = JOptionPane.showInputDialog(null,"Enter Last Name: ", "Last Name");
                   
                 Name = firstName + " " + lastName;
                   
                 String[] c = { "Executive", "Staff", "Exit"};
                 String sal = (String)JOptionPane.showInputDialog(null, "Select One...", "UMSL INC.", JOptionPane.PLAIN_MESSAGE, null,c,c[0]);
                 int salary=0;
                 boolean exec = false;
                 switch (sal)
                   {
                       case "Executive":
                           salary = 100000;
                           exec = false;
                       break;
                       case "Staff":
                           salary = 50000;
                           exec = true;
                       break;
                    }
                           
                    alemp[i] = new Salary(Name, salary, exec);
                    
                break;
                
               case "Exit":
                   Payroll.main(choices);
                      
               
            }
            saveEmployee();       
        }
           selectEmployee();
    }

public static void selectEmployee() //throws IOException
    {
         loadEmployee();
        
         
         String[] Employees = { alemp[0].getName(), alemp[1].getName(), alemp[2].getName(), "Exit"};
         String menu = (String)JOptionPane.showInputDialog(null, "Select One...", "UMSL INC.", JOptionPane.PLAIN_MESSAGE, null,Employees,Employees[0]);
         
         if(menu.equals(alemp[0].getName()))
         {
             alemp[0].menu();
             selectEmployee();     
             
         }
         
          if(menu.equals(alemp[1].getName()))
         {
         
              alemp[1].menu();
              selectEmployee();
        }
         if(menu.equals(alemp[2].getName()))
          {
              alemp[2].menu();
              selectEmployee();
          }
         switch(menu)
         {
             case "Exit":
                Payroll.main(Employees);
             break;
         }
          

      

        saveEmployee();
        
        }
         public static void saveEmployee()
         {
             try
		{
        		FileOutputStream fos = new FileOutputStream("EmployeePayroll.txt");
        		ObjectOutputStream oos = new ObjectOutputStream(fos);
        		
			oos.writeObject(alemp);
        		oos.flush();
        		fos.close();
                        
        	}
        	catch (IOException e)
		{
        		System.err.println(e);
        	}
//            writeFile();
         }
         
         public static void loadEmployee()
         {
             try
		{
			FileInputStream fis = new FileInputStream("EmployeePayroll.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			alemp = (Employee[])ois.readObject();
//			fis.close();
//                        for(int i = 0; i < alemp.length; i++)
//                        {
//                            alemp[i].showAll();
//                        }
                }
		catch (Exception e)
		{
                    System.err.println("An error was encounter please try again.");
		}
             
         }
          
         public static void writeFile() 
         {
             
          try
          {
              FileWriter fw = new FileWriter("EmployeeText.txt");
              for (int i=0;i<alemp.length;i++)
              {
//                  fw.write(alemp[i]+"");
                  String name = alemp[i].Name;
                  float hours = alemp[i].hours;
                  float gross = alemp[i].gross;
                  float tax = alemp[i].tax;
                  float net = alemp[i].net;
                  float netper = alemp[i].net_percent;
                 
                  fw.write("\r\n");
                  fw.write("Name: " + name);
                  System.lineSeparator();
                  fw.write("\r\n");
                  fw.write("Hours: " + Float.toString (hours) + " hrs.");
                  fw.write("\r\n");
                  fw.write("Gross Salary: $ " + Float.toString(gross));
                  fw.write("\r\n");
                  fw.write("Tax Paid: $ " + Float.toString(tax));
                  fw.write("\r\n");
                  fw.write("Net Pay: $ " + Float.toString(net));
                  fw.write("\r\n");
                  fw.write("Net Percentage: % " + Float.toString(netper));
                  fw.write("\r\n");
              }
              fw.close();
          }
          
              
//              pw.println("Employee: ");
//              pw.println(alemp[0].Name);
//              pw.println(alemp[0].gross);
//              pw.println(alemp[0].hours);
//              pw.println(alemp[0].net);
//              pw.println(alemp[0].net_percent);
//              pw.println(alemp[0].tax);
          
          catch(IOException e)
            {
              
            }
     
           JOptionPane.showMessageDialog(null,"Text File Has Been Created"); 
           
         }
        
}

                 
