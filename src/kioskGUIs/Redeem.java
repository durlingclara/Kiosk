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
    
        JTextArea textArea1 = new JTextArea();
        textArea1.setBounds(5, 5, 250, 20);
        textArea1.append("Please enter your 10-digit phone number:");
    
        final JFormattedTextField phoneNumberField = new JFormattedTextField(createFormatter("(###)###-####"));
        phoneNumberField.setBounds(5, 25, 85, 25);
        
        JButton getRewards = new JButton("Enter");
        getRewards.setBounds(5, 50, 85, 25);
        getRewards.addActionListener((ActionEvent e) -> {
            String phoneNumber = (String)phoneNumberField.getValue();
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
