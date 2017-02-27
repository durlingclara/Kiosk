/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kioskGUIs;

import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import handlers.Handlers;

/**
 *
 * @author durlicla000
 */
public class MainProgramPage {
    public static void show() {
        JFrame runKiosk = new JFrame("PPC Kiosk Runner");
        runKiosk.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        runKiosk.setSize(500, 300);
        runKiosk.setLocation(0, 0);
        
        JButton startKiosk = new JButton("Start-up Kiosk Presentation");
        startKiosk.setMnemonic(KeyEvent.VK_S);
        startKiosk.setBounds(50, 60, 195, 50);
        startKiosk.addActionListener(e -> {
            WelcomePage.show();
        });
        
        JButton getData = new JButton("Get sign-up information"); 
        getData.setMnemonic(KeyEvent.VK_G);
        getData.setBounds(50, 110, 195, 50);
        getData.addActionListener(e -> {
            runKiosk.dispose();
            System.out.println(Handlers.getData());
        });
        
        runKiosk.add(startKiosk);
        runKiosk.add(getData);
        
        runKiosk.setLayout(null);
        runKiosk.setVisible(true);
    }
}
