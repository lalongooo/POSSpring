/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.mvc.Views;

import com.puntodeventa.global.Entity.Sesion;
import com.puntodeventa.global.Util.TagHelper;
import com.puntodeventa.global.Util.Util;
import com.puntodeventa.global.Util.ValidacionForms;
import com.puntodeventa.mvc.Controller.CorteLogic;
import com.puntodeventa.mvc.Controller.SesionLogic;
import com.puntodeventa.mvc.Controller.StepsController;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * @author USER
 */
public class jfrmVentaSessionPending extends javax.swing.JDialog {

    private ValidacionForms valid = new ValidacionForms();
    private CorteLogic crtLgc = new CorteLogic();

    public jfrmVentaSessionPending(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        configureControls();
    }

    private void configureControls() {
        this.setTags();
        this.setLocationRelativeTo(null);
        this.initEvents();
    }

    private void setTags() {

        SesionLogic ssnLgc = new SesionLogic();
        ArrayList<Sesion> sesions = ssnLgc.getPendingSessions(Util.getCurrentUser());
        String dateFormated = Util.formatDate(sesions.get(0).getStartDate());

        this.jlblCutPendingTitle.setText(TagHelper.getTag("jfrmVentaSessionPending.jlblCutPendingTitle"));
        this.jlblCutPendingMsg1.setText(TagHelper.getTag("jfrmVentaSessionPending.jlblCutPendingMsg1"));
        this.jlblCutPendingMsg2.setText(TagHelper.getTag("jfrmVentaSessionPending.jlblCutPendingMsg2").replace("#", dateFormated));
        this.jlblCutPendingMsg3.setText(TagHelper.getTag("jfrmVentaSessionPending.jlblCutPendingMsg3"));
        this.jlblInitialCashTitle.setText(TagHelper.getTag("jfrmVentaSessionPending.jlblInitialCashTitle"));
        this.jlblCashTitle.setText(TagHelper.getTag("jfrmVentaSessionPending.jlblCashTitle"));
        this.jBtnCut.setText(TagHelper.getTag("jfrmVentaSessionPending.jBtnCut"));
    }

