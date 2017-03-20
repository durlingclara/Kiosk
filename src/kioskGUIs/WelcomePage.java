/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kioskGUIs;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author durlicla000
 */
public class WelcomePage {

    public static void show() {

        JFrame Welcome = new JFrame("Pizza Pie Cafe Text Program");
        Welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Welcome.setBounds(300, 200, 500, 300);

        JLabel welcomeMessage = new JLabel("Welcome to Pizza Pie Cafe.");
        welcomeMessage.setBounds(5, 5, 250, 20);

        JButton checkIn = new JButton("Rewards Check-in");
        checkIn.setMnemonic(KeyEvent.VK_S);
        checkIn.setBounds(50, 60, 195, 50);
        checkIn.addActionListener((ActionEvent e) -> {
            Welcome.dispose();
            CheckInPage.show();
        });

        JButton redeem = new JButton("Redeem Rewards");
        redeem.setMnemonic(KeyEvent.VK_R);
        redeem.setBounds(50, 120, 195, 50);
        redeem.addActionListener((ActionEvent e) -> {
            Welcome.dispose();
            Redeem.show();
        });

        Welcome.add(welcomeMessage);
        Welcome.add(checkIn);
        Welcome.add(redeem);

        Welcome.setLayout(null);
        Welcome.setVisible(true);

    }

}
