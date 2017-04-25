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
public class RewardPane extends JPanel{
    
    public RewardPane(String reward, JFrame rewardFrame, Member member){
        JPanel rewardPane = new JPanel();
        rewardPane.setLayout(new BoxLayout(rewardPane, BoxLayout.X_AXIS));
        rewardPane.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       
        JTextArea rewardExplanation = new JTextArea();
        rewardExplanation.append(reward);
        rewardPane.add(rewardExplanation);
       
        JButton redeem = new JButton("Redeem");
        redeem.addActionListener((ActionEvent e) -> {
                if(reward.equals("buffet")){
                    member.redeemBuffet();
                }else{
                    member.redeemDrink();
                }
                rewardFrame.dispose();
                WelcomePage.show();
            });
       
       
    }
}
