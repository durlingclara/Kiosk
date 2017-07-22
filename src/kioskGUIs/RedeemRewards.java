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
import java.util.ArrayList;
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
        // Member is "null" if the person is not signed up
        
        // New JFrame
        JFrame rewardFrame = new JFrame("Redeem a Reward");
        
        // Beginning size of the frame in the y direction - gets changed
        int ySize = 80;
        rewardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set Layout of the main panel to a vertical box layout, add a margin
        JPanel mainPanel = (JPanel) rewardFrame.getContentPane();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        List<JPanel> rewardPanes = new ArrayList();
        if (member == null) {
            
            // If the person is not already signed up
            // (This part works perfectly fine)
            JLabel notSignedUp = new JLabel("Please sign up first.");
            ySize += 90;
            mainPanel.add(notSignedUp);    
        } else {
            // I hate everything that is a part of this else statement
            
            if(member.hasRewards()){
                
                // get the member's rewards
                List<Reward> rewards = member.getRewards();
                
                int i = 0;
                
                do{
                    // Get the i+1th reward
                    Reward reward = rewards.get(i);
                    System.out.println(reward);
                    // Make a rewardPane to display the reward
                    RewardPane rewardPane = new RewardPane(reward, rewardFrame, member);
                    // set the size of the reward pane
                    rewardPane.setSize(200,90);
                    // Add the rewardPane to the main Panel
                    rewardPanes.add(rewardPane);
                    i++;
                }while(i < rewards.size() - 1);
                
            }else{
                
                // If the member has no rewards
                // (This part also works)
                JLabel noReward = new JLabel("You have no rewards to redeem.");
                ySize += 90;
                mainPanel.add(noReward);
            } // End if(member.hasRewards()), else
   
        } // End if(member == null), else
        
        // Button to return to the main menu
        JButton mainMenu = new JButton("Main Menu");
        mainMenu.addActionListener((ActionEvent e) -> {
            rewardFrame.dispose();
            WelcomePage.show();
        });
        
        for(JPanel pane : rewardPanes){
            mainPanel.add(pane);
            ySize += 90;
        }

        mainPanel.add(mainMenu);
        
        rewardFrame.setBounds(300, 200, 400, ySize);
        rewardFrame.setVisible(true);
    }

}