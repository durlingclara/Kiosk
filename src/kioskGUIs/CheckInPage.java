/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kioskGUIs;


import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
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
    
    JTextArea textArea1 = new JTextArea();
    textArea1.setBounds(5, 5, 250, 20);
    textArea1.append("Please enter your 10-digit phone number:");
    
    final JFormattedTextField phoneNumberField = new JFormattedTextField(createFormatter("##########"));
    phoneNumberField.setBounds(5, 25, 85, 25);
    
    JTextArea textArea2 = new JTextArea();
    textArea2.setBounds(5, 50, 250, 20);
    textArea2.append("Please enter your birthday (mm/dd)");
    
    final JFormattedTextField birthdayField = new JFormattedTextField(createFormatter("##/##"));
    birthdayField.setBounds(5, 75, 85, 25);
    
    JButton submitInfo = new JButton("Enter");
        submitInfo.setMnemonic(KeyEvent.VK_S);
        submitInfo.setBounds(50, 100, 100, 25);
        submitInfo.addActionListener((ActionEvent e) -> {
            //CheckInPage.show();
        });
    
    f.add(textArea1);
    f.add(phoneNumberField);
    f.add(textArea2);
    f.add(birthdayField);
    f.add(submitInfo);
    
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