/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author clara.durling
 */
public abstract class Handlers {
    public static List<String> pNumber = new ArrayList();
    public static List<Integer> visits = new ArrayList();
    protected final static Scanner SCAN = new Scanner(System.in);
    
    //public abstract void member(phoneNumber);
    //public abstract void notMember(phoneNumber);
    
    public static Boolean check(String phoneNumber){
        boolean signedUp = pNumber.contains(phoneNumber);
        return signedUp;
    }
    
    public static String ask(){
        System.out.println("Please enter your ten-digit number.");
        System.out.println("Please do not use hyphens or parentheses.");
        String phoneNumber  = SCAN.next();
        return phoneNumber;
    }
    
    public static List<String> getNumbers(){
        return pNumber;
    }
    
    
}
