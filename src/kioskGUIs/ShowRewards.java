/*******************************************************************************
 * ShowRewards.java
 * Clara L. Durling
 * 
 * This class displays the Rewards a customer has earned.
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
import javax.swing.JTextArea;

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
        int ySize = 20;
        rewardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = (JPanel) rewardFrame.getContentPane();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        if (member == null) {

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
                JPanel rewardPane = new JPanel();
                rewardPane.setLayout(new BoxLayout(rewardPane, BoxLayout.X_AXIS));
                rewardPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

                JLabel rewardExplanation = new JLabel(reward);
                rewardPane.add(rewardExplanation);

                JButton redeem = new JButton("Redeem");
                redeem.addActionListener((ActionEvent e) -> {
                    member.redeemDrink();
                    rewardFrame.dispose();
                    WelcomePage.show();
                });
                rewardPane.add(redeem);
                mainPanel.add(rewardPane);
                ySize += 90;
            }

            if (freeBuffets == 0 && freeDrinks == 0) {
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
        }

        rewardFrame.setBounds(300, 200, 400, ySize);
        rewardFrame.setVisible(true);
    }

}
