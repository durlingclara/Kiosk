/*******************************************************************************
 * SendTexts.java
 * Clara Durling
 * 
 * and open the template in the editor.
 ******************************************************************************/
package kioskGUIs;

import javax.swing.JFrame;

/**
 *
 * @author Clara Durling
 */
public class SendTexts {
    public static void show(){
        JFrame textMaker = new JFrame("Set up Text");
        textMaker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textMaker.setBounds(300, 200, 400, 400);
        
        textMaker.setLayout(null);
        textMaker.setVisible(true);
    }
}
