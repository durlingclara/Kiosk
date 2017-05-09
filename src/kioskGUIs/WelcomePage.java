/*******************************************************************************
 * WelcomePage.java
 * Clara L. Durling
 * 
 * This class holds the JFrame for the main customer page, or the "Welcome Page"
 ******************************************************************************/
package kioskGUIs;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Clara L. Durling
 */
public class WelcomePage {

    /**
     *
     */
    public static void show() {

        JFrame welcome = new JFrame("Pizza Pie Cafe Text Program");
        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcome.setBounds(300, 200, 500, 300);

        JLabel welcomeMessage = new JLabel("Welcome to Pizza Pie Cafe.");
        welcomeMessage.setBounds(5, 5, 250, 20);

        JButton checkIn = new JButton("Rewards Check-in");
        checkIn.setMnemonic(KeyEvent.VK_S);
        checkIn.setBounds(50, 60, 195, 50);
        checkIn.addActionListener((ActionEvent e) -> {
            welcome.dispose();
            CheckInPage.show();
        });

        JButton redeem = new JButton("Redeem Rewards");
        redeem.setMnemonic(KeyEvent.VK_R);
        redeem.setBounds(50, 120, 195, 50);
        redeem.addActionListener((ActionEvent e) -> {
            welcome.dispose();
            Redeem.show();
        });

        welcome.add(welcomeMessage);
        welcome.add(checkIn);
        welcome.add(redeem);

        welcome.setLayout(null);
        welcome.setVisible(true);

    }

}
