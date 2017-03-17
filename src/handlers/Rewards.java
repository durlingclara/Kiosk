/*******************************************************************************
 * Rewards.java
 * Clara Durling
 * 
 * This class will handle WHAT rewards a person has.
 ******************************************************************************/
package handlers;

public class Rewards extends Handlers{
    
    public static void redeem(Member member){
        int buffetsEarned = member.getFreeBuffets();
        int drinksEarned = member.getFreeDrinks();
            
            Boolean isBirthday = member.isBirthday();
            if(isBirthday){
                System.out.println("Happy Birthday! To celebrate, you can have your buffet for free!");
            }else{
                System.out.println("It is not your birthday today.");
            }
        
        if(buffetsEarned == 0 && drinksEarned == 0){
            System.out.println("You have no rewards to redeem.");
        }else{
            if(buffetsEarned != 0){
                System.out.println("You have " + buffetsEarned + " free buffets available to redeem.");
                System.out.print("Please enter the number of buffets you would like to redeem: ");
                int toRedeem = SCAN.nextInt();
                Rewards.redeemBuffet(member, toRedeem, buffetsEarned);
            }
            if(drinksEarned != 0){
                System.out.println("You have " + drinksEarned + " free drinks available to redeem.");
                System.out.print("Please enter the number of buffets you would like to redeem: ");
                int toRedeem = SCAN.nextInt();
                Rewards.redeemBuffet(member, toRedeem, drinksEarned);
            }
        }
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
