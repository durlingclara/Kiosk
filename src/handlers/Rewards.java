/*******************************************************************************
 * Rewards.java
 * Clara Durling
 * 
 * This class will handle WHAT rewards a person has.
 ******************************************************************************/
package handlers;

import java.util.Scanner;
import kioskGUIs.WelcomePage;

public class Rewards{
    
    public static void redeem(Member member){
        Scanner reader = new Scanner(System.in);
        int buffetsEarned = member.getFreeBuffets();
        int drinksEarned = member.getFreeDrinks();
            
            Boolean isBirthday = member.isBirthday();
            if(isBirthday){
                System.out.println("Happy Birthday! To celebrate, you can have "
                        + "your buffet for free!");
            }else{
                System.out.println("It is not your birthday today.");
            }
        
        if(buffetsEarned == 0 && drinksEarned == 0){
            System.out.println("You have no rewards to redeem.");
        }else{
            if(buffetsEarned != 0){
                System.out.println("You have " + buffetsEarned + " free buffets "
                        + "available to redeem.");
                System.out.print("Please enter the number of buffets you would "
                        + "like to redeem: ");
                int toRedeem = reader.nextInt();
                Rewards.redeemBuffet(member, toRedeem, buffetsEarned);
            }
            if(drinksEarned != 0){
                System.out.println("You have " + drinksEarned + " free drinks "
                        + "available to redeem.");
                System.out.print("Please enter the number of buffets you would "
                        + "like to redeem: ");
                int toRedeem = reader.nextInt();
                Rewards.redeemBuffet(member, toRedeem, drinksEarned);
            }
        }
        
        WelcomePage.show();
    }
    
    public static void redeemDrink(Member member, int toBeRedeemed, int earned){
        int drinksLeft = earned - toBeRedeemed;
        member.setFreeDrinks(drinksLeft);
    }
    
    public static void redeemBuffet(Member member, int toBeRedeemed, int earned){
        int buffetsLeft = earned - toBeRedeemed;
        member.setFreeBuffets(buffetsLeft);
    }
    
}
