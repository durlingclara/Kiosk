/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public abstract class Handlers {
    public static List<String> pNumber = new ArrayList();
    public static List<Integer> visits = new ArrayList();
    public static List<Integer> years = new ArrayList();
    public static List<Integer> days = new ArrayList();
    public static List<String> birthdays = new ArrayList();
    protected final static Scanner SCAN = new Scanner(System.in);
    
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
        if(birthday.equals("")){
            birthday = "0/0";
        }
        
        boolean signedUp = Handlers.isMember(phoneNumber);
         
        if(signedUp){
            Member member = new Member(phoneNumber);
            
            int memberNumber = member.getMemberNumber();
            
            String birthdaySaved = member.getBirthday();
            if(!birthday.equals(birthdaySaved) && !birthday.equals("0/0")){
                birthdays.set(memberNumber, birthday);
            }
            
            Boolean isBirthday = member.isBirthday();
            
            int day = Calendar.DAY_OF_YEAR;
            int year = Calendar.YEAR;
            
            boolean canCheckIn = !member.sameDay(day, year);
            
            if(!canCheckIn){
                System.out.println("Sorry, you already checked in today.");
                if(isBirthday){
                    System.out.println("Happy Birthday! To celebrate, you can have your buffet for free!");
                }
            }else{
                System.out.println("You have been checked in successfully.");
                days.set(memberNumber, day);
                years.set(memberNumber, year);
                if(isBirthday){
                    System.out.println("Happy Birthday! To celebrate, you can have your buffet for free!");
                }
            }
            
        }else{
            
            int day = Calendar.MINUTE;
            days.add(day);
            int year = Calendar.HOUR_OF_DAY;
            years.add(year);
            
            pNumber.add(phoneNumber);
            birthdays.add(birthday);
            visits.add(0);
            
            System.out.println("Thank you for signing up!");
        }
    }
    
    public static void askRedeem(){
        System.out.println("Please enter your ten-digit number.");
        System.out.println("Please do not use hyphens, parentheses, or spaces.");
        String phoneNumber  = SCAN.next();
        boolean signedUp = Handlers.isMember(phoneNumber);
        
        if(signedUp){
            System.out.println("You do not presently have any rewards to redeem.");
        }else{
            System.out.println("Please sign up for the rewards program before trying to redeem a reward.");
        }
    }
    
    public static List<String> getNumbers(){
        return pNumber;
    }
}
