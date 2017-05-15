/*******************************************************************************
 * RewardPane.java
 * Clara L. Durling
 * 
 * This class is a JPanel that displays the rewards the customer has earned and 
 * allows the customer to redeem their rewards.
 ******************************************************************************/
package kioskGUIs;


import handlers.Member;
import handlers.Reward;
import java.awt.Color;
import java.awt.event.ActionEvent;
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

public class RewardPane extends JPanel{
    
    /**
     *
     * @param reward - either a drink or a buffet
     * @param rewardFrame - the JFrame containing the JPanel
     * @param member - the person trying to redeem a reward
     */
    public RewardPane(Reward reward, JFrame rewardFrame, Member member){
        JPanel rewardPane = new JPanel();
        rewardPane.setLayout(new BoxLayout(rewardPane, BoxLayout.X_AXIS));
        rewardPane.setSize(200,90);
        
        // Add a thin black border around each reward panel
        rewardPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
       
        JLabel rewardLabel = new JLabel("  " + reward.getDeal() + "    ");
        JLabel rewardDate = new JLabel(" " + reward.getDate() + " ");
       
        JButton redeem = new JButton("Redeem");
        redeem.addActionListener((ActionEvent e) -> {
            member.redeemReward(reward);
            rewardFrame.dispose();
            WelcomePage.show(); // Return to customer starter page
        });
        
        rewardPane.add(rewardLabel);
        rewardPane.add(rewardDate);
        rewardPane.add(redeem);
        rewardPane.setVisible(true);
    }
    
    
}
