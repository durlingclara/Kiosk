/*******************************************************************************
 * MainProgramPage.java
 * Clara L. Durling
 * 
 * This frame should only be accessible to administrators.
 ******************************************************************************/
package kioskGUIs;

import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import handlers.Handlers;
import javax.swing.JOptionPane;

/**
 *
 * @author Clara L. Durling
 */
public class MainProgramPage {
    
    /**
     *
     */
    public static void show() {
        /*TODO
        * Make it look nicer
         */
        JFrame runKiosk = new JFrame("PPC Kiosk Runner");
        runKiosk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        runKiosk.setBounds(300, 200, 500, 300);
        
        JButton startKiosk = new JButton("Start-up Kiosk Presentation");
            // Keyboard shortcut: Alt+S
            startKiosk.setMnemonic(KeyEvent.VK_S);
            startKiosk.setBounds(50, 60, 195, 50);
        
            // Action performed when startKiosk button is clicked
            startKiosk.addActionListener(e -> {
                JOptionPane.showMessageDialog(runKiosk,
                    "To return, check-in with all zeroes for the phone number "
                            + "and 0/30 as the birthday",
                    "Closing Administrative Page",
                    JOptionPane.INFORMATION_MESSAGE);
                runKiosk.dispose();
                WelcomePage.show();  // Loads the Welcome page for the kiosk
            });
        
        JButton getData = new JButton("Get sign-up information");
            // Keyboard shortcut: Alt+G
            getData.setMnemonic(KeyEvent.VK_G); 
            getData.setBounds(50, 110, 195, 50);
            // Action performed when getData button is clicked
            getData.addActionListener(e -> {
                // Print out the data stored in Handlers.java:
                System.out.println(Handlers.getData());
            });
        
        JButton sendText = new JButton("Send Text to members");
            sendText.setMnemonic(KeyEvent.VK_T);
            sendText.setBounds(50, 160, 195, 50);
            sendText.addActionListener(e -> {
                runKiosk.dispose();
                SendTexts.show();
            });

        runKiosk.add(sendText);
        runKiosk.add(startKiosk);
        runKiosk.add(getData);
        
        runKiosk.setLayout(null);
        runKiosk.setVisible(true);
        
    } // End method show()
    
} // End class MainProgramPage
