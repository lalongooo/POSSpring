package com.puntodeventa.mvc.Views;

import com.puntodeventa.global.Entity.Venta;
import com.puntodeventa.global.Util.LogHelper;
import com.puntodeventa.global.Util.TagHelper;
import com.puntodeventa.global.Util.Util;
import com.puntodeventa.global.Util.ValidacionForms;
import com.puntodeventa.global.printservice.POSPrintService;
import com.puntodeventa.mvc.Controller.VentaLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import org.icepdf.core.exceptions.PDFSecurityException;

/**
 * @author USER
 */
public class jfrmVentaMenuPrintTicket extends javax.swing.JDialog {

    private ValidacionForms valid = new ValidacionForms();
    private final LogHelper objLog = new LogHelper("jfrmVentaMenuPrintTicket");

    public jfrmVentaMenuPrintTicket(jfrmVenta parent, boolean modal) {
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

        this.jlblPrintTicketTitle.setText(TagHelper.getTag("jfrmVentaMenuPrintTicket.jlblPrintTicketTitle"));
        this.jBtnLastTicket.setText(TagHelper.getTag("jfrmVentaMenuPrintTicket.jBtnLastTicket"));
        this.jBtnTicketByNumber.setText(TagHelper.getTag("jfrmVentaMenuPrintTicket.jBtnTicketByNumber"));

        this.jlblFechaTitle.setText(TagHelper.getTag("generaltag.FechaTitle"));
        this.jlblHoraTitle.setText(TagHelper.getTag("generaltag.HoraTitle"));
        this.jlblFecha.setText(TagHelper.getTag("generaltag.FechaDflt"));
        this.jlblHora.setText(TagHelper.getTag("generaltag.HoraDflt"));
    }

    private void initEvents() {
        
        
        
        java.awt.event.ActionListener al = new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JButton btn = (JButton) e.getSource();
                VentaLogic vl = new VentaLogic();
                String ticketNumber = "";

                switch (btn.getName()) {
                    case "jBtnLastTicket":
                        ticketNumber = String.valueOf(vl.getLastTicketNumber());
                        break;
                    case "jBtnTicketByNumber":
                        ticketNumber = valid.msjInput(TagHelper.getTag("jfrmVentaMenuPrintTicket.typeTicketNumber"), TagHelper.getTag("jfrmVentaMenuPrintTicket.typeTicketNumberTitle"));
                        if (!Util.isNumeric(ticketNumber)) {
                            valid.msjErr(TagHelper.getTag("jfrmVentaMenuPrintTicket.typeACorrectNumber"));
                        }
                        break;
                }
                
                if (Util.isNumeric(ticketNumber)) {
                    try {
                        Venta v = vl.getVenta(Integer.parseInt(ticketNumber));
                        POSPrintService.printTicket(v);
                    } catch (NumberFormatException ex) {
                        objLog.Log(ex.getMessage());
                    }
                }
            }
        };
        
        this.jBtnLastTicket.addActionListener(al);
        this.jBtnTicketByNumber.addActionListener(al);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblPrintTicketTitle = new javax.swing.JLabel();
        jlblFechaTitle = new javax.swing.JLabel();
        jlblFecha = new javax.swing.JLabel();
        jlblHoraTitle = new javax.swing.JLabel();
        jlblHora = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jBtnLastTicket = new javax.swing.JButton();
        jBtnTicketByNumber = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jlblPrintTicketTitle.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jlblPrintTicketTitle.setText("Impresión de ticket");
        jlblPrintTicketTitle.setName("jlblPrintTicketTitle"); // NOI18N

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

        jBtnLastTicket.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtnLastTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconDone.png"))); // NOI18N
        jBtnLastTicket.setText("Último ticket");
        jBtnLastTicket.setMaximumSize(new java.awt.Dimension(93, 29));
        jBtnLastTicket.setMinimumSize(new java.awt.Dimension(93, 29));
        jBtnLastTicket.setName("jBtnLastTicket"); // NOI18N
        jBtnLastTicket.setPreferredSize(new java.awt.Dimension(93, 29));

        jBtnTicketByNumber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtnTicketByNumber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconDone.png"))); // NOI18N
        jBtnTicketByNumber.setText("No. de ticket");
        jBtnTicketByNumber.setMaximumSize(new java.awt.Dimension(93, 29));
        jBtnTicketByNumber.setMinimumSize(new java.awt.Dimension(93, 29));
        jBtnTicketByNumber.setName("jBtnTicketByNumber"); // NOI18N
        jBtnTicketByNumber.setPreferredSize(new java.awt.Dimension(93, 29));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnLastTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnTicketByNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnLastTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnTicketByNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(jlblPrintTicketTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
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
                    .addComponent(jlblPrintTicketTitle)
                    .addComponent(jlblFechaTitle)
                    .addComponent(jlblFecha)
                    .addComponent(jlblHoraTitle)
                    .addComponent(jlblHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnLastTicket;
    private javax.swing.JButton jBtnTicketByNumber;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlblFecha;
    private javax.swing.JLabel jlblFechaTitle;
    private javax.swing.JLabel jlblHora;
    private javax.swing.JLabel jlblHoraTitle;
    private javax.swing.JLabel jlblPrintTicketTitle;
    // End of variables declaration//GEN-END:variables
}