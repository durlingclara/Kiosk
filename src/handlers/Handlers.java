/*******************************************************************************
 * Handlers.java
 * Clara Durling
 * 
 * This class handles the input, sometimes delegating to other classes, and
 * sometimes creating new objects of the Member class, which are put in a Map.
 ******************************************************************************/

package handlers;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public abstract class Handlers {
    protected final static Scanner SCAN = new Scanner(System.in);
    
    // Map to store and retrieve text program members
    private static Map<String, Member> members = new HashMap();
    private static Set<String> phoneNumbers = members.keySet();
    
    // Access the actual calendar
    public static Calendar CALENDAR = Calendar.getInstance();
    
    //**************************************************************************
    
    public static Member getMember(String phoneNumber){
        Member member = members.get(phoneNumber);
        return member;
    }
    
    //**************************************************************************
    
    public static Boolean isMember(String phoneNumber){
        boolean signedUp = phoneNumbers.contains(phoneNumber);
        return signedUp;
    }
    
    //**************************************************************************
    
    public static void checkIn(String phoneNumber, String birthday) {
        
        if (birthday == null) {
            birthday = "0/0";
        }

        boolean signedUp = isMember(phoneNumber);
        if (signedUp) {
            Member member = members.get(phoneNumber);

            String birthdaySaved = member.getBirthday();
            if (!birthday.equals(birthdaySaved) && !birthday.equals("0/0")) {
                member.setBirthday(birthday);
            }

            Boolean isBirthday = member.isBirthday();
            if (isBirthday) {
                System.out.println("Happy Birthday! To celebrate, you can have "
                        + "your buffet for free!");
            }
            
            int day = CALENDAR.get(Calendar.DAY_OF_YEAR);
            int year = CALENDAR.get(Calendar.YEAR);

            boolean canCheckIn = !member.checkedInToday(day, year);

            if (!canCheckIn) {
                System.out.println("Sorry, you already checked in today.");
            } else {
                String message = member.visitsMessage();
                System.out.println(message);
                member.setLastCheckIn(day, year);
            }
            
        // End of if(signedUp)
        } else {
            // What to do when there is no member signed up with the provided #
            Member member = new Member(phoneNumber, birthday);
            int day = CALENDAR.get(Calendar.DAY_OF_YEAR);
            int year = CALENDAR.get(Calendar.YEAR);
            member.setLastCheckIn(day, year);

            members.put(phoneNumber, member);
            
        }
    } // End method checkIn
    
    //**************************************************************************
    
    public static void askRedeem(){
        System.out.println("Please enter your ten-digit number.");
        System.out.println("Please do not use hyphens, parentheses, or spaces.");
        String phoneNumber  = SCAN.next();
        boolean signedUp = Handlers.isMember(phoneNumber);
        
        if(signedUp){
            Member member = members.get(phoneNumber);
            Rewards.redeem(member);
        }else{
            System.out.println("Please sign up for the rewards program before "
                    + "trying to redeem a reward.");
        }
    }
    
    //**************************************************************************
    
    public static String getData(){
        /* When a line says data = data + [something], it adds the something onto
         * the String data, but the next time I add something to String data, the
         * previously added information disappears.  I'm not sure why, except 
         * that this problem only begins when the for loop is entered.
         */
        String data = "";
        int i;
        int membershipSize = phoneNumbers.size();
        data = "Membership size: " + membershipSize;
        StringBuilder s = new StringBuilder();
        s.append(data).append("\n");
        for(String key : phoneNumbers){
            Member memberReport = members.get(key);
            s.append(memberReport.toString()).append("\n");
        }
        return s.toString();
        
    } // End getData()
}