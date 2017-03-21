/*******************************************************************************
 * CheckInPage.java
 * Clara Durling
 * 
 * This class hold the frame fro checking-in or signing-up.
 ******************************************************************************/
package kioskGUIs;


import handlers.Handlers;
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
    
    
    JLabel phoneNumberRequest = new JLabel("Please enter your 10-digit phone number:");
    phoneNumberRequest.setBounds(5, 5, 250, 20);
    
    
    // What does making a JFormattedTextField final do?
    final JFormattedTextField phoneNumberField = new JFormattedTextField(createFormatter("(###)###-####"));
    phoneNumberField.setBounds(5, 25, 95, 25);
    
    // TODO: validate phoneNumber as a valid phoneNumber
    
    JLabel birthdayRequest = new JLabel("Please enter your birthday (mm/dd)");
    birthdayRequest.setBounds(5, 50, 250, 20);
    
    final JFormattedTextField birthdayField = new JFormattedTextField(createFormatter("##/##"));
    birthdayField.setBounds(5, 75, 85, 25);
    
    
    // Submit button
    JButton submitInfo = new JButton("Enter");
        submitInfo.setMnemonic(KeyEvent.VK_ENTER);
        submitInfo.setBounds(50, 100, 100, 25);
        submitInfo.addActionListener( e -> {
            String phoneNumber = (String)phoneNumberField.getValue();
            
            // If phoneNumber is 
            if(phoneNumber.equals("(000)000-0000")){
                checkInFrame.dispose();
                MainProgramPage.show();  
            }else{
                String birthday = (String)birthdayField.getValue();
            Handlers.CheckIn(phoneNumber, birthday);
            checkInFrame.dispose();
                WelcomePage.show();
            }
        });
    
    checkInFrame.add(phoneNumberRequest);
    checkInFrame.add(phoneNumberField);
    checkInFrame.add(birthdayRequest);
    checkInFrame.add(birthdayField);
    checkInFrame.add(submitInfo);
    
    // Why isn't null the default layout for a JFrame?
    checkInFrame.setLayout(null);
    checkInFrame.setVisible(true);

  }
  
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

}