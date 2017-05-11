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
        
        boolean signedUp = isMember(phoneNumber);
        if (signedUp) {
            Member member = members.get(phoneNumber);

            String birthdaySaved = member.getBirthday();
            if (!birthday.equals(birthdaySaved) && !birthday.equals("0/0")) {
                member.setBirthday(birthday);
            }

            Boolean isBirthday = member.isBirthday();
            
            int day = CALENDAR.get(Calendar.DAY_OF_YEAR);
            int year = CALENDAR.get(Calendar.YEAR);

            boolean canCheckIn = !member.checkedInToday(day, year);

            if (!canCheckIn) {
                String message = "Sorry, you already checked in today.";
            } else {
                String message = member.visitsMessage();
                //CheckInMessagePage.showMessage(message, isBirthday);
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
            String message = "Thank you for signing up!";
            //CheckInMessagePage.showMessage(message, false);
        }
    } // End method checkIn
    
    //**************************************************************************
    
    public static Member checkRedeem(String phoneNumber){
        boolean signedUp = Handlers.isMember(phoneNumber);
        
        if(signedUp){
            Member member = members.get(phoneNumber);
            return member;
        }else{
            return null;
        }
    }
    
    //**************************************************************************
    
    public static String getData(){
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
