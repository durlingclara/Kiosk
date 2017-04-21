/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kioskGUIs;


import handlers.Handlers;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.MaskFormatter;

public class CheckInPage{

    public static void show() {
        JFrame checkInFrame = new JFrame("Check-in");
        checkInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        checkInFrame.setBounds(300, 200, 500, 300);
    
        JLabel phoneNumberRequest = 
                new JLabel("Please enter your 10-digit phone number:");
        phoneNumberRequest.setBounds(5, 5, 250, 20);
    
        final JFormattedTextField phoneNumberField = 
                new JFormattedTextField(createFormatter("(###)###-####"));
        phoneNumberField.setBounds(5, 25, 95, 25);
    
        // TODO: validate phoneNumber as a valid phoneNumber
    
        JLabel birthdayRequest = 
                new JLabel("Please enter your birthday (mm/dd)");
        birthdayRequest.setBounds(5, 50, 250, 20);
    
        final JFormattedTextField birthdayField = 
                new JFormattedTextField(createFormatter("##/##"));
        birthdayField.setBounds(5, 75, 85, 25);
    
        JButton submitInfo = new JButton("Enter");
        
            // Keyboard shorcut: Alt+ Enter
            submitInfo.setMnemonic(KeyEvent.VK_ENTER);
            submitInfo.setBounds(50, 100, 100, 25);
            submitInfo.addActionListener((ActionEvent e) -> {
                String phoneNumber = (String)phoneNumberField.getValue();
                String birthday = (String)birthdayField.getValue();
                boolean isAdmin = checkForAdmin(phoneNumber, birthday);
                checkInFrame.dispose();
                
                if(isAdmin){
                    MainProgramPage.show();
                }else{
                    Handlers.checkIn(phoneNumber, birthday);
                    WelcomePage.show();
                }
            });
    
        checkInFrame.add(phoneNumberRequest);
        checkInFrame.add(phoneNumberField);
        checkInFrame.add(birthdayRequest);
        checkInFrame.add(birthdayField);
        checkInFrame.add(submitInfo);
    
        checkInFrame.setLayout(null);
        checkInFrame.setVisible(true);

    } // End method show()
    
    //**************************************************************************

    protected static MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
        return formatter;
    }
    
    //**************************************************************************
  
    private static boolean checkForAdmin(String phoneNumber, String birthday){
        if(birthday == null){
            birthday = "0/0";
        }
        Boolean isAdmin = (birthday.equals("77/20") && 
                phoneNumber.equals("(000)000-0000"));
        return isAdmin;
    }

}
