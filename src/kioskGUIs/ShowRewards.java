/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kioskGUIs;

import handlers.Member;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author durlicla000
 */
public class ShowRewards {
    
    public static void show(Member member){
        JFrame rewardFrame = new JFrame("Redeem a Reward");
        rewardFrame.setBounds(300, 200, 400, 300);
        rewardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = (JPanel)rewardFrame.getContentPane();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        int freeBuffets = member.getFreeBuffets();
        for(int i = 0; i < freeBuffets; i++){
            String reward = "Buffet";
            JPanel rewardPane = new JPanel();
                rewardPane.setLayout(new BoxLayout(rewardPane, BoxLayout.X_AXIS));
                rewardPane.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       
                JTextArea rewardExplanation = new JTextArea();
                rewardExplanation.append(reward);
                rewardPane.add(rewardExplanation);
       
                JButton redeem = new JButton("Redeem");
                redeem.addActionListener((ActionEvent e) -> {
                    member.redeemBuffet();
                    rewardFrame.dispose();
                    WelcomePage.show();
                });
            mainPanel.add(rewardPane);
        }
        
        int freeDrinks = member.getFreeDrinks();
        for(int i = 0; i < freeDrinks; i++){
            String reward = "Buffet";
            JPanel rewardPane = new JPanel();
                rewardPane.setLayout(new BoxLayout(rewardPane, BoxLayout.X_AXIS));
                rewardPane.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       
                JTextArea rewardExplanation = new JTextArea();
                rewardExplanation.append(reward);
                rewardPane.add(rewardExplanation);
       
                JButton redeem = new JButton("Redeem");
                redeem.addActionListener((ActionEvent e) -> {
                    member.redeemDrink();
                    rewardFrame.dispose();
                    WelcomePage.show();
                });
            mainPanel.add(rewardPane); 
        }
        
        if(freeBuffets == 0 && freeDrinks == 0){
            JTextArea noReward = new JTextArea();
            noReward.append("You have no rewards to redeem.");
            mainPanel.add(noReward);
        }
        
        JButton mainMenu = new JButton("Main Menu");
        mainMenu.addActionListener((ActionEvent e) -> {
                rewardFrame.dispose();
                WelcomePage.show();
            });
        mainPanel.add(mainMenu);
        
        
        rewardFrame.setVisible(true);
    }
    
}
