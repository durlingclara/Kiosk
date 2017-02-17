/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kioskGUIs;


import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.text.MaskFormatter;

public class CheckInPage{

  public static void show() {

    JFrame f = new JFrame("Check-in");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(250, 250);
    f.setLocation(300,200);
    
    JTextArea textArea = new JTextArea();
    textArea.setBounds(5, 5, 250, 20);
    textArea.append("Please enter your 10-digit phone number:");
    
    final JFormattedTextField phoneNumberField = new JFormattedTextField(createFormatter("##########"));
    phoneNumberField.setBounds(5, 25, 85, 25);
    
    f.add(textArea);
    f.add(phoneNumberField);
    
    f.setLayout(null);
    f.setVisible(true);

  }
  
  protected static MaskFormatter createFormatter(String s) {
    MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
        return formatter;
    }

}