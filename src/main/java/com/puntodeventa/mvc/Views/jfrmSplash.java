package com.puntodeventa.mvc.Views;

import com.puntodeventa.global.SingleInstanceManager.ApplicationInstanceListener;
import com.puntodeventa.global.SingleInstanceManager.ApplicationInstanceManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.puntodeventa.global.Util.LogHelper;
import com.puntodeventa.global.Util.ParamHelper;
import com.puntodeventa.settings.Init;
import java.awt.Image;
import java.awt.Toolkit;

/**
 * @author JORGE EDUARDO
 */
public class jfrmSplash extends javax.swing.JFrame {

    public jfrmSplash() {
        initComponents();
        setLocationRelativeTo(null);
        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                e.consume();
            }

            @Override
            public void keyTyped(KeyEvent e) {
                e.consume();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                e.consume();
            }
        });
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("images/ico.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));
        setIconImage(getIconImage());
        setUndecorated(true);

        jLabel1.setBackground(new java.awt.Color(255, 255, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/splash.png"))); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        
        if (!ApplicationInstanceManager.registerInstance()) {
            System.exit(0);
        }
        ApplicationInstanceManager.setApplicationInstanceListener(new ApplicationInstanceListener() {
            @Override
            public void newInstanceCreated() {
                System.out.println("New instance detected...");
            }
        });

        //This method initializes all the system configurations. (Look and feel, events at exit time, etc)
        Init.onInit();

        LogHelper objLog = new LogHelper("jfrmSplash");
        jfrmSplash splash = new jfrmSplash();
        splash.setVisible(true);
        try {
            Thread.sleep(Integer.parseInt(ParamHelper.getParam("jfrmSplashTime").toString()));
        } catch (InterruptedException ex) {
            objLog.Log(ex.getMessage());
        }
        splash.dispose();

        jfrmLogin jfrmLogin = new jfrmLogin();
        jfrmLogin.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}