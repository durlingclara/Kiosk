/*******************************************************************************
 * CheckInPage.java
 * Clara L. Durling
 * 
 * This class runs the JFrame for the check-in page for the kiosk
 ******************************************************************************/
package kioskGUIs;

import handlers.Handlers;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Clara L. Durling
 */
public class CheckInPage{

    /**
     *
     */
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
        JLabel birthdayRequest
                = new JLabel("Please enter your birthday (mm/dd)");
        birthdayRequest.setBounds(5, 50, 250, 20);
        
        JSpinner birthdayMonth = new JSpinner(new SpinnerNumberModel(0,0,12,1));
        birthdayMonth.setBounds(5, 75, 35, 20);
        
        JSpinner birthdayDay = new JSpinner(new SpinnerNumberModel(0,0,12,1));
        birthdayDay.setBounds(45, 75, 35, 20);
        
        
        final JFormattedTextField birthdayField = 
                new JFormattedTextField(createFormatter("##/##"));
        birthdayField.setBounds(5, 75, 85, 25);

        JButton submitInfo = new JButton("Enter");
        
            // Keyboard shortcut: Alt+ Enter
            submitInfo.setMnemonic(KeyEvent.VK_ENTER);
            submitInfo.setBounds(50, 100, 100, 25);
            submitInfo.addActionListener((ActionEvent e) -> {
                int month = (Integer)birthdayMonth.getValue();
                int day = (Integer)birthdayDay.getValue();
                String phoneNumber = (String)phoneNumberField.getValue();
                String birthday = convertBirthday(month, day);
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
        checkInFrame.add(birthdayMonth);
        checkInFrame.add(birthdayDay);
        checkInFrame.add(submitInfo);

        checkInFrame.setLayout(null);
        checkInFrame.setVisible(true);

    } // End method show()

    //**************************************************************************

    /**
     *
     * @param s - format
     * @return
     */

    private static MaskFormatter createFormatter(String s) {
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
        Boolean isAdmin = (birthday.equals("00/30") && 
                phoneNumber.equals("(000)000-0000"));
        return isAdmin;
    }
    
    //**************************************************************************
    
    private static String convertBirthday(int month, int day){
        String birthday;
        
        if(month == 0){
            return "00/00";
        } else if(month < 10){
            birthday = "0" + month;
        }else{
            birthday = "" + month;
        }
        
        if(day < 10){
            birthday += "/0" + day;
        }else{
            birthday += "/" + day;
        }
        
        return birthday;
    } // End private Static convertBirthday

} // End public class CheckInPage
