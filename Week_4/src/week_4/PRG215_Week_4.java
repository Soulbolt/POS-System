/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week_4;

import java.util.Scanner;

/**
 *
 * @author Cesar
 */
public class PRG215_Week_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Constant for the total number of items for sale
        final int TOTAL_ITEMS=6;
        
        //Create the items object arrays
        ItemsForSale[] items = new ItemsForSale[TOTAL_ITEMS];
        
        //Loop and instantiate each object - you must always create the individual object
        for(int i = 0; i<TOTAL_ITEMS; i++)
        {
            items[i] = new ItemsForSale();
        }
        
        //Use the PopulateItem method from the ItemsForSale class to insert the properties of each item object for sale
        items[0].PopulateItem("Tennis Shoes", 45.69, true);
        items[1].PopulateItem("Shirts", 25.55, true);
        items[2].PopulateItem("Coats", 89.99, true);
        items[3].PopulateItem("Belts", 15, true);
        items[4].PopulateItem("Pants", 25.99, true);
        items[5].PopulateItem("Donation", 10, false);
        
        //Variables to for the financial calculations
        double totalAmount = 0.0;
        double totalTax = 0.0;
        final double taxRate = 0.081;
        
        //Discounts for large purchases
        final double DISCOUNT_RATE = 0.025; //2.5%
        final double AMOUNT_TO_QUALIFY_FOR_DISCOUNT = 100;
        double discountAmount=0;
        
        //Display items for sale on the console
        System.out.println("The following clothing items are available for purchase: ");
        for(int i=0; i<items.length; i++)
        {
            //Display each item in the array
            System.out.println("  "+(i+1)+"."+items[i].itemName+" for $"+items[i].itemCost+" each");
        }
        System.out.println("");
        
        //Create a keyboard input object
        Scanner keyboard = new Scanner(System.in);
        
        //Create a new customer object
        Customer newCust = new Customer();
        
        //Display on the console - ask for customer's first name
        System.out.print("Please enter your first name: ");
        
        //Get the customer first name from the keyboard and store it in a newCust object;s .firstName property
        newCust.firstName = keyboard.next();
        
        System.out.println();
        
        //Display on the console - ask for customer's last name
        System.out.print("Please enter your last name: ");
        
        //Get the customer last name from the keyboard and store it in the newCust object's .lastName property
        newCust.lastName = keyboard.next();
        
        System.out.println("");
        
        //Display customer's full name (a method in the Customer class) and provide instructions
        System.out.println("Ok, "+newCust.FullName()+", please enter the product ID (the number to the left of the item name) that you wish to purchase. Enter 0 when you are finished.");
        
        //Loop until user neters 0
        int itemID = 0; //Set the condition to 0
        int itemCounter = 1; //No longer loop condition counter, now used for display
        do
        {
            //prompt the user
            System.out.print("Please enter item ID number"+(itemCounter)+"(enter 0 to exit): ");
            itemID = keyboard.nextInt();
            
            //Test the user did not enter exit condition
            if(itemID>0)
            {
                //If the user has not entered 0, then add to the total
                totalAmount = totalAmount+items[itemID - 1].itemCost;
                
                //Moved tax calculation to here since we might not charge tax on all items
                if(items[itemID - 1].taxable == true)
                {
                    totalTax = totalTax+(items[itemID -1].itemCost*taxRate);
                }
                
                //Increment the item display counter
                itemCounter++;
            }
        } while(itemID !=0); //Check if exit condition has been met
        
        //The loop is complete, calculate the discount and taxes and then display the results
        if(totalAmount>= AMOUNT_TO_QUALIFY_FOR_DISCOUNT)
        {
            discountAmount = totalAmount*DISCOUNT_RATE;
        }
        else
        {
            discountAmount = 0;
        }
        
        //Display the results
        System.out.println("");
        System.out.println("You selcted "+itemCounter+" items to purchase.");
        System.out.println("Your sales total $"+totalAmount);
        System.out.println("Your disocunt amount is $"+discountAmount);
        System.out.println("Your sales tax is $"+totalTax);
        System.out.println("The total amount due is $"+(totalAmount - discountAmount+totalTax));
        System.out.println("");
    }
    
}
