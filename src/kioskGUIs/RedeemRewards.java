/*******************************************************************************
 * ShowRewards.java
 * Clara L. Durling
 * 
 * This class displays the Rewards a customer has earned.
 ******************************************************************************/
package kioskGUIs;

import handlers.Member;
import handlers.Reward;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Clara L. Durling
 */
public abstract class RedeemRewards {

    /**
     *
     * @param member - the person trying to redeem a reward
     */
    public static void show(Member member) {
        JFrame rewardFrame = new JFrame("Redeem a Reward");
        int ySize = 50;
        rewardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel mainPanel = (JPanel) rewardFrame.getContentPane();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        if (member == null) {
            JLabel notSignedUp = new JLabel("Please sign up first.");
            ySize += 90;
            mainPanel.add(notSignedUp);    
        } else {
            List<Reward> rewards = member.getRewards();
            for (int i = 0; i < rewards.size()-1; i++) {
                Reward reward = rewards.get(i);
                JPanel rewardPane = new RewardPane(reward, rewardFrame, member);
                mainPanel.add(rewardPane);
                ySize += 90;
            }
            
            if (member.hasRewards() == false) {
                JLabel noReward = new JLabel("You have no rewards to redeem.");
                ySize += 90;
                mainPanel.add(noReward);
            }
        } // End if(member == null), else
        
        JButton mainMenu = new JButton("Main Menu");
        mainMenu.addActionListener((ActionEvent e) -> {
            rewardFrame.dispose();
            WelcomePage.show();
        });

        mainPanel.add(mainMenu);
        
        rewardFrame.setBounds(300, 200, 400, ySize);
        rewardFrame.setVisible(true);
    }

}
