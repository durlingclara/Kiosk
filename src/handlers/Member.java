/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import java.util.Calendar;

/**
 *
 * @author durlicla000
 */
public class Member extends Handlers{
    private final int memberNumber;
    
    public Member(String phoneNumber){
        this.memberNumber = pNumber.indexOf(phoneNumber);
    }
    
    public int getMemberNumber(){
        return this.memberNumber;
    }
    
    public Boolean sameDay(int dayNew, int yearNew) {
        int dayLast = (int) days.get(this.memberNumber);
        int yearLast = (int) years.get(this.memberNumber);
        return ((dayLast == dayNew) && (yearLast == yearNew));  
    }
    
    public int getVisits(){ 
        int checkIns = visits.get(this.memberNumber);
        return checkIns;
    }
    
    public String getBirthday(){
        String birthday = birthdays.get(this.memberNumber);
        return birthday;
    }
    
    public Boolean isBirthday(){
        String birthday = birthdays.get(this.memberNumber);
        String[] splitBirthday = birthday.split("/");
        int daySaved = Integer.parseInt(splitBirthday[1].trim());
        int monthSaved = Integer.parseInt(splitBirthday[0].trim());
        int day = Calendar.DAY_OF_MONTH;
        int month = Calendar.MONTH;
        return daySaved == day && monthSaved == month;
    }
}
