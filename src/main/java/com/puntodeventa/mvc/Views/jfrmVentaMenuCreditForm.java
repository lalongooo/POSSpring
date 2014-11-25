package com.puntodeventa.mvc.Views;

import com.puntodeventa.global.Entity.Cliente;
import com.puntodeventa.global.Entity.Munic;
import com.puntodeventa.global.Interface.IFormFunctionality;
import com.puntodeventa.global.Util.JComboBoxItem;
import com.puntodeventa.global.Util.ParamHelper;
import com.puntodeventa.global.Util.TagHelper;
import com.puntodeventa.global.Util.ValidacionForms;
import com.puntodeventa.services.DAO.ClienteDAO;
import com.puntodeventa.services.DAO.MunicDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

/**
 * @author USER
 */
public class jfrmVentaMenuCreditForm extends javax.swing.JDialog implements IFormFunctionality {

    private ValidacionForms valid = new ValidacionForms();
    private MunicDAO municDao = new MunicDAO();

    public jfrmVentaMenuCreditForm(jfrmVenta parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setClock();
        init();
    }

    private void init() {
        this.configureControls();
        this.setTags();
        this.initEvents();
        this.setInitialValues();
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

    @Override
    public void configureControls() {

        this.setLocationRelativeTo(null);

        this.jtxtCreditOwnerAddNumber.setMaxLength(Integer.parseInt(ParamHelper.getParam("jfrmVentaMenuCreditForm.jtxtCreditOwnerAddNumber").toString()));
        this.jtxtCreditOwnerAddNumber.setRequired(true);

        this.jtxtCreditOwnerColony.setMaxLength(Integer.parseInt(ParamHelper.getParam("jfrmVentaMenuCreditForm.jtxtCreditOwnerColony").toString()));
        this.jtxtCreditOwnerColony.setRequired(true);

        this.jtxtCreditOwnerStreet.setMaxLength(Integer.parseInt(ParamHelper.getParam("jfrmVentaMenuCreditForm.jtxtCreditOwnerStreet").toString()));
        this.jtxtCreditOwnerStreet.setRequired(true);

        this.jtxtFirstLastCreditOwner.setMaxLength(Integer.parseInt(ParamHelper.getParam("jfrmVentaMenuCreditForm.jtxtFirstLastCreditOwner").toString()));
        this.jtxtFirstLastCreditOwner.setRequired(true);

        this.jtxtNameCreditOwner.setMaxLength(Integer.parseInt(ParamHelper.getParam("jfrmVentaMenuCreditForm.jtxtNameCreditOwner").toString()));
        this.jtxtNameCreditOwner.setRequired(true);

        this.jtxtSecondLastCreditOwner.setMaxLength(Integer.parseInt(ParamHelper.getParam("jfrmVentaMenuCreditForm.jtxtSecondLastCreditOwner").toString()));
        this.jtxtSecondLastCreditOwner.setRequired(true);
    }

    @Override
    public void setTags() {
        this.jlblCreditSaleTitle.setText(TagHelper.getTag("jfrmVentaMenuCreditForm.CreditFormTitle"));
        this.jlblFechaTitle.setText(TagHelper.getTag("generaltag.FechaTitle"));
        this.jlblHoraTitle.setText(TagHelper.getTag("generaltag.HoraTitle"));
        this.jlblFecha.setText(TagHelper.getTag("generaltag.FechaDflt"));
        this.jlblHora.setText(TagHelper.getTag("generaltag.HoraDflt"));
        this.jlblNameCreditOwner.setText(TagHelper.getTag("jfrmVentaMenuCreditForm.jlblNameCreditOwner"));
        this.jlblFirstLastNameCreditOwner.setText(TagHelper.getTag("jfrmVentaMenuCreditForm.jlblFirstLastNameCreditOwner"));
        this.jlblSecondLastNameCreditOwner.setText(TagHelper.getTag("jfrmVentaMenuCreditForm.jlblSecondLastNameCreditOwner"));
        this.jlblCreditOwnerStreet.setText(TagHelper.getTag("jfrmVentaMenuCreditForm.jlblCreditOwnerStreet"));
        this.jlblCreditOwnerAddNumber.setText(TagHelper.getTag("jfrmVentaMenuCreditForm.jlblCreditOwnerAddNumber"));
        this.jlblCreditOwnerColony.setText(TagHelper.getTag("jfrmVentaMenuCreditForm.jlblCreditOwnerColony"));
        this.jlblCreditOwnerMunicipy.setText(TagHelper.getTag("jfrmVentaMenuCreditForm.jlblCreditOwnerMunicipy"));
        this.jlblCreditDatePayment.setText(TagHelper.getTag("jfrmVentaMenuCreditForm.jlblCreditDatePayment"));
    }

    @Override
    public void initEvents() {

        java.awt.event.KeyAdapter kaLetters = new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                valid.soloLetras(evt);
            }
        };

