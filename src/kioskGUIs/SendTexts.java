/*******************************************************************************
 * SendTexts.java
 * Clara L. Durling
 * 
 * This class is for the GUI for 
 ******************************************************************************/
package kioskGUIs;

import javax.swing.JFrame;

/**
 *
 * @author Clara L. Durling
 */
public class SendTexts {

    /**
     * 
     */
    public static void show() {
        /* TODO:
         * Prompt for text
         * Make a text box with a limited number of characters
         * Make a send button
         *      Will be useless for now
         * Make a cancel button
         * Make a save button (low priority)
         */
        
        JFrame textMaker = new JFrame("Set up Text");
        textMaker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textMaker.setBounds(300, 200, 400, 400);
        
        textMaker.setLayout(null);
        textMaker.setVisible(true);
    }
}
