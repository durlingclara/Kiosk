/*******************************************************************************
 * MainProgramPage.java
 * Clara Durling
 * 
 * This class holds a frame with two buttons. One runs the kiosk presentation.
 * The other button prints out basic information about all of the members.
 * After leaving this frame, it can be returned to by checking in with all
 * zeroes for a phone number.
 ******************************************************************************/
package kioskGUIs;

import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import handlers.Handlers;

/**
 *
 * @author Clara Durling
 */
public class MainProgramPage {
    
    public static void show() {
        JFrame runKiosk = new JFrame("PPC Kiosk Runner");
        runKiosk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        runKiosk.setSize(500, 300);
        runKiosk.setLocation(0, 0);
        
        
        JButton startKiosk = new JButton("Start-up Kiosk Presentation");
        // Keyboard shortcut: Alt+S
        startKiosk.setMnemonic(KeyEvent.VK_S);
        startKiosk.setBounds(50, 60, 195, 50);
        
        // Action performed when startKiosk button is clicked
        startKiosk.addActionListener(e -> {
            runKiosk.dispose();
            WelcomePage.show();  // Loads the Welcome page for the kiosk
        });
        
        
        JButton getData = new JButton("Get sign-up information");
        // Keyboard shortcut: Alt+G
        getData.setMnemonic(KeyEvent.VK_G); 
        getData.setBounds(50, 110, 195, 50);
        
        // Action performed when getData button is clicked
        getData.addActionListener(e -> {
            runKiosk.dispose();
            
            // Print out the data stored in Handlers.java:
            System.out.println(Handlers.getData());
        });
        
        
        runKiosk.add(startKiosk);
        runKiosk.add(getData);
        
        runKiosk.setLayout(null);
        runKiosk.setVisible(true);
        
    } // End method show()
    
} // End class MainProgramPage