        java.awt.event.KeyAdapter kaNumbers = new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                valid.soloNumeros(evt);
            }
        };

        this.jtxtNameCreditOwner.addKeyListener(kaLetters);
        this.jtxtFirstLastCreditOwner.addKeyListener(kaLetters);
        this.jtxtSecondLastCreditOwner.addKeyListener(kaLetters);

        this.jtxtCreditOwnerAddNumber.addKeyListener(kaNumbers);

    }

    @Override
    public void setInitialValues() {


        this.jtxtNameCreditOwner.setDefaultText(TagHelper.getTag("jfrmVentaMenuCreditForm.jtxtNameCreditOwnerDfltText"));
        this.jtxtFirstLastCreditOwner.setDefaultText(TagHelper.getTag("jfrmVentaMenuCreditForm.jtxtFirstLastCreditOwnerDfltText"));
        this.jtxtSecondLastCreditOwner.setDefaultText(TagHelper.getTag("jfrmVentaMenuCreditForm.jtxtSecondLastCreditOwnerDfltText"));
        this.jtxtCreditOwnerStreet.setDefaultText(TagHelper.getTag("jfrmVentaMenuCreditForm.jtxtCreditOwnerStreetDfltText"));
        this.jtxtCreditOwnerAddNumber.setDefaultText(TagHelper.getTag("jfrmVentaMenuCreditForm.jtxtCreditOwnerAddNumberDfltText"));
        this.jtxtCreditOwnerColony.setDefaultText(TagHelper.getTag("jfrmVentaMenuCreditForm.jtxtCreditOwnerColonyDfltText"));

        this.jdtDatePayment.cleanup();

        //Fill Munics combo        
        if (this.jcmbCreditOwnerMunicipy.getItemCount() > 0) {
            this.jcmbCreditOwnerMunicipy.removeAllItems();
        }
        List<Munic> munics = municDao.listMunic();
        JComboBoxItem item;
        for (int i = 0; i < munics.size(); i++) {
            item = new JComboBoxItem(String.valueOf(munics.get(i).getpIdMunic()), munics.get(i).getpName());
            this.jcmbCreditOwnerMunicipy.addItem(item);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblCreditSaleTitle = new javax.swing.JLabel();
        jlblFechaTitle = new javax.swing.JLabel();
        jlblFecha = new javax.swing.JLabel();
        jlblHoraTitle = new javax.swing.JLabel();
        jlblHora = new javax.swing.JLabel();
        jpnlAddress = new javax.swing.JPanel();
        jlblCreditOwnerStreet = new javax.swing.JLabel();
        jtxtCreditOwnerStreet = new com.puntodeventa.global.Util.Extended.JTextFieldExtended();
        jlblCreditOwnerAddNumber = new javax.swing.JLabel();
        jtxtCreditOwnerAddNumber = new com.puntodeventa.global.Util.Extended.JTextFieldExtended();
        jlblCreditOwnerMunicipy = new javax.swing.JLabel();
        jlblCreditOwnerColony = new javax.swing.JLabel();
        jcmbCreditOwnerMunicipy = new javax.swing.JComboBox();
        jtxtCreditOwnerColony = new com.puntodeventa.global.Util.Extended.JTextFieldExtended();
        jpnlName = new javax.swing.JPanel();
        jlblNameCreditOwner = new javax.swing.JLabel();
        jtxtNameCreditOwner = new com.puntodeventa.global.Util.Extended.JTextFieldExtended();
        jlblFirstLastNameCreditOwner = new javax.swing.JLabel();
        jlblSecondLastNameCreditOwner = new javax.swing.JLabel();
        jtxtFirstLastCreditOwner = new com.puntodeventa.global.Util.Extended.JTextFieldExtended();
        jtxtSecondLastCreditOwner = new com.puntodeventa.global.Util.Extended.JTextFieldExtended();
        jlblCreditDatePayment = new javax.swing.JLabel();
        jdtDatePayment = new com.toedter.calendar.JDateChooser();
        jbtnSaveCredit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jlblCreditSaleTitle.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jlblCreditSaleTitle.setText("Venta a crédito");
        jlblCreditSaleTitle.setName("jlblCreditSaleTitle"); // NOI18N

        jlblFechaTitle.setText("Fecha:");

        jlblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblFecha.setText("01/01/2013");

        jlblHoraTitle.setText("Hora:");

        jlblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblHora.setText("12:01");

        jpnlAddress.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), TagHelper.getTag("jfrmVentaMenuCreditForm.jlblCreditOwnerAddressTitle")));

        jlblCreditOwnerStreet.setText("Calle:");
        jlblCreditOwnerStreet.setName("jlblCreditOwnerStreet"); // NOI18N

        jtxtCreditOwnerStreet.setName("jtxtCreditOwnerStreet"); // NOI18N

        jlblCreditOwnerAddNumber.setText("Número:");
        jlblCreditOwnerAddNumber.setName("jlblCreditOwnerAddNumber"); // NOI18N

        jtxtCreditOwnerAddNumber.setName("jtxtCreditOwnerAddNumber"); // NOI18N

        jlblCreditOwnerMunicipy.setText("Municipio:");
        jlblCreditOwnerMunicipy.setToolTipText("");
        jlblCreditOwnerMunicipy.setName("jlblCreditOwnerMunicipy"); // NOI18N

        jlblCreditOwnerColony.setText("Colonia:");
        jlblCreditOwnerColony.setName("jlblCreditOwnerColony"); // NOI18N

        jcmbCreditOwnerMunicipy.setName("jlblCreditOwnerMunicipy"); // NOI18N

        jtxtCreditOwnerColony.setName("jtxtCreditOwnerColony"); // NOI18N

        javax.swing.GroupLayout jpnlAddressLayout = new javax.swing.GroupLayout(jpnlAddress);
        jpnlAddress.setLayout(jpnlAddressLayout);
        jpnlAddressLayout.setHorizontalGroup(
            jpnlAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlAddressLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblCreditOwnerStreet)
                    .addComponent(jlblCreditOwnerColony)
                    .addComponent(jlblCreditOwnerMunicipy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcmbCreditOwnerMunicipy, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnlAddressLayout.createSequentialGroup()
                        .addComponent(jtxtCreditOwnerStreet, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblCreditOwnerAddNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtCreditOwnerAddNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtxtCreditOwnerColony, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jpnlAddressLayout.setVerticalGroup(
            jpnlAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlAddressLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblCreditOwnerStreet)
                    .addComponent(jtxtCreditOwnerStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCreditOwnerAddNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblCreditOwnerAddNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblCreditOwnerColony)
                    .addComponent(jtxtCreditOwnerColony, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblCreditOwnerMunicipy)
                    .addComponent(jcmbCreditOwnerMunicipy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpnlName.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), TagHelper.getTag("jfrmVentaMenuCreditForm.jlblCreditOwnerTitle")));
        jpnlName.setPreferredSize(new java.awt.Dimension(233, 120));

        jlblNameCreditOwner.setText("Nombre:");
        jlblNameCreditOwner.setName("jlblNameCreditOwner"); // NOI18N

        jtxtNameCreditOwner.setName("jtxtNameCreditOwner"); // NOI18N

        jlblFirstLastNameCreditOwner.setText("Apellido paterno:");
        jlblFirstLastNameCreditOwner.setName("jlblFirstLastNameCreditOwner"); // NOI18N

        jlblSecondLastNameCreditOwner.setText("Apellido materno:");
        jlblSecondLastNameCreditOwner.setName("jlblSecondLastNameCreditOwner"); // NOI18N

        jtxtFirstLastCreditOwner.setName("jtxtFirstLastCreditOwner"); // NOI18N

        jtxtSecondLastCreditOwner.setName("jtxtSecondLastCreditOwner"); // NOI18N

        javax.swing.GroupLayout jpnlNameLayout = new javax.swing.GroupLayout(jpnlName);
        jpnlName.setLayout(jpnlNameLayout);
        jpnlNameLayout.setHorizontalGroup(
            jpnlNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlNameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlNameLayout.createSequentialGroup()
                        .addComponent(jlblNameCreditOwner)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtNameCreditOwner))
                    .addGroup(jpnlNameLayout.createSequentialGroup()
                        .addGroup(jpnlNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblSecondLastNameCreditOwner)
                            .addComponent(jlblFirstLastNameCreditOwner))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnlNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtFirstLastCreditOwner, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                            .addComponent(jtxtSecondLastCreditOwner))))
                .addContainerGap())
        );
        jpnlNameLayout.setVerticalGroup(
            jpnlNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlNameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblNameCreditOwner)
                    .addComponent(jtxtNameCreditOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblFirstLastNameCreditOwner)
                    .addComponent(jtxtFirstLastCreditOwner))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblSecondLastNameCreditOwner)
                    .addComponent(jtxtSecondLastCreditOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jlblCreditDatePayment.setText("Fecha de pago:");
        jlblCreditDatePayment.setToolTipText("");
        jlblCreditDatePayment.setName("jlblCreditDatePayment"); // NOI18N

        jbtnSaveCredit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSaveCredit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconDone.png"))); // NOI18N
        jbtnSaveCredit.setText("Guardar");
        jbtnSaveCredit.setMaximumSize(new java.awt.Dimension(93, 29));
        jbtnSaveCredit.setMinimumSize(new java.awt.Dimension(93, 29));
        jbtnSaveCredit.setPreferredSize(new java.awt.Dimension(93, 29));
        jbtnSaveCredit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveCreditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlblCreditSaleTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                        .addComponent(jlblFechaTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblHoraTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpnlName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                    .addComponent(jpnlAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jlblCreditDatePayment, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jdtDatePayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnSaveCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblCreditSaleTitle)
                    .addComponent(jlblFechaTitle)
                    .addComponent(jlblFecha)
                    .addComponent(jlblHoraTitle)
                    .addComponent(jlblHora))
                .addGap(18, 18, 18)
                .addComponent(jpnlName, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnlAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdtDatePayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblCreditDatePayment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jbtnSaveCredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSaveCreditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveCreditActionPerformed

        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();

        cliente.setName(jtxtNameCreditOwner.getText());
        cliente.setAp(this.jtxtFirstLastCreditOwner.getText());
        cliente.setAm(this.jtxtSecondLastCreditOwner.getText());
        cliente.setStreetNumber(Integer.parseInt(this.jtxtCreditOwnerAddNumber.getText()));
        cliente.setStreet(this.jtxtCreditOwnerStreet.getText());
        cliente.setColony(this.jtxtCreditOwnerColony.getText());

        JComboBoxItem municSelected = (JComboBoxItem) this.jcmbCreditOwnerMunicipy.getSelectedItem();
        cliente.setMunic(
                municDao.selectMunic(
                Integer.valueOf(municSelected.getValue())));

        cliente.setDatePayment(this.jdtDatePayment.getDate());
        int clientId = clienteDAO.saveCliente(cliente);

        if (clientId > 0) {
            valid.msjInfo(this, TagHelper.getTag("jfrmVentaMenuCreditForm.clientRegistered"));
            this.setInitialValues();
        } else {
            valid.msjInfo(this, TagHelper.getTag("jfrmVentaMenuCreditForm.clientNOTRegistered"));
        }


    }//GEN-LAST:event_jbtnSaveCreditActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnSaveCredit;
    private javax.swing.JComboBox jcmbCreditOwnerMunicipy;
    private com.toedter.calendar.JDateChooser jdtDatePayment;
    private javax.swing.JLabel jlblCreditDatePayment;
    private javax.swing.JLabel jlblCreditOwnerAddNumber;
    private javax.swing.JLabel jlblCreditOwnerColony;
    private javax.swing.JLabel jlblCreditOwnerMunicipy;
    private javax.swing.JLabel jlblCreditOwnerStreet;
    private javax.swing.JLabel jlblCreditSaleTitle;
    private javax.swing.JLabel jlblFecha;
    private javax.swing.JLabel jlblFechaTitle;
    private javax.swing.JLabel jlblFirstLastNameCreditOwner;
    private javax.swing.JLabel jlblHora;
    private javax.swing.JLabel jlblHoraTitle;
    private javax.swing.JLabel jlblNameCreditOwner;
    private javax.swing.JLabel jlblSecondLastNameCreditOwner;
    private javax.swing.JPanel jpnlAddress;
    private javax.swing.JPanel jpnlName;
    private com.puntodeventa.global.Util.Extended.JTextFieldExtended jtxtCreditOwnerAddNumber;
    private com.puntodeventa.global.Util.Extended.JTextFieldExtended jtxtCreditOwnerColony;
    private com.puntodeventa.global.Util.Extended.JTextFieldExtended jtxtCreditOwnerStreet;
    private com.puntodeventa.global.Util.Extended.JTextFieldExtended jtxtFirstLastCreditOwner;
    private com.puntodeventa.global.Util.Extended.JTextFieldExtended jtxtNameCreditOwner;
    private com.puntodeventa.global.Util.Extended.JTextFieldExtended jtxtSecondLastCreditOwner;
    // End of variables declaration//GEN-END:variables
}