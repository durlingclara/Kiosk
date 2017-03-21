/*******************************************************************************
 * Redeem.java
 * Clara Durling
 * 
 * This class holds the first frame for the Redeem Rewards pathway.
 ******************************************************************************/
package kioskGUIs;

import handlers.Handlers;
import handlers.Member;
import handlers.Rewards;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Clara Durling
 */
public class Redeem {
    public static void show(){
        JFrame redeemLogIn = new JFrame("Redeem Rewards");
        redeemLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        redeemLogIn.setSize(250, 250);
        redeemLogIn.setLocation(300,200);
    
        // TODO: change to JLabel
        JTextArea textArea1 = new JTextArea();
        textArea1.setBounds(5, 5, 250, 20);
        textArea1.append("Please enter your 10-digit phone number:");
    
        
        final JFormattedTextField phoneNumberField;
        phoneNumberField = new JFormattedTextField(createFormatter("(###)###-####"));
        phoneNumberField.setBounds(5, 25, 85, 25);
        
        JButton getRewards = new JButton("Enter");
        getRewards.setBounds(5, 50, 85, 25);
        
        getRewards.addActionListener((ActionEvent e) -> {
            
            // Get phone number input:
            String phoneNumber = (String)phoneNumberField.getValue();
            
            // Get the member object that has this phoneNumber value
            Member member = Handlers.getMember(phoneNumber);
            redeemLogIn.dispose();
            Rewards.redeem(member);
        });
        
        
        redeemLogIn.add(textArea1);
        redeemLogIn.add(phoneNumberField);
        redeemLogIn.add(getRewards);
        
        
        redeemLogIn.setLayout(null);
        redeemLogIn.setVisible(true);
    }
    
    
    // I have no idea how or why this method works the way it does; I just got
    // it from the tutorial on Oracle's website
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
