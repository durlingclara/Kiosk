/*******************************************************************************
 * Rewards.java
 * Clara Durling
 * 
 * This class will handle WHAT rewards a person has.
 ******************************************************************************/
package handlers;

public class Rewards extends Handlers{
    
    public static void redeem(int memberNumber){
        int buffetsEarned = rewardBuffets.get(memberNumber);
        int drinksEarned = rewardDrinks.get(memberNumber);
        
        if(buffetsEarned == 0 && drinksEarned == 0){
            System.out.println("You have no rewards to redeem.");
        }else{
            if(buffetsEarned != 0){
                System.out.println("You have " + buffetsEarned + " free buffets available to redeem.");
                System.out.print("Please enter the number of buffets you would like to redeem: ");
                int toRedeem = SCAN.nextInt();
                Rewards.redeemBuffet(memberNumber, toRedeem, buffetsEarned);
            }
            if(drinksEarned != 0){
                System.out.println("You have " + drinksEarned + " free drinks available to redeem.");
                System.out.print("Please enter the number of buffets you would like to redeem: ");
                int toRedeem = SCAN.nextInt();
                Rewards.redeemBuffet(memberNumber, toRedeem, drinksEarned);
            }
        }
    }
    
    public static void redeemDrink(int memberNumber, int toBeRedeemed, int earned){
        int drinksLeft = earned - toBeRedeemed;
        rewardDrinks.set(memberNumber, drinksLeft);
    }
    
    public static void redeemBuffet(int memberNumber, int toBeRedeemed, int earned){
        int buffetsLeft = earned - toBeRedeemed;
        rewardBuffets.set(memberNumber, buffetsLeft);
    }
    
}
