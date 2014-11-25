package com.puntodeventa.mvc.Views;

import com.puntodeventa.global.Util.TagHelper;
import com.puntodeventa.global.Util.Util;
import com.puntodeventa.global.Util.ValidacionForms;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Calendar;

/**
 * @author USER
 */
public class jfrmVentaMenuArqueo extends javax.swing.JDialog {

    private ValidacionForms valid = new ValidacionForms();

    public jfrmVentaMenuArqueo(jfrmVenta parent, boolean modal) {
        super(parent, modal);
        initComponents();
        configureControls();
        setClock();
    }

    private void setClock() {
        javax.swing.Timer t = new javax.swing.Timer(1000,
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Calendar now = Calendar.getInstance();
                        int h = now.get(Calendar.HOUR_OF_DAY);
                        int m = now.get(Calendar.MINUTE);

                        String hr = h < 10 ? "0" + h : "" + h;
                        String mn = m < 10 ? "0" + m : "" + m;

                        jlblHora.setText("" + hr + ":" + mn);

                        int d = now.get(Calendar.DAY_OF_MONTH);
                        int mo = now.get(Calendar.MONTH) + 1;
                        int y = now.get(Calendar.YEAR);

                        String day = d < 10 ? "0" + d : "" + d;
                        String month = mo < 10 ? "0" + mo : "" + mo;

                        jlblFecha.setText("" + day + "/" + month + "/" + y);
                    }
                });
        t.start();
    }

    private void configureControls() {
        this.setTags();
        this.setLocationRelativeTo(null);
        this.initEvents();
    }

    private void setTags() {
        this.jlblArqueoTitle.setText(TagHelper.getTag("jfrmVentaMenuArqueo.CashCountTitle"));
        this.jlblFechaTitle.setText(TagHelper.getTag("jfrmVentaMenuCorte.FechaTitle"));
        this.jlblHoraTitle.setText(TagHelper.getTag("jfrmVentaMenuCorte.HoraTitle"));
        this.jlblInitialCashTitle.setText(TagHelper.getTag("jfrmVentaMenuCorte.InitialCashTitle"));
        this.jlblCashTitle.setText(TagHelper.getTag("jfrmVentaMenuCorte.CashTitle"));
        this.jBtnCashCount.setText(TagHelper.getTag("jfrmVentaMenuArqueo.btnCashCount"));
        this.jlblFecha.setText(TagHelper.getTag("jfrmVentaMenuCorte.FechaDflt"));
        this.jlblHora.setText(TagHelper.getTag("jfrmVentaMenuCorte.HoraDflt"));
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
                            jBtnCashCount.doClick();
                            break;
                    }
                }
            }
        };
        this.jtxtCash.addKeyListener(ka);
        this.jtxtInitialCash.addKeyListener(ka);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblArqueoTitle = new javax.swing.JLabel();
        jlblFechaTitle = new javax.swing.JLabel();
        jlblFecha = new javax.swing.JLabel();
        jlblHoraTitle = new javax.swing.JLabel();
        jlblHora = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jlblInitialCashTitle = new javax.swing.JLabel();
        jlblCashTitle = new javax.swing.JLabel();
        jtxtInitialCash = new javax.swing.JTextField();
        jtxtCash = new javax.swing.JTextField();
        jBtnCashCount = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jlblArqueoTitle.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jlblArqueoTitle.setText("Arqueo de caja");

        jlblFechaTitle.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jlblFechaTitle.setText("Fecha:");

        jlblFecha.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jlblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblFecha.setText("01/01/2013");

        jlblHoraTitle.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jlblHoraTitle.setText("Hora:");

        jlblHora.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jlblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblHora.setText("12:01");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlblInitialCashTitle.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jlblInitialCashTitle.setText("Saldo inicial: $");

        jlblCashTitle.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jlblCashTitle.setText("Efectivo en caja: $");

        jtxtInitialCash.setName("jtxtInitialCash"); // NOI18N

        jtxtCash.setName("jtxtCash"); // NOI18N

        jBtnCashCount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtnCashCount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconDone.png"))); // NOI18N
        jBtnCashCount.setText("Realizar arqueo");
        jBtnCashCount.setMaximumSize(new java.awt.Dimension(93, 29));
        jBtnCashCount.setMinimumSize(new java.awt.Dimension(93, 29));
        jBtnCashCount.setPreferredSize(new java.awt.Dimension(93, 29));
        jBtnCashCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCashCountActionPerformed(evt);
            }
        });

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
                        .addComponent(jtxtCash, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtnCashCount, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblInitialCashTitle)
                    .addComponent(jtxtInitialCash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblCashTitle)
                    .addComponent(jtxtCash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnCashCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlblArqueoTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(jlblFechaTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblHoraTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblArqueoTitle)
                    .addComponent(jlblFechaTitle)
                    .addComponent(jlblFecha)
                    .addComponent(jlblHoraTitle)
                    .addComponent(jlblHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCashCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCashCountActionPerformed
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
            String msg = TagHelper.getTag("jfrmVentaMenuArqueo.confrMessage").toString();
            msg = msg.replace("#", initialCash.length() > 0 ? initialCash : "0");
            msg = msg.replace("@", cash);

            int op = valid.msjOption(msg, TagHelper.getTag("jfrmVentaMenuCorte.ConfMsgTitle"));

            if (op == 0) {

                dispose();
                double efvoInicial, efvoCaja;
                efvoInicial = initialCash.length() > 0 ? Double.valueOf(initialCash) : 0;
                efvoCaja = Double.valueOf(cash);

                jfrmVentaMenuArqueoInfo arqueoInfo = new jfrmVentaMenuArqueoInfo(null, true, efvoInicial, efvoCaja);
                arqueoInfo.setVisible(true);
            }
        }
    }//GEN-LAST:event_jBtnCashCountActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCashCount;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlblArqueoTitle;
    private javax.swing.JLabel jlblCashTitle;
    private javax.swing.JLabel jlblFecha;
    private javax.swing.JLabel jlblFechaTitle;
    private javax.swing.JLabel jlblHora;
    private javax.swing.JLabel jlblHoraTitle;
    private javax.swing.JLabel jlblInitialCashTitle;
    private javax.swing.JTextField jtxtCash;
    private javax.swing.JTextField jtxtInitialCash;
    // End of variables declaration//GEN-END:variables
}