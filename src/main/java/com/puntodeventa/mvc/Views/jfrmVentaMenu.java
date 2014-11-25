package com.puntodeventa.mvc.Views;

import com.puntodeventa.global.Util.ParamHelper;
import com.puntodeventa.global.Util.TagHelper;
import com.puntodeventa.global.Util.ValidacionForms;
import com.puntodeventa.global.Util.Util;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/*
 * @author Jorge Eduardo Hernández
 */
public class jfrmVentaMenu extends javax.swing.JDialog {

    private jfrmVenta parent;
    ValidacionForms valid = new ValidacionForms();
    private String optionSelected = "";

    public jfrmVentaMenu(jfrmVenta parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        configureControls();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jpnlTitle = new javax.swing.JPanel();
        jlblSelectOptionTitle = new javax.swing.JLabel();
        jpnlHelp = new javax.swing.JPanel();
        jlblIcon = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaHelpText = new javax.swing.JTextArea();
        jBtnOk = new javax.swing.JButton();
        jBtnCancel = new javax.swing.JButton();
        jpnlVentaMenuOptions = new javax.swing.JPanel();
        jbtnCancelOrder = new javax.swing.JButton();
        jbtnCut = new javax.swing.JButton();
        jbtnCashCount = new javax.swing.JButton();
        jbtnPrintTicket = new javax.swing.JButton();
        jbtnPayWithCredit = new javax.swing.JButton();
        jbtnCredit = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jpnlTitle.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlblSelectOptionTitle.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jlblSelectOptionTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblSelectOptionTitle.setText("Seleccione una opción:");

        javax.swing.GroupLayout jpnlTitleLayout = new javax.swing.GroupLayout(jpnlTitle);
        jpnlTitle.setLayout(jpnlTitleLayout);
        jpnlTitleLayout.setHorizontalGroup(
            jpnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblSelectOptionTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnlTitleLayout.setVerticalGroup(
            jpnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlTitleLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlblSelectOptionTitle))
        );

        jpnlHelp.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpnlHelp.setFocusable(false);

        jlblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/help.png"))); // NOI18N

        jtaHelpText.setEditable(false);
        jtaHelpText.setBackground(new java.awt.Color(227, 227, 227));
        jtaHelpText.setColumns(20);
        jtaHelpText.setLineWrap(true);
        jtaHelpText.setRows(3);
        jtaHelpText.setWrapStyleWord(true);
        jtaHelpText.setAutoscrolls(false);
        jtaHelpText.setBorder(null);
        jtaHelpText.setFocusable(false);
        jScrollPane2.setViewportView(jtaHelpText);

