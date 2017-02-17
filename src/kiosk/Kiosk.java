 /******************************************************************************
 * Kiosk.java
 * Clara Durling
 * 
 * Main runner class for the kiosk.
 ******************************************************************************/
package kiosk;

import java.util.Scanner;
import handlers.Handlers;
import kioskGUIs.CheckInPage;

public class Kiosk {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        CheckInPage.show();
        Scanner reader = new Scanner(System.in);
        boolean run = true;
        do{
            System.out.println(" ");
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
                    run = false; // Breaks the loop
                    break;
                    
                default:
                    break;
                    
            } // End switch
            
        }while(run); // End do loop
        
        System.out.println("Goodbye!");
        
    } // End main method
    
} // End kiosk class
