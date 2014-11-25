package com.puntodeventa.mvc.Views;

import com.puntodeventa.global.Util.TagHelper;
import com.puntodeventa.mvc.Controller.VentaLogic;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

/**
 * @author USER
 */
public class jfrmVentaMenuArqueoInfo extends javax.swing.JDialog {
    
    private double efvoInicial, efvoCaja;

    public jfrmVentaMenuArqueoInfo(jfrmVenta parent, boolean modal, double initialCash, double cash) {
        super(parent, modal);
        this.efvoCaja = cash;
        this.efvoInicial = initialCash;
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
    }

    private void setTags() {
        this.jlblArqueoInfoTitle.setText(TagHelper.getTag("jfrmVentaMenuArqueoInfo.reportTitle"));
        this.jlblFechaTitle.setText(TagHelper.getTag("jfrmVentaMenuCorte.FechaTitle"));
        this.jlblHoraTitle.setText(TagHelper.getTag("jfrmVentaMenuCorte.HoraTitle"));
        this.jlblFecha.setText(TagHelper.getTag("jfrmVentaMenuCorte.FechaDflt"));
        this.jlblHora.setText(TagHelper.getTag("jfrmVentaMenuCorte.HoraDflt"));
        
        VentaLogic lgc = new VentaLogic();
        double totals = lgc.getTotalUserForCashCount();
        double desv = this.efvoCaja-totals;        
        
        this.jtxtInitialCash.setText("" + this.efvoInicial);
        this.jtxtCash.setText("" + this.efvoCaja);
        this.jtxtTotals.setText("" + totals);
        this.jtxtDesv.setText("" + desv);
        
        if(desv < 0 || desv > 0){
            jtxtDesv.setForeground(Color.RED);
        }else{
            jtxtDesv.setForeground(Color.GREEN);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlblArqueoInfoTitle = new javax.swing.JLabel();
        jlblFechaTitle = new javax.swing.JLabel();
        jlblFecha = new javax.swing.JLabel();
        jlblHoraTitle = new javax.swing.JLabel();
        jlblHora = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlblCashTitle = new javax.swing.JLabel();
        jlblTotalsTitle = new javax.swing.JLabel();
        jtxtCash = new javax.swing.JTextField();
        jtxtTotals = new javax.swing.JTextField();
        jlblDesvTitle = new javax.swing.JLabel();
        jtxtDesv = new javax.swing.JTextField();
        jlblInitialCashTitle = new javax.swing.JLabel();
        jtxtInitialCash = new javax.swing.JTextField();
        jBtnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlblArqueoInfoTitle.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jlblArqueoInfoTitle.setText("Información de arqueo de caja");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblArqueoInfoTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(jlblFechaTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblHoraTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblFechaTitle)
                    .addComponent(jlblFecha)
                    .addComponent(jlblHoraTitle)
                    .addComponent(jlblHora)
                    .addComponent(jlblArqueoInfoTitle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlblCashTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jlblCashTitle.setText("Efectivo en caja:");

        jlblTotalsTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jlblTotalsTitle.setText("Ventas totales:");

        jtxtCash.setEditable(false);
        jtxtCash.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtxtCash.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jtxtTotals.setEditable(false);
        jtxtTotals.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtxtTotals.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jlblDesvTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jlblDesvTitle.setText("Desviación:");

        jtxtDesv.setEditable(false);
        jtxtDesv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtxtDesv.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jlblInitialCashTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jlblInitialCashTitle.setText("Efectivo inicial:");

        jtxtInitialCash.setEditable(false);
        jtxtInitialCash.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtxtInitialCash.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jBtnEntrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconDone.png"))); // NOI18N
        jBtnEntrar.setText("Aceptar");
        jBtnEntrar.setMaximumSize(new java.awt.Dimension(93, 29));
        jBtnEntrar.setMinimumSize(new java.awt.Dimension(93, 29));
        jBtnEntrar.setPreferredSize(new java.awt.Dimension(93, 29));
        jBtnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlblTotalsTitle)
                            .addComponent(jlblCashTitle)
                            .addComponent(jlblDesvTitle)
                            .addComponent(jlblInitialCashTitle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtCash)
                            .addComponent(jtxtInitialCash, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtDesv)
                            .addComponent(jtxtTotals, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblInitialCashTitle)
                    .addComponent(jtxtInitialCash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblCashTitle)
                    .addComponent(jtxtCash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblTotalsTitle)
                    .addComponent(jtxtTotals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblDesvTitle)
                    .addComponent(jtxtDesv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jBtnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEntrarActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnEntrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnEntrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlblArqueoInfoTitle;
    private javax.swing.JLabel jlblCashTitle;
    private javax.swing.JLabel jlblDesvTitle;
    private javax.swing.JLabel jlblFecha;
    private javax.swing.JLabel jlblFechaTitle;
    private javax.swing.JLabel jlblHora;
    private javax.swing.JLabel jlblHoraTitle;
    private javax.swing.JLabel jlblInitialCashTitle;
    private javax.swing.JLabel jlblTotalsTitle;
    private javax.swing.JTextField jtxtCash;
    private javax.swing.JTextField jtxtDesv;
    private javax.swing.JTextField jtxtInitialCash;
    private javax.swing.JTextField jtxtTotals;
    // End of variables declaration//GEN-END:variables
}