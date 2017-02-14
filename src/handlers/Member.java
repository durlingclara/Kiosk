/*******************************************************************************
 * Member.java
 * Clara Durling
 * 
 * This class contains methods to be able to work with the information of a
 * single member of the text program.
 ******************************************************************************/
package handlers;

import java.util.Calendar;

public class Member extends Handlers{
    private final int memberNumber;
    
    public Member(String phoneNumber){
        this.memberNumber = pNumber.indexOf(phoneNumber);
    }
    
    public int getMemberNumber(){
        return this.memberNumber;
    }
    
    public Boolean checkedInToday(int dayNew, int yearNew) {
        int dayLast = (int) days.get(this.memberNumber);
        int yearLast = (int) years.get(this.memberNumber);
        return ((dayLast == dayNew) && (yearLast == yearNew));  
    }
    
    public String displayVisits(){ 
        String message;
        int checkIns = visits.get(this.memberNumber);
        checkIns++;
        
        if(checkIns == 5 || checkIns == 10){
            if(checkIns == 10){
                message = "Congrats! You've earned a free buffet!";
                visits.set(this.memberNumber, 0);
                int freeBuffets = rewardBuffets.get(this.memberNumber);
                freeBuffets++;
                rewardBuffets.set(this.memberNumber, freeBuffets);
            }else{
                message = "You've earned a free drink!";
                visits.set(this.memberNumber, checkIns);
                int freeDrinks = rewardDrinks.get(this.memberNumber);
                freeDrinks++;
                rewardDrinks.set(this.memberNumber, freeDrinks);
            }
        }else{
            visits.set(this.memberNumber, checkIns);
            int checkInShow;
            int checkInsLeft = 10 - checkIns;
            if(checkInsLeft > 5){
                checkInShow = checkInsLeft - 5;
            }else{
                checkInShow = checkInsLeft;
            }
            message = "You have " + checkInShow + " visits remaining.";
        }
        
        return message;
    }
    
    public String getBirthday(){
        String birthday = birthdays.get(this.memberNumber);
        return birthday;
    }
    
    public Boolean isBirthday(){
        String birthday = birthdays.get(this.memberNumber);
        String[] splitBirthday = birthday.split("/");
        
        int monthSaved = Integer.parseInt(splitBirthday[0].trim());
        int daySaved = Integer.parseInt(splitBirthday[1].trim());
        int month = CALENDAR.get(Calendar.MONTH) + 1;
        int day = CALENDAR.get(Calendar.DAY_OF_MONTH);
        
        return daySaved == day && monthSaved == month;
    }
}