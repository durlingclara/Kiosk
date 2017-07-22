/*******************************************************************************
 * CheckInMessagePage.java
 * Clara L. Durling
 * 
 * and open the template in the editor.
 ******************************************************************************/
package kioskGUIs;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;



/**
 *
 * @author Clara L. Durling
 */
public class CheckInMessagePage {
    
    /**
     *
     * @param message - Message to display
     * @param birthday - Whether or not it's their birthday
     */
    public static void showMessage(String message, Boolean birthday){
        JFrame messageFrame = new JFrame("Check-in Successful");
        messageFrame.setBounds(300, 200, 500, 250);
        
        JTextArea messageDisplay = new JTextArea();
        messageDisplay.setBounds(310, 230, 480, 15);
        messageDisplay.append(message);
        
        JButton next = new JButton("Next");
        
        if(birthday){
            JTextArea birthdayDisplay = new JTextArea();
            birthdayDisplay.append("Happy Birthday! You get your buffet for free!");
            birthdayDisplay.append("Go to Redeem Rewards to redeem your birthday buffet!");
            birthdayDisplay.setBounds(310, 380, 200, 35);
            messageFrame.add(birthdayDisplay);
        }
        
        JButton mainMenu = new JButton("Main Menu");
        mainMenu.setBounds(700, 250, 50, 30);
        mainMenu.addActionListener((ActionEvent e) -> {
                messageFrame.dispose();
                WelcomePage.show();
            });
        
        messageFrame.add(next);
        messageFrame.add(mainMenu);
        messageFrame.add(messageDisplay);
        
        messageFrame.setLayout(null);
        messageFrame.setVisible(true);
    }
    
}
