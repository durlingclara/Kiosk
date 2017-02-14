/*******************************************************************************
 * Handlers.java
 * Clara Durling
 * 
 * This class holds information and works with input.
 ******************************************************************************/
package handlers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public abstract class Handlers {
    protected final static Scanner SCAN = new Scanner(System.in);
    
    // Lists for storing information on those who have signed up.
    public static List<String> pNumber = new ArrayList();
    public static List<Integer> visits = new ArrayList();
    public static List<Integer> years = new ArrayList();
    public static List<Integer> days = new ArrayList();
    public static List<String> birthdays = new ArrayList();
    public static List<Integer> rewardDrinks = new ArrayList();
    public static List<Integer> rewardBuffets = new ArrayList();
    
    // Access the actual calendar
    public static Calendar CALENDAR = Calendar.getInstance();
    
    public static Boolean isMember(String phoneNumber){
        boolean signedUp = pNumber.contains(phoneNumber);
        return signedUp;
    }
    
    public static void askCheckIn(){
        System.out.println("Please enter your ten-digit number.");
        System.out.println("Please do not use hyphens, parentheses, or spaces.");
        String phoneNumber  = SCAN.next();
        
        System.out.println("Please enter your birthday (mm/dd)");
        String bDay = SCAN.next(); 
        String birthday = bDay.trim();
        
        // TODO - make it possible for the user to not give input for their birthday
//        if(birthday.equals("")){
//            birthday = "0/0";
//        }
        
        boolean signedUp = Handlers.isMember(phoneNumber);
         
        if(signedUp){
            Member member = new Member(phoneNumber);
            
            int memberNumber = member.getMemberNumber();
            
            String birthdaySaved = member.getBirthday();
            if(!birthday.equals(birthdaySaved) && !birthday.equals("0/0")){
                birthdays.set(memberNumber, birthday);
            }
            
            Boolean isBirthday = member.isBirthday();
            if(isBirthday){
                System.out.println("Happy Birthday! To celebrate, you can have your buffet for free!");
            }else{
                System.out.println("It is not your birthday today.");
            }
            
            int day = CALENDAR.get(Calendar.DAY_OF_YEAR);
            int year = CALENDAR.get(Calendar.YEAR);
            
            boolean canCheckIn = !member.checkedInToday(day, year);
            
            if(!canCheckIn){
                System.out.println("Sorry, you already checked in today.");
            }else{
                String message = member.displayVisits();
                System.out.println(message);
                days.set(memberNumber, day);
                years.set(memberNumber, year);    
            }
            
        }else{
            
            int day = CALENDAR.get(Calendar.DAY_OF_YEAR);
            days.add(day);
            int year = CALENDAR.get(Calendar.YEAR);
            years.add(year);
            
            pNumber.add(phoneNumber);
            birthdays.add(birthday);
            visits.add(0);
            rewardDrinks.add(0);
            rewardBuffets.add(0);
            
            System.out.println("Thank you for signing up!");
        }
    }
    
    public static void askRedeem(){
        System.out.println("Please enter your ten-digit number.");
        System.out.println("Please do not use hyphens, parentheses, or spaces.");
        String phoneNumber  = SCAN.next();
        boolean signedUp = Handlers.isMember(phoneNumber);
        
        if(signedUp){
            Member member = new Member(phoneNumber);
            int memberNumber = member.getMemberNumber();
            Rewards.redeem(memberNumber);
        }else{
            System.out.println("Please sign up for the rewards program before trying to redeem a reward.");
        }
    }
    
    public static List<String> getNumbers(){
        return pNumber;
    }
}