        jBtnOk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconDone.png"))); // NOI18N
        jBtnOk.setText("Aceptar");
        jBtnOk.setMaximumSize(new java.awt.Dimension(113, 50));
        jBtnOk.setMinimumSize(new java.awt.Dimension(185, 39));
        jBtnOk.setPreferredSize(new java.awt.Dimension(185, 39));
        jBtnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOkActionPerformed(evt);
            }
        });

        jBtnCancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconCritical.png"))); // NOI18N
        jBtnCancel.setText("Cancelar");
        jBtnCancel.setMaximumSize(new java.awt.Dimension(113, 50));
        jBtnCancel.setMinimumSize(new java.awt.Dimension(185, 39));
        jBtnCancel.setPreferredSize(new java.awt.Dimension(185, 39));
        jBtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlHelpLayout = new javax.swing.GroupLayout(jpnlHelp);
        jpnlHelp.setLayout(jpnlHelpLayout);
        jpnlHelpLayout.setHorizontalGroup(
            jpnlHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlHelpLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jlblIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlHelpLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jpnlHelpLayout.setVerticalGroup(
            jpnlHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlHelpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlHelpLayout.createSequentialGroup()
                        .addComponent(jlblIcon)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jpnlVentaMenuOptions.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbtnCancelOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.png"))); // NOI18N
        jbtnCancelOrder.setText("Cancelar venta");
        jbtnCancelOrder.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnCancelOrder.setName("jbtnCancelOrder"); // NOI18N

        jbtnCut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/modificar.png"))); // NOI18N
        jbtnCut.setText("Corte de caja");
        jbtnCut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnCut.setName("jbtnCut"); // NOI18N

        jbtnCashCount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arqueo.png"))); // NOI18N
        jbtnCashCount.setText("Arqueo de caja");
        jbtnCashCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnCashCount.setName("jbtnCashCount"); // NOI18N

        jbtnPrintTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/corteCaja.png"))); // NOI18N
        jbtnPrintTicket.setText("Imprimir ticket");
        jbtnPrintTicket.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnPrintTicket.setName("jbtnPrintTicket"); // NOI18N

        jbtnPayWithCredit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/paywith_credit.png"))); // NOI18N
        jbtnPayWithCredit.setText("Pagar a crédito");
        jbtnPayWithCredit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnPayWithCredit.setName("jbtnPayWithCredit"); // NOI18N

        jbtnCredit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/credito.png"))); // NOI18N
        jbtnCredit.setText("Crear crédito");
        jbtnCredit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnCredit.setName("jbtnCredit"); // NOI18N

        javax.swing.GroupLayout jpnlVentaMenuOptionsLayout = new javax.swing.GroupLayout(jpnlVentaMenuOptions);
        jpnlVentaMenuOptions.setLayout(jpnlVentaMenuOptionsLayout);
        jpnlVentaMenuOptionsLayout.setHorizontalGroup(
            jpnlVentaMenuOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlVentaMenuOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlVentaMenuOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnCut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnCashCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnPrintTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnPayWithCredit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnCredit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnCancelOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnlVentaMenuOptionsLayout.setVerticalGroup(
            jpnlVentaMenuOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlVentaMenuOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnCancelOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnCut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnCashCount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnPrintTicket)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnPayWithCredit)
                .addGap(7, 7, 7)
                .addComponent(jbtnCredit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnlTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpnlVentaMenuOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnlHelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpnlVentaMenuOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnlHelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOkActionPerformed
        int op;
        switch (this.optionSelected) {
            case "jbtnCancelOrder":
                op = valid.msjOption(TagHelper.getTag("jfrmVentaMenu.CancelOrderConfirmation"), TagHelper.getTag("jfrmVentaMenu.CancelOrderTitle"));
                if (op == 0) {
                    parent.restartControls();
                    this.jbtnCancelOrder.setEnabled(false);
                    this.setTags();
                }
                break;
            case "jbtnCut":
                if (parent.jtblVenta.getRowCount() > 0) {
                    valid.msjWarn(TagHelper.getTag("jfrmVentaMenu.CutCancelOrderMsg"));
                } else {
                    dispose();
                    jfrmVentaMenuCorte corte = new jfrmVentaMenuCorte(parent, true);
                    corte.setVisible(true);
                }
                break;
            case "jbtnCashCount":
                if (parent.jtblVenta.getRowCount() > 0) {
                    valid.msjWarn(TagHelper.getTag("jfrmVentaMenu.CutCancelOrderMsg"));
                } else {
                    dispose();
                    jfrmVentaMenuArqueo arqueo = new jfrmVentaMenuArqueo(parent, true);
                    arqueo.setVisible(true);
                }
                break;
            case "jbtnCredit":
                dispose();
                jfrmVentaMenuCreditForm creditForm = new jfrmVentaMenuCreditForm(parent, true);
                creditForm.setVisible(true);
                break;
            case "jbtnPayWithCredit":
                // Option in which we print two tickets. A simple credit.
                dispose();
                break;
            case "jbtnPrintTicket":
                dispose();
                jfrmVentaMenuPrintTicket pt = new jfrmVentaMenuPrintTicket(parent, true);
                pt.setVisible(true);
                break;

        }
    }//GEN-LAST:event_jBtnOkActionPerformed

    private void jBtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnCancelActionPerformed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }//GEN-LAST:event_formKeyTyped
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancel;
    private javax.swing.JButton jBtnOk;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbtnCancelOrder;
    private javax.swing.JButton jbtnCashCount;
    private javax.swing.JButton jbtnCredit;
    private javax.swing.JButton jbtnCut;
    private javax.swing.JButton jbtnPayWithCredit;
    private javax.swing.JButton jbtnPrintTicket;
    private javax.swing.JLabel jlblIcon;
    private javax.swing.JLabel jlblSelectOptionTitle;
    private javax.swing.JPanel jpnlHelp;
    private javax.swing.JPanel jpnlTitle;
    private javax.swing.JPanel jpnlVentaMenuOptions;
    private javax.swing.JTextArea jtaHelpText;
    // End of variables declaration//GEN-END:variables

    private void configureControls() {
        if (parent.jtblVenta.getRowCount() == 0) {
            this.jbtnCancelOrder.setEnabled(false);
            this.jbtnCredit.setEnabled(false);
        }
        this.setTags();
        this.setLocationRelativeTo(null);

        java.awt.event.ActionListener al = new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayHelp(evt.getSource());
            }
        };

        this.jbtnCancelOrder.addActionListener(al);
        this.jbtnCut.addActionListener(al);
        this.jbtnCashCount.addActionListener(al);
        this.jbtnCredit.addActionListener(al);
        this.jbtnPayWithCredit.addActionListener(al);
        this.jbtnPrintTicket.addActionListener(al);


        KeyStroke esc = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        Action escPressed = new AbstractAction("esc") {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };
        jlblSelectOptionTitle.getActionMap().put("escPressed", escPressed);
        jlblSelectOptionTitle.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(esc, "escPressed");

        boolean isOptionEnabled;

        isOptionEnabled = Boolean.valueOf(ParamHelper.getParam("jfrmVentaMenu.canelOrder_enabled").toString());
        this.jbtnCancelOrder.setVisible(isOptionEnabled);

        isOptionEnabled = Boolean.valueOf(ParamHelper.getParam("jfrmVentaMenu.cashCount_enabled").toString()) && Util.getCurrentUser().isIs_admin();
        this.jbtnCashCount.setVisible(isOptionEnabled);

        isOptionEnabled = Boolean.valueOf(ParamHelper.getParam("jfrmVentaMenu.cashCut_enabled").toString());
        this.jbtnCut.setVisible(isOptionEnabled);

        isOptionEnabled = Boolean.valueOf(ParamHelper.getParam("jfrmVentaMenu.credit_enabled").toString());
        this.jbtnCredit.setVisible(isOptionEnabled);

        isOptionEnabled = Boolean.valueOf(ParamHelper.getParam("jfrmVentaMenu.payWithCredit_enabled").toString());
        this.jbtnPayWithCredit.setVisible(isOptionEnabled);

        isOptionEnabled = Boolean.valueOf(ParamHelper.getParam("jfrmVentaMenu.printTicket_enabled").toString());
        this.jbtnPrintTicket.setVisible(isOptionEnabled);
    }

    private void setTags() {
        this.optionSelected = "";
        this.jlblSelectOptionTitle.setText(TagHelper.getTag("jfrmVentaMenu.selectOptionTitle"));
        this.jtaHelpText.setText(TagHelper.getTag("jfrmVentaMenu.helpInstructions"));
        this.jlblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/help.png")));

        this.jbtnCancelOrder.setText(TagHelper.getTag("jfrmVentaMenu.CancelOrderTitle"));
        this.jbtnCut.setText(TagHelper.getTag("jfrmVentaMenu.Cut"));
        this.jbtnCashCount.setText(TagHelper.getTag("jfrmVentaMenu.CashCount"));
        this.jbtnCredit.setText(TagHelper.getTag("jfrmVentaMenu.credit"));
        this.jbtnPayWithCredit.setText(TagHelper.getTag("jfrmVentaMenu.payWithcredit"));
    }

    private void displayHelp(Object obj) {

        JButton btn = (JButton) obj;

        Icon icon = btn.getIcon();
        this.jlblIcon.setIcon(icon);

        optionSelected = btn.getName();

        switch (optionSelected) {
            case "jbtnCancelOrder":
                this.jtaHelpText.setText(TagHelper.getTag("jfrmVentaMenu.CancelOrderHelp"));
                break;
            case "jbtnCut":
                this.jtaHelpText.setText(TagHelper.getTag("jfrmVentaMenu.CutHelp"));
                break;
            case "jbtnCashCount":
                this.jtaHelpText.setText(TagHelper.getTag("jfrmVentaMenu.CashCountHelp"));
                break;
            case "jbtnCredit":
                this.jtaHelpText.setText(TagHelper.getTag("jfrmVentaMenu.creditHelp"));
                break;
            case "jbtnPayWithCredit":
                this.jtaHelpText.setText(TagHelper.getTag("jfrmVentaMenu.payWithcreditHelp"));
                break;
            case "jbtnPrintTicket":
                this.jtaHelpText.setText(TagHelper.getTag("jfrmVentaMenu.printTicketHelp"));
                break;
        }
    }
}