    private void initEvents() {

        java.awt.event.FocusAdapter fa = new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                javax.swing.JTextField b = (javax.swing.JTextField) evt.getSource();
                b.selectAll();
            }
        };
        jtxtInitialCash.addFocusListener(fa);
        jtxtCash.addFocusListener(fa);

        java.awt.event.KeyAdapter ka = new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    javax.swing.JTextField tf = (javax.swing.JTextField) e.getSource();
                    switch (tf.getName()) {
                        case "jtxtInitialCash":
                            jtxtCash.requestFocus();
                            break;
                        case "jtxtCash":
                            jBtnCut.doClick();
                            break;
                    }
                }
            }
        };
        this.jtxtCash.addKeyListener(ka);
        this.jtxtInitialCash.addKeyListener(ka);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                valid.msjWarn(TagHelper.getTag("jfrmVentaSessionPending.closingWarning"));
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblCutPendingTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jlblInitialCashTitle = new javax.swing.JLabel();
        jlblCashTitle = new javax.swing.JLabel();
        jtxtInitialCash = new javax.swing.JTextField();
        jtxtCash = new javax.swing.JTextField();
        jBtnCut = new javax.swing.JButton();
        jlblCutPendingMsg1 = new javax.swing.JLabel();
        jlblCutPendingMsg2 = new javax.swing.JLabel();
        jlblCutPendingMsg3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jlblCutPendingTitle.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jlblCutPendingTitle.setText("Corte de caja pendiente");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlblInitialCashTitle.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jlblInitialCashTitle.setText("Saldo inicial: $");

        jlblCashTitle.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jlblCashTitle.setText("Efectivo en caja: $");

        jtxtInitialCash.setName("jtxtInitialCash"); // NOI18N

        jtxtCash.setName("jtxtCash"); // NOI18N

        jBtnCut.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtnCut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconDone.png"))); // NOI18N
        jBtnCut.setText("Realizar corte");
        jBtnCut.setMaximumSize(new java.awt.Dimension(113, 50));
        jBtnCut.setMinimumSize(new java.awt.Dimension(185, 39));
        jBtnCut.setPreferredSize(new java.awt.Dimension(185, 39));
        jBtnCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCutActionPerformed(evt);
            }
        });

        jlblCutPendingMsg1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jlblCutPendingMsg1.setText("Tiene un corte de caja pendiente.");

        jlblCutPendingMsg2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jlblCutPendingMsg2.setText("Iniciaste sesión el día #.");

        jlblCutPendingMsg3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jlblCutPendingMsg3.setText("Es necesario realizar el corte para poder continuar con el proceso de Venta.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jlblInitialCashTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtInitialCash))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jlblCashTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtCash))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtnCut, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblCutPendingMsg1)
                            .addComponent(jlblCutPendingMsg2)
                            .addComponent(jlblCutPendingMsg3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblCutPendingMsg1)
                .addGap(18, 18, 18)
                .addComponent(jlblCutPendingMsg2)
                .addGap(18, 18, 18)
                .addComponent(jlblCutPendingMsg3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblInitialCashTitle)
                    .addComponent(jtxtInitialCash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblCashTitle)
                    .addComponent(jtxtCash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnCut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlblCutPendingTitle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblCutPendingTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCutActionPerformed
        String initialCash = this.jtxtInitialCash.getText();
        String cash = this.jtxtCash.getText();
        int flagMsg = 0;
        boolean a = false, b = false;

        //Validations for initialCash
        if (initialCash.length() > 0 && !Util.isValidCashValue(initialCash)) {
            valid.msjInfo(this, TagHelper.getTag("jfrmVentaMenuCorte.initialCashError"));
            this.jtxtInitialCash.requestFocus();
            flagMsg = 1;
        } else {
            a = true;
        }

        //Validations for cash
        if (cash.length() > 0 && Util.isValidCashValue(cash)) {
            b = true;
        } else {
            if (flagMsg == 0) {
                if (cash.length() == 0) {
                    valid.msjWarn(TagHelper.getTag("jfrmVentaMenuCorte.CashEmpty"));
                } else if (!Util.isValidCashValue(cash)) {
                    valid.msjWarn(TagHelper.getTag("jfrmVentaMenuCorte.CashError"));
                }
                this.jtxtCash.requestFocus();
            }
        }

        if (a && b) {
            String msg = TagHelper.getTag("jfrmVentaMenuCorte.ConfMsg").toString();
            msg = msg.replace("#", initialCash.length() > 0 ? initialCash : "0");
            msg = msg.replace("@", cash);

            int op = valid.msjOption(msg, TagHelper.getTag("jfrmVentaMenuCorte.ConfMsgTitle"));

            if (op == 0) {
                
                //End session pending
                SesionLogic ssnLgc = new SesionLogic();
                ssnLgc.endSesion();
                
                //Process cut pending
                double efvoInicial, efvoCaja;
                efvoInicial = initialCash.length() > 0 ? Double.valueOf(initialCash) : 0;
                efvoCaja = Double.valueOf(cash);
                crtLgc.processCut(efvoInicial, efvoCaja);
                dispose();
                
                //Start new session with the logged user and continue to the POS system.                
                ssnLgc.startSesion(Util.getCurrentUser());
                valid.msjInfo(null, TagHelper.getTag("jfrmVentaSessionPending.newSessionWarning"));
                StepsController.GoVenta();
            }
        }
    }//GEN-LAST:event_jBtnCutActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCut;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlblCashTitle;
    private javax.swing.JLabel jlblCutPendingMsg1;
    private javax.swing.JLabel jlblCutPendingMsg2;
    private javax.swing.JLabel jlblCutPendingMsg3;
    private javax.swing.JLabel jlblCutPendingTitle;
    private javax.swing.JLabel jlblInitialCashTitle;
    private javax.swing.JTextField jtxtCash;
    private javax.swing.JTextField jtxtInitialCash;
    // End of variables declaration//GEN-END:variables
}
