/*******************************************************************************
 * RewardPane.java
 * Clara L. Durling
 * 
 * This class is a JPanel that displays the rewards the customer has earned and 
 * allows the customer to redeem their rewards.
 ******************************************************************************/
package kioskGUIs;


import handlers.Member;
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
    public RewardPane(String reward, JFrame rewardFrame, Member member){
        JPanel rewardPane = new JPanel();
        rewardPane.setLayout(new BoxLayout(rewardPane, BoxLayout.X_AXIS));
        
        // Add a thin black border around each reward panel
        rewardPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
       
        JLabel rewardExplanation = new JLabel("  " + reward + "    ");
       
        JButton redeem = new JButton("Redeem");
        redeem.addActionListener((ActionEvent e) -> {
            if(reward.equals("Buffet")){
                member.redeemBuffet(); // Record under the member object
            }else{                      // that the reward was redeemed.
                member.redeemDrink();
            }
            rewardFrame.dispose();
            WelcomePage.show(); // Return to customer starter page
        });
        
        rewardPane.add(rewardExplanation);
        rewardPane.add(redeem);
        rewardPane.setVisible(true);
    }
}
