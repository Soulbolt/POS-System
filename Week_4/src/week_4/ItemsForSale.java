/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week_4;

/**
 *
 * @author Cesar
 */
public class ItemsForSale {
    public String itemName;
    public double itemCost;
    public boolean taxable;
    
    public void PopulateItem(String iName, double iCost, boolean canTax)
    {
        this.itemName = iName;
        this.itemCost = iCost;
        this.taxable = canTax;
    }
}
