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
public class Customer {
    public String firstName;
    public String lastName;
    
    public String FullName()
    {
        return this.firstName+" "+this.lastName;
    }
}
