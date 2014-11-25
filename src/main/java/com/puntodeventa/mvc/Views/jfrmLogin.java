package com.puntodeventa.mvc.Views;

import com.puntodeventa.global.Entity.Sesion;
import com.puntodeventa.global.Util.LogHelper;
import com.puntodeventa.global.Util.TagHelper;
import com.puntodeventa.mvc.Controller.UsuarioLogic;
import com.puntodeventa.mvc.Controller.SesionLogic;
import com.puntodeventa.global.Entity.Usuario;
import com.puntodeventa.global.Util.Util;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author JORGE EDUARDO
 */
public class jfrmLogin extends javax.swing.JFrame {

    private LogHelper objLog = new LogHelper("jfrmSplash");
    private UsuarioLogic usrLogic = new UsuarioLogic();
    private SesionLogic sesionLogic = new SesionLogic();
    private Usuario usr;

    public jfrmLogin() {
        initComponents();
        configureControls();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("images/ico.png"));
        return retValue;
    }

    private void configureControls() {
        this.setLocationRelativeTo(null);
        //this.jtxtUsuario.setMaximumSize(Integer.parseInt(ParamHelper.getParam("jfrmLogin.jtxtUsuario").toString()));
        //this.jtxtContrasena.setDocument(new TextLimiter(Integer.parseInt(ParamHelper.getParam("jfrmLogin.jtxtContrasena").toString())));
    }

    private void showClosingWarning() {
        int op = JOptionPane.showConfirmDialog(rootPane, TagHelper.getTag("jfrmLogin.exitQuest"), TagHelper.getTag("jfrmLogin.exitDialogTitle"), 2);
        if (op == 0) {
            System.exit(0);
        }
    }

    private void nextStep(Usuario usr) {
        Util.serializeUser(usr);

        ArrayList<Sesion> sessions = sesionLogic.getPendingSessions(usr);
        if (sessions != null && sessions.size() > 0) {
            Util.serializeSession(sessions.get(0));
            jfrmVentaSessionPending sp = new jfrmVentaSessionPending(null, true);
            sp.setVisible(true);
        } else {
            sesionLogic.startSesion(usr);
            jfrmVenta jfrmVenta = new jfrmVenta();
            jfrmVenta.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblUsuario = new javax.swing.JLabel();
        jlblContrasena = new javax.swing.JLabel();
        jtxtUsuario = new javax.swing.JTextField();
        jBtnEntrar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtxtContrasena = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jlblUsuario.setText("Usuario:");
        jlblUsuario.setName("jlblUsuario"); // NOI18N

        jlblContrasena.setText("Contraseña:");
        jlblContrasena.setName("jlblContrasena"); // NOI18N

        jtxtUsuario.setToolTipText("Escriba su nombre de usuario"); // NOI18N
        jtxtUsuario.setName("jtxtUsuario"); // NOI18N
        jtxtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtUsuarioFocusGained(evt);
            }
        });
        jtxtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtUsuarioKeyTyped(evt);
            }
        });

        jBtnEntrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconDone.png"))); // NOI18N
        jBtnEntrar.setText("Entrar");
        jBtnEntrar.setMaximumSize(new java.awt.Dimension(113, 50));
        jBtnEntrar.setMinimumSize(new java.awt.Dimension(185, 39));
        jBtnEntrar.setName("jBtnEntrar"); // NOI18N
        jBtnEntrar.setPreferredSize(new java.awt.Dimension(185, 39));
        jBtnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEntrarActionPerformed(evt);
            }
        });

        jBtnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconCritical.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.setMaximumSize(new java.awt.Dimension(113, 50));
        jBtnCancelar.setMinimumSize(new java.awt.Dimension(185, 39));
        jBtnCancelar.setName("jBtnCancelar"); // NOI18N
        jBtnCancelar.setPreferredSize(new java.awt.Dimension(185, 39));
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Inicio de Sesión");
        jLabel1.setName("jLabel1"); // NOI18N

        jtxtContrasena.setToolTipText("Escriba su contraseña");
        jtxtContrasena.setName("jtxtContrasena"); // NOI18N
        jtxtContrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtContrasenaFocusGained(evt);
            }
        });
        jtxtContrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtContrasenaKeyTyped(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ingresar.png"))); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlblUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblContrasena, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtContrasena, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtUsuario)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblContrasena))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEntrarActionPerformed
        if (this.jtxtUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, TagHelper.getTag("jfrmLogin.userEmpty"));
            jtxtUsuario.requestFocus();
        } else if (this.jtxtContrasena.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, TagHelper.getTag("jfrmLogin.pwdEmpty"));
            this.jtxtContrasena.requestFocus();
        } else {
            try {
                String user = this.jtxtUsuario.getText();
                String pwd = this.jtxtContrasena.getText();

                usr = usrLogic.logonUsuario(user, pwd);

                if (usr != null) {
                    if (usr.getBloqueo() == 1) {
                        JOptionPane.showMessageDialog(null, TagHelper.getTag("jfrmLogin.usrBlocked"));
                        this.jtxtUsuario.requestFocus();
                    } else {
                        dispose();
                        nextStep(usr);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, TagHelper.getTag("jfrmLogin.notExistsUsr"));
                    this.jtxtUsuario.requestFocus();
                }
            } catch (Exception ex) {
                objLog.Log(ex.getMessage());
            }
        }
}//GEN-LAST:event_jBtnEntrarActionPerformed

    private void jtxtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtUsuarioFocusGained
        jtxtUsuario.selectAll();
    }//GEN-LAST:event_jtxtUsuarioFocusGained

    private void jtxtContrasenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtContrasenaFocusGained
        jtxtContrasena.selectAll();
    }//GEN-LAST:event_jtxtContrasenaFocusGained

    private void jtxtContrasenaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtContrasenaKeyTyped
        switch (evt.getKeyChar()) {
            case KeyEvent.VK_ENTER:
                this.jBtnEntrar.doClick();
                break;
        }
    }//GEN-LAST:event_jtxtContrasenaKeyTyped

    private void jtxtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtUsuarioKeyTyped
        switch (evt.getKeyChar()) {
            case KeyEvent.VK_ENTER:
                if (this.jtxtUsuario.getText().length() > 0) {
                    this.jtxtContrasena.requestFocus();
                }
                break;
        }
    }//GEN-LAST:event_jtxtUsuarioKeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        showClosingWarning();
    }//GEN-LAST:event_formWindowClosing

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        showClosingWarning();
    }//GEN-LAST:event_jBtnCancelarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jlblContrasena;
    private javax.swing.JLabel jlblUsuario;
    private javax.swing.JPasswordField jtxtContrasena;
    private javax.swing.JTextField jtxtUsuario;
    // End of variables declaration//GEN-END:variables
}