 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;


import java.util.Scanner;
//import handlers.CheckIn;
//import handlers.Redeem;
import handlers.Handlers;

/**
 *
 * @author clara.durling
 */
public class Kiosk {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        
        // My for loop keeps things in the list. 0 acts as false and 1 acts as true.
        for(int i = 1; i != 0;){
            System.out.println("Welcome to Pizza Pie Cafe!");
            System.out.println("Type 'Check-in' or 'Redeem,' then push enter.");
            
            String action = reader.next();
            String act = action.trim().toLowerCase();
            switch (act) {
                
                case "check-in":
                    Handlers.askCheckIn();
                    break;
                    
                case "redeem":
                    Handlers.askRedeem();
                    break;
                    
                case "stop":
                    System.out.println(Handlers.getNumbers()); // Prints out the list of numbers signed up
                    i = 0; // Breaks the loop
                    break;
                    
                default:
                    i = 1; // Keeps the loop going
                    break;
                    
            } // End switch
            
        } // End for loop
        
        System.out.println("Goodbye!");
        
    } // End main method
    
} // End kiosk class
