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
    
    private final String phoneNumber;
    private String birthday;
    private int visits;
    private int freeBuffets;
    private int freeDrinks;
    private int dayLast;
    private int yearLast;
    
    //**************************************************************************
    
    public Member(String phoneNumber, String birthday){
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.visits = 0;
        this.freeDrinks = 0;
        this.freeBuffets = 0;
    }
    
    //**************************************************************************
    
    public Boolean checkedInToday(int dayNew, int yearNew) {
        return ((this.dayLast == dayNew) && (this.yearLast == yearNew));  
    }
    
    //**************************************************************************
    
    public String getBirthday(){
        return this.birthday;
    }
    
    //**************************************************************************
    
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    //**************************************************************************
    
    public String visitsMessage(){ 
        String message;
        
        this.visits++;
        
        if(this.visits == 5 || this.visits == 10){
            if(this.visits == 10){
                message = "Congrats! You've earned a free buffet!";
                this.visits = 0;
                this.freeBuffets++;
            }else{
                message = "Congrats! You've earned a free drink!";
                this.freeDrinks++;
            }
        }else{
            int checkInShow;
            int checkInsLeft = 10 - this.visits;
            if(checkInsLeft > 5){
                checkInShow = checkInsLeft - 5;
            }else{
                checkInShow = checkInsLeft;
            }
            message = "You have " + checkInShow + " visits remaining.";
        }
        
        return message;
    }
    
    //**************************************************************************
    
    public int getFreeDrinks(){
        return this.freeDrinks;
    }
    
    //**************************************************************************
    
    public void redeemDrink(){
        this.freeDrinks--;
    }
    
    //**************************************************************************
    
    public int getFreeBuffets(){
        /* TODO:
        For getting a free birthday buffet
        * Make it so it doesn't have to be their actual birthday, just close 
          (like 3-4 days)
        * Require that they not have redeemed a birthday buffet this year.
        */
        if(this.isBirthday()){
            this.freeBuffets++;
        }
        return this.freeBuffets;
    }
    
    public void redeemBuffet(){
        this.freeBuffets--;
    }
    
    //**************************************************************************
    
    public Boolean isBirthday(){
        String[] splitBirthday = this.birthday.split("/");
        
        int monthSaved = Integer.parseInt(splitBirthday[0].trim());
        int daySaved = Integer.parseInt(splitBirthday[1].trim());
        int month = CALENDAR.get(Calendar.MONTH) + 1;
        int day = CALENDAR.get(Calendar.DAY_OF_MONTH);
        
        return daySaved == day && monthSaved == month;
    }
    
    //**************************************************************************
    
    public void setLastCheckIn(int day, int year){
        this.dayLast = day;
        this.yearLast = year;
    }
    
    //**************************************************************************

    @Override
    public String toString() {
        return "Member: " + "Phone number: " + phoneNumber + ", birthday: " + 
                birthday  + ", last check-in: day " + dayLast + " of the year " 
                + yearLast;
    }
    
} // End class Member
