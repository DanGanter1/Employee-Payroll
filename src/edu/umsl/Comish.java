package edu.umsl;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Comish extends Employee 
{   
    int itemNum;
    int itemCost;
    public Comish(String Name,int itemNum, int itemCost) 
    {
        this.Name = Name;
        this.itemNum = itemNum;
        this.itemCost = itemCost;
    }

    @Override
  public float computeGross()
   {
      this.gross = ((itemNum*itemCost)/2);
      
      JOptionPane.showMessageDialog(null, "Gross Pay: $" + gross);
      return gross;
    
   }
   
    
}


