/*******************************************************************************
 * Redeem.java
 * Clara L. Durling
 * 
 * This class holds the first frame for the Redeem Rewards pathway.
 ******************************************************************************/
package kioskGUIs;

import handlers.Handlers;
import handlers.Member;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Clara L. Durling
 */
public class Redeem {

    /**
     *
     */
    public static void show(){
        JFrame redeemLogIn = new JFrame("Redeem Rewards");
        redeemLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        redeemLogIn.setBounds(300, 200, 300, 250);
    
        final JLabel pNumberPrompt = 
                new JLabel("Please enter your 10-digit phone number:");
        pNumberPrompt.setBounds(5, 5, 300, 20);
    
        final JFormattedTextField phoneNumberField;
        phoneNumberField = 
                new JFormattedTextField(createFormatter("(###)###-####"));
        phoneNumberField.setBounds(5, 30, 85, 25);
        
        JButton getRewards = new JButton("Enter");
        getRewards.setBounds(98, 60, 85, 25);
        getRewards.setMnemonic(KeyEvent.VK_ENTER);
        
        getRewards.addActionListener(e -> {
            // Get phone number input:
            String phoneNumber = (String)phoneNumberField.getValue();
            if(phoneNumber == null){
                redeemLogIn.dispose();
                WelcomePage.show();
            } else {
               // Get the member object that has this phoneNumber value
                Member member = Handlers.getMember(phoneNumber);
                redeemLogIn.dispose();
                ShowRewards.show(member); 
            }
        });
        
        
        redeemLogIn.add(pNumberPrompt);
        redeemLogIn.add(phoneNumberField);
        redeemLogIn.add(getRewards);
        
        redeemLogIn.setLayout(null);
        redeemLogIn.setVisible(true);
    }
    
    //**************************************************************************

    /**
     *
     * @param s - the format
     * @return MaskFormatter - the ability to force the format
     */
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
