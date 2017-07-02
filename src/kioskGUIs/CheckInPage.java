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
import javax.swing.JComboBox;
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
        checkInFrame.setResizable(false);
        
//        JPanel myPanel = (JPanel)checkInFrame.getContentPane();
//        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));

        JLabel phoneNumberRequest = 
                new JLabel("Please enter your 10-digit phone number:");
        phoneNumberRequest.setBounds(5, 5, 400, 20);

        final JFormattedTextField phoneNumberField = 
                new JFormattedTextField(createFormatter("(###)###-####"));
        phoneNumberField.setBounds(5, 25, 110, 25);

        // TODO: validate phoneNumber as a valid phoneNumber
        
        JLabel birthdayRequest =
                new JLabel("Please enter your birthday:");
        birthdayRequest.setBounds(5, 50, 250, 20);
        
        String[] months = {"--", "January", "February", "March", "April", "May",
                    "June", "July", "August", "September", "October", "November",
                    "December"};
        
        JComboBox monthSelection = new JComboBox(months);
        monthSelection.setBounds(5, 75, 85, 20);
        
        JSpinner birthdayDay = new JSpinner(new SpinnerNumberModel(1,1,31,1));
        birthdayDay.setBounds(95, 75, 35, 20);
        
        JButton submitInfo = new JButton("Enter");
        
            // Keyboard shortcut: Alt+ Enter
            submitInfo.setMnemonic(KeyEvent.VK_ENTER);
            submitInfo.setBounds(50, 100, 100, 25);
            submitInfo.addActionListener((ActionEvent e) -> {
                
                // Get input values
                String month = (String)monthSelection.getSelectedItem();
                int day = (Integer)birthdayDay.getValue();
                String phoneNumber = (String)phoneNumberField.getValue();
                if(phoneNumber == null){
                    checkInFrame.dispose();
                    WelcomePage.show();
                } else {
                    String birthday = convertBirthday(month, day);
                    // Check for admin log-in
                    boolean isAdmin = checkForAdmin(phoneNumber, birthday);
                    checkInFrame.dispose();
                    if(isAdmin){
                        MainProgramPage.show();
                    }else{
                        Handlers.checkIn(phoneNumber, birthday);
                        WelcomePage.show();
                    }
                }
                
            });

        checkInFrame.add(phoneNumberRequest);
        checkInFrame.add(phoneNumberField);
        checkInFrame.add(birthdayRequest);
        checkInFrame.add(monthSelection);
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
        
        Boolean isAdmin = (birthday.equals("00/00") && 
                phoneNumber.equals("(000)000-0000"));
        return isAdmin;
    }
    
    //**************************************************************************
    
    private static String convertBirthday(String month, int day){
        String birthday;
        
        switch (month) {
            case "January":  
                birthday = "01";
                break;
            case "February":  
                birthday = "02";
                break;
            case "March":  
                birthday = "03";
                break;
            case "April":  
                birthday = "04";
                break;
            case "May":  
                birthday = "05";
                break;
            case "June":
                birthday = "06";
                break;
            case "July":
                birthday = "07";
                break;
            case "August":
                birthday = "08";
                break;
            case "September":
                birthday = "09";
                break;
            case "October":
                birthday = "10";
                break;
            case "November":
                birthday = "11";
                break;
            case "December":
                birthday = "12";
                break;
            default: 
                return "00/00";
        }
        
        if(day < 10){
            birthday += "/0" + day;
        }else{
            birthday += "/" + day;
        }
        
        return birthday;
    } // End private Static convertBirthday

} // End public class CheckInPage
