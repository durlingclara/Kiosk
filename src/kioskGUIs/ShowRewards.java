/*******************************************************************************
 * ShowRewards.java
 * Clara L. Durling
 * 
 * This class displays the Rewards a customer has earned.
 ******************************************************************************/
package kioskGUIs;

import handlers.Member;
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
public class ShowRewards {

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
            rewardFrame.dispose();
            WelcomePage.show();
        } else {

            int freeBuffets = member.getFreeBuffets();
            for (int i = 0; i < freeBuffets; i++) {
                String reward = "Buffet";
                JPanel rewardPane = new RewardPane(reward, rewardFrame, member);
                mainPanel.add(rewardPane);
                ySize += 90;
            }

            int freeDrinks = member.getFreeDrinks();
            for (int i = 0; i < freeDrinks; i++) {
                String reward = "Drink";
                JPanel rewardPane = new RewardPane(reward, rewardFrame, member);
                mainPanel.add(rewardPane);
                ySize += 90;
            }

            if (freeBuffets == 0 && freeDrinks == 0) {
                JLabel noReward = new JLabel("You have no rewards to redeem.");
                ySize += 90;
                mainPanel.add(noReward);
            }

            JButton mainMenu = new JButton("Main Menu");
            mainMenu.addActionListener((ActionEvent e) -> {
                rewardFrame.dispose();
                WelcomePage.show();
            });

            mainPanel.add(mainMenu);
        }

        rewardFrame.setBounds(300, 200, 400, ySize);
        rewardFrame.setVisible(true);
    }

